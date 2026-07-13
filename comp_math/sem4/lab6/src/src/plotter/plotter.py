from pathlib import Path
import matplotlib.pyplot as plt

from ..equations import DifferentialEquation
from ..models.InitialValueProblem import InitialValueProblem
from ..models.MethodReport import MethodReport


class OdePlotter:
    
    def save(
        self,
        equation: DifferentialEquation,
        problem: InitialValueProblem,
        reports: list[MethodReport],
        output_path: str | Path,
    ) -> Path:
        try:
            path = Path(output_path)
            path.parent.mkdir(parents=True, exist_ok=True)
            
            left = reports[0].solution.points[0].x
            right = reports[0].solution.points[-1].x
            grid = self._grid(left, right, 300)
            exact = equation.exact(problem)
            
            plt.figure(figsize=(8, 4.8))
            plt.plot(grid, [exact(x) for x in grid], color="#111111", linewidth=2.0, label="точное решение")
            
            colors = ["#1f77b4", "#d62728", "#2ca02c"]
            for color, report in zip(colors, reports):
                points = report.solution.points
                plt.plot(
                    [point.x for point in points],
                    [point.y for point in points],
                    marker="o",
                    markersize=3,
                    color=color,
                    label=report.solution.method,
                )
            
            plt.title(equation.equation)
            plt.xlabel("x")
            plt.ylabel("y")
            plt.grid(True, alpha=0.25)
            plt.legend()
            plt.tight_layout()
            plt.savefig(path, dpi=180)
            plt.close()
            
            return path
        except Exception as error:
            plt.close()
            raise RuntimeError(f"ошибка при сохранении графика: {error}")

    @staticmethod
    def _grid(left: float, right: float, count: int) -> list[float]:
        step = (right - left) / (count - 1)
        return [left + index * step for index in range(count)]
