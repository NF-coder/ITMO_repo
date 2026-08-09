from ..Interpolator import Interpolator
from utils.dataset import InterpolationDataset
from utils.differences import FiniteDifferenceTable
from ..InerpolationResult import InterpolationResult
from math import factorial, prod
from typing_extensions import Self

class NewtonInterpolator(Interpolator):
    def build(self, dataset: InterpolationDataset, differences: FiniteDifferenceTable) -> Self:
        self.dataset = dataset
        self.differences = differences
    
        if dataset.step is None:
            raise ValueError("Формула Ньютона с конечными разностями требует равноотстоящие узлы")
        
        return self

    def evaluate(self, x_value: float) -> InterpolationResult:
        middle = (self.dataset.x[0] + self.dataset.x[-1]) / 2

        if x_value <= middle: return self.evaluate_forward(x_value)

        return self.evaluate_backward(x_value)

    def evaluate_forward(self, x_value: float) -> InterpolationResult:
        h: float = self.dataset.step   # pyright: ignore

        t = (x_value - self.dataset.x[0]) / h
        
        total = self.dataset.y[0]
        terms = [f"y0={total:.8f}"]
        for order in range(1, len(self.dataset.x)):
            coefficient = prod(t - shift for shift in range(order)) / factorial(order)
            difference = self.differences.value(order, 0)
            
            total += coefficient * difference
            terms.append(f"k={order}: {coefficient:.8f}*{difference:.8f}")
        
        return InterpolationResult(
            "Первая формула Ньютона",
            total,
            f"t={t:.8f}; " + "; ".join(terms)
        )

    def evaluate_backward(self, x_value: float) -> InterpolationResult:
        h: float = self.dataset.step   # pyright: ignore

        n = len(self.dataset.x) - 1
        t = (x_value - self.dataset.x[-1]) / h
        
        total = self.dataset.y[-1]
        terms = [f"yn={total:.8f}"]
        for order in range(1, len(self.dataset.x)):
            coefficient = prod(t + shift for shift in range(order)) / factorial(order)
            difference = self.differences.value(order, n - order)
            
            total += coefficient * difference
            terms.append(f"k={order}: {coefficient:.8f}*{difference:.8f}")
        
        return InterpolationResult(
            "Вторая формула Ньютона",
            total,
            f"t={t:.8f}; " + "; ".join(terms)
        )

