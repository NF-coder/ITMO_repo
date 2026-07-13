from pathlib import Path
import matplotlib.pyplot as plt

from utils.dataset import InterpolationDataset
from utils.differences import FiniteDifferenceTable
from interpolators import (
    BesselInterpolator,
    GaussInterpolator,
    LagrangeInterpolator,
    NewtonInterpolator,
    StirlingInterpolator,
)


class InterpolationPlotter:
    def __init__(self, dataset: InterpolationDataset) -> None:
        self.dataset = dataset

    def save(self, output_path: str | Path) -> Path:
        path = Path(output_path)
        path.parent.mkdir(parents=True, exist_ok=True)
        grid = self._grid(240)
        lagrange = LagrangeInterpolator().build(self.dataset)

        plt.figure(figsize=(8, 4.8))
        plt.scatter(self.dataset.x, self.dataset.y, color="#1f77b4", label="узлы", zorder=4)
        plt.plot(grid, [lagrange.evaluate(value).value for value in grid], color="#d62728", label="многочлен Лагранжа")
        
        if self.dataset.step is not None:
            differences = FiniteDifferenceTable(self.dataset)

            
            try:
                newton = NewtonInterpolator().build(self.dataset, differences)
                plt.plot(grid, [newton.evaluate(value).value for value in grid], "--", color="#2ca02c", label="многочлен Ньютона")
            except ValueError as e: 
                print("Пропуск:", e)
            
            try:
                gauss = GaussInterpolator().build(self.dataset, differences)
                plt.plot(grid, [gauss.evaluate(value).value for value in grid], ":", color="#9467bd", label="многочлен Гаусса")
            except ValueError as e: 
                print("Пропуск:", e)

            try:
                interpolator = StirlingInterpolator().build(self.dataset, differences)
                plt.plot(grid, [interpolator.evaluate(value).value for value in grid], "-.", color="#8c564b", alpha=0.7, label="многочлен Стирлинга")
            except ValueError as e: 
                print("Пропуск:", e)
    
            try:
                interpolator = BesselInterpolator().build(self.dataset, differences)
                plt.plot(grid, [interpolator.evaluate(value).value for value in grid], "-", color="#17becf", alpha=0.7, label="многочлен Бесселя")
            except ValueError as e: 
                print("Пропуск:", e)
            
        if self.dataset.source_function is not None:
            plt.plot(grid, [self.dataset.source_function(value) for value in grid], color="#ff7f0e", alpha=0.65, label="исходная функция")
        
        plt.title(self.dataset.name)
        plt.xlabel("x")
        plt.ylabel("y")
        plt.grid(True, alpha=0.25)
        plt.legend()
        plt.tight_layout()
        plt.savefig(path, dpi=180)
        plt.close()
        return path

    def _grid(self, count: int) -> list[float]:
        left = self.dataset.x[0]
        right = self.dataset.x[-1]
        step = (right - left) / (count - 1)
        return [left + i * step for i in range(count)]
