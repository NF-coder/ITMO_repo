from utils.dataset import InterpolationDataset
from utils.differences import FiniteDifferenceTable
from ..InerpolationResult import InterpolationResult
from math import factorial, prod
from typing_extensions import Self
from ..Interpolator import Interpolator

class GaussInterpolator(Interpolator):
    def build(self, dataset: InterpolationDataset, differences: FiniteDifferenceTable) -> Self:
        self.dataset = dataset
        self.differences = differences

        if dataset.step is None:
            raise ValueError("формула Гаусса требует равноотстоящие узлы")
        if len(dataset.x) < 3:
            raise ValueError("для формулы Гаусса нужно не менее трех узлов")
        
        return self

    def evaluate(self, x_value: float) -> InterpolationResult:
        center = self._center_index(x_value)

        if x_value >= self.dataset.x[center]:
            return self.evaluate_first(x_value, center)
        
        return self.evaluate_second(x_value, center)

    def evaluate_first(self, x_value: float, center: int | None = None) -> InterpolationResult:
        center = self._center_index(x_value) if center is None else center
        h: float = self.dataset.step  # pyright: ignore

        t = (x_value - self.dataset.x[center]) / h
        total = self.dataset.y[center]
        terms = [f"y0={total:.8f}"]

        for order in range(1, len(self.dataset.x)):
            diff_index = center - order // 2
            
            if not self._has_difference(order, diff_index): break

            shifts = range((order - 1) // 2, -(order // 2) - 1, -1)
            coefficient = prod(t + shift for shift in shifts) / factorial(order)
            difference = self.differences.value(order, diff_index)
            
            total += coefficient * difference
            terms.append(f"k={order}: {coefficient:.8f}*{difference:.8f}")
        
        return InterpolationResult(
            "Первая формула Гаусса",
            total,
            f"a=x{center}, t={t:.8f}; " + "; ".join(terms)
        )

    def evaluate_second(self, x_value: float, center: int | None = None) -> InterpolationResult:
        center = self._center_index(x_value) if center is None else center
        h: float = self.dataset.step  # pyright: ignore

        t = (x_value - self.dataset.x[center]) / h
        total = self.dataset.y[center]
        terms = [f"y0={total:.8f}"]
        for order in range(1, len(self.dataset.x)):
            diff_index = center - (order + 1) // 2
            
            if not self._has_difference(order, diff_index): break
            
            shifts = range(order // 2, -((order - 1) // 2) - 1, -1)
            coefficient = prod(t + shift for shift in shifts) / factorial(order)
            difference = self.differences.value(order, diff_index)
            
            total += coefficient * difference
            terms.append(f"k={order}: {coefficient:.8f}*{difference:.8f}")
        
        return InterpolationResult(
            "Вторая формула Гаусса",
            total,
            f"a=x{center}, t={t:.8f}; " + "; ".join(terms)
        )

    def _center_index(self, x_value: float) -> int:
        return len(self.dataset.x) // 2

    def _has_difference(self, order: int, index: int) -> bool:
        return 0 <= order < len(self.differences.levels) and \
                0 <= index < len(self.differences.levels[order])
