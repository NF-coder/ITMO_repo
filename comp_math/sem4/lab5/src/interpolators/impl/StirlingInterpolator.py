from math import factorial, prod
from ..Interpolator import Interpolator
from utils.dataset import InterpolationDataset
from utils.differences import FiniteDifferenceTable
from ..InerpolationResult import InterpolationResult
from typing_extensions import Self


class StirlingInterpolator(Interpolator):
    def build(self, dataset: InterpolationDataset, differences: FiniteDifferenceTable) -> Self:
        self.dataset = dataset
        self.differences = differences
        
        if dataset.step is None:
            raise ValueError("Формула Стирлинга требует равноотстоящие узлы")

        if len(dataset.x) < 3 or len(dataset.x) % 2 == 0:
            raise ValueError("Формула Стирлинга строится по нечетному числу узлов")
        
        return self

    def evaluate(self, x_value: float) -> InterpolationResult:
        h: float = self.dataset.step  # pyright: ignore
        
        center = len(self.dataset.x) // 2
        t = (x_value - self.dataset.x[center]) / h
        total = self.dataset.y[center]
        terms = [f"y0={total:.8f}"]

        for order in range(1, len(self.dataset.x)):
            part = self._odd_term(order, center, t)  if order % 2 == 1 \
                else self._even_term(order, center, t)
            
            if part is None: break

            coefficient, difference = part
            total += coefficient * difference

            terms.append(f"k={order}: {coefficient:.8f}*{difference:.8f}")

        return InterpolationResult("формула Стирлинга", total, f"a=x{center}, t={t:.8f}; " + "; ".join(terms))

    def _odd_term(self, order: int, center: int, t: float) -> tuple[float, float] | None:
        m = (order + 1) // 2
        left_index = center - m
        right_index = center - m + 1

        if not self._has_difference(order, left_index) or not self._has_difference(order, right_index):
            return None
        
        coefficient = t * prod(t * t - j * j for j in range(1, m)) / factorial(order)
        difference = (self.differences.value(order, left_index) + self.differences.value(order, right_index)) / 2
        
        return coefficient, difference

    def _even_term(self, order: int, center: int, t: float) -> tuple[float, float] | None:
        m = order // 2
        diff_index = center - m

        if not self._has_difference(order, diff_index): return None

        coefficient = t * t * prod(t * t - j * j for j in range(1, m)) / factorial(order)
        difference = self.differences.value(order, diff_index)

        return coefficient, difference

    def _has_difference(self, order: int, index: int) -> bool:
        return 0 <= order < len(self.differences.levels) and 0 <= index < len(self.differences.levels[order])
