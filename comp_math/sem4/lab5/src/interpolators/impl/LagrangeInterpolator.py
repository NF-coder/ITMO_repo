from utils.dataset import InterpolationDataset
from ..InerpolationResult import InterpolationResult
from typing_extensions import Self
from ..Interpolator import Interpolator


class LagrangeInterpolator(Interpolator):
    def build(self, dataset: InterpolationDataset) -> Self:
        self.dataset = dataset

        return self

    def evaluate(self, x_value: float) -> InterpolationResult:
        total = 0.0
        terms: list[str] = []

        for i, (x_i, y_i) in enumerate(zip(self.dataset.x, self.dataset.y)):
            basis = 1.0
            for j, x_j in enumerate(self.dataset.x):
                if i != j: basis *= (x_value - x_j) / (x_i - x_j)

            total += y_i * basis
            terms.append(f"y{i}l{i}={y_i * basis:.8f}")
        
        return InterpolationResult("многочлен Лагранжа", total, "; ".join(terms))
