from math import factorial, prod
from ..Interpolator import Interpolator
from utils.dataset import InterpolationDataset
from utils.differences import FiniteDifferenceTable
from ..InerpolationResult import InterpolationResult
from typing_extensions import Self


class BesselInterpolator(Interpolator):
    def build(self, dataset: InterpolationDataset, differences: FiniteDifferenceTable) -> Self:
        self.dataset = dataset
        self.differences = differences

        if dataset.step is None:
            raise ValueError("формула Бесселя требует равноотстоящие узлы")
        if len(dataset.x) < 4:
            raise ValueError("для формулы Бесселя нужно не менее четырех узлов")
        
        return self

    def evaluate(self, x_value: float) -> InterpolationResult:
        h: float = self.dataset.step  # pyright: ignore
        
        base = self._base_index(x_value)
        t = (x_value - self.dataset.x[base]) / h
        total = (self.dataset.y[base] + self.dataset.y[base + 1]) / 2

        terms = [f"(y0+y1)/2={total:.8f}"]

        for order in range(1, len(self.dataset.x)):
            if order % 2 == 1:
                part = self._odd_term(order, base, t)
            else:
                part = self._even_term(order, base, t)
            if part is None:
                break

            coefficient, difference = part
            total += coefficient * difference
            terms.append(f"k={order}: {coefficient:.8f}*{difference:.8f}")

        return InterpolationResult("формула Бесселя", total, f"x0=x{base}, t={t:.8f}; " + "; ".join(terms))

    def _base_index(self, x_value: float) -> int:
        candidates = range(len(self.dataset.x) - 1)

        return max(
            candidates,
            key=lambda index: (self._available_terms(index), -abs(self._t_for(index, x_value) - 0.5)),
        )

    def _available_terms(self, base: int) -> int:
        count = 0
        for order in range(1, len(self.dataset.x)):
            part = self._odd_term(order, base, 0.5) \
                if order % 2 == 1 else self._even_term(order, base, 0.5)
            if part is None: break
            count += 1
        
        return count

    def _t_for(self, base: int, x_value: float) -> float:
        h: float = self.dataset.step  # pyright: ignore
        return (x_value - self.dataset.x[base]) / h

    def _odd_term(self, order: int, base: int, t: float) -> tuple[float, float] | None:
        m = (order - 1) // 2
        diff_index = base - m

        if not self._has_difference(order, diff_index):  return None
        
        coefficient = (t - 0.5) * prod((t + j) * (t - j - 1) for j in range(m)) / factorial(order)
        difference = self.differences.value(order, diff_index)
        
        return coefficient, difference

    def _even_term(self, order: int, base: int, t: float) -> tuple[float, float] | None:
        m = order // 2
        left_index = base - m
        right_index = base - m + 1

        if not self._has_difference(order, left_index) or not self._has_difference(order, right_index):
            return None
        
        coefficient = prod((t + j) * (t - j - 1) for j in range(m)) / factorial(order)
        difference = (self.differences.value(order, left_index) + self.differences.value(order, right_index)) / 2
        
        return coefficient, difference

    def _has_difference(self, order: int, index: int) -> bool:
        return 0 <= order < len(self.differences.levels) and 0 <= index < len(self.differences.levels[order])
