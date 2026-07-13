from dataclasses import dataclass

import matplotlib.pyplot as plt
import numpy as np
from prettytable import PrettyTable

from approx import *
from utils.metrics import mse, pearson_r, r_squared, rmse, sse


@dataclass
class ApproximationResult:
    name: str
    coeffs: dict[str, float]
    equation: str
    model: ApproximationModel
    y_approx: np.ndarray
    sse: float
    mse: float
    rmse: float
    r: float
    pearson: float | None = None


class LeastSquaresApproximation:
    methods = [
        LinearApprox(),
        QuadraticApprox(),
        CubicApprox(),
        ExponentialApprox(),
        LogarithmicApprox(),
        PowerApprox(),
    ]

    def __init__(self, x_data: list[float], y_data: list[float]):
        self.x = np.array(x_data, dtype=float)
        self.y = np.array(y_data, dtype=float)
        self.n = len(x_data)
        self.results: dict[str, ApproximationResult] = {}

    def perform_all_approximations(self) -> None:
        for method in self.methods:
            try:
                model = method.fit(self.x, self.y)
                y_approx = model.predict(self.x)
                result = ApproximationResult(
                    name=model.name,
                    coeffs=model.coeffs,
                    equation=model.equation,
                    model=model,
                    y_approx=y_approx,
                    sse=sse(self.y, y_approx),
                    mse=mse(self.y, y_approx),
                    rmse=rmse(self.y, y_approx),
                    r=r_squared(self.y, y_approx),
                )
                if model.name == "linear":
                    result.pearson = pearson_r(self.x, self.y)
                self.results[model.name] = result
            except ValueError as exc:
                print(exc)

    def get_best_approximation(self) -> tuple[str, ApproximationResult] | None:
        if not self.results:
            return None
        return min(self.results.items(), key=lambda item: item[1].rmse)

    def print_results(self, output_file: str | None = None) -> None:
        lines: list[str] = []

        lines.append(f"\nКоличество точек данных: {self.n}")
        lines.append(f"x диапазон: [{self.x.min():.6f}, {self.x.max():.6f}]")
        lines.append(f"y диапазон: [{self.y.min():.6f}, {self.y.max():.6f}]")

        lines.append("Исходные данные")
        table_data = PrettyTable()
        table_data.field_names = ["i", "x_i", "y_i"]
        for i, (xi, yi) in enumerate(zip(self.x, self.y)):
            table_data.add_row([i, f"{xi:.6f}", f"{yi:.6f}"])
        lines.append(str(table_data))

        for name, result in self.results.items():
            lines.append(f"Аппроксимация: {name}")
            lines.append(f"Уравнение: {result.equation}")
            lines.append("\nКоэффициенты:")
            for coeff_name, coeff_val in result.coeffs.items():
                lines.append(f"\t{coeff_name:4} = {coeff_val:.8f}")

            lines.append("\nОценочные показатели:")
            lines.append(f"\tS (SSE):                {result.sse:.8f}")
            lines.append(f"\tMSE:                    {result.mse:.8f}")
            lines.append(f"\tRMSE:                   {result.rmse:.8f}")
            lines.append(f"\tR (детерминация):       {result.r:.8f}")
            if result.pearson is not None:
                lines.append(f"\tКорреляция Пирсона:     {result.pearson:.8f}")

            lines.append(f"\nОценка качества (R = {result.r:.3f}):")
            if result.r >= 0.95:
                lines.append("\t[ОТЛИЧНОЕ] Высокое качество приближения")
            elif result.r >= 0.80:
                lines.append("\t[ХОРОШЕЕ] Хорошее качество приближения")
            elif result.r >= 0.60:
                lines.append("\t[УДОВЛЕТВОРИТЕЛЬНОЕ] Среднее качество приближения")
            else:
                lines.append("\t[НИЗКОЕ] Низкое качество приближения")

            lines.append(f"\nТаблица значений для аппроксимации {name}:")
            table_approx = PrettyTable()
            table_approx.field_names = ["i", "x_i", "y_i", "phi(x_i)", "eps_i"]
            for i, (xi, yi, phi_i) in enumerate(zip(self.x, self.y, result.y_approx)):
                eps_i = yi - phi_i
                table_approx.add_row([i, f"{xi:.6f}", f"{yi:.6f}", f"{phi_i:.6f}", f"{eps_i:.6f}"])
            lines.append(str(table_approx))

        best = self.get_best_approximation()
        if best is not None:
            best_name, best_result = best
            lines.append(f"Наилучшее приближение: {best_name.upper()}")
            lines.append(f"Уравнение: {best_result.equation}")
            lines.append(f"RMSE: {best_result.rmse:.8f}")
            lines.append(f"R: {best_result.r:.8f}")

        output_text = "\n".join(lines)
        print(output_text)

        if output_file:
            with open(output_file, "w", encoding="utf-8") as file:
                file.write(output_text)

    def plot_approximations(
        self,
        title: str = "Аппроксимация функции",
        figsize: tuple[int, int] = (14, 10),
        # reference_function = None
    ):
        x_min, x_max = self.x.min(), self.x.max()
        margin = (x_max - x_min) * 0.1 if x_max > x_min else 1.0
        x_extended = np.linspace(x_min - margin, x_max + margin, 300)

        num_plots = len(self.results) + 1
        cols = 3
        rows = (num_plots + cols - 1) // cols

        fig, axes = plt.subplots(rows, cols, figsize=figsize)
        axes = np.atleast_1d(axes).flatten()

        # if reference_function is not None:
        #     axes[0].plot(x_extended, reference_function(x_extended), color="orange", linestyle='dashed', linewidth=1, label="Исходная функция f(x)")
        axes[0].plot(self.x, self.y, "o", color="orange", markersize=8, label="Точки данных")
        axes[0].grid(True, alpha=0.3)
        axes[0].legend()
        axes[0].set_xlabel("x")
        axes[0].set_ylabel("y")
        axes[0].set_title("Исходные данные")

        plot_idx = 1
        for name, result in self.results.items():
            if plot_idx >= len(axes):
                break
            ax = axes[plot_idx]

            # if reference_function is not None:
            #     ax.plot(
            #         x_extended,
            #         reference_function(x_extended),
            #         color="orange", linestyle='dashed', linewidth=1,
            #         alpha=0.6,
            #         label="f(x)",
            #     )

            y_approx = result.model.predict(x_extended)
            ax.plot(x_extended, y_approx, "r-", linewidth=2, label=f"phi(x) - {name}")
            ax.plot(self.x, self.y, "o", color="orange", markersize=7, label="Данные")
            ax.grid(True, alpha=0.3)
            ax.legend()
            ax.set_xlabel("x")
            ax.set_ylabel("y")
            ax.set_title(f"{name.capitalize()}\nRMSE: {result.rmse:.6f}, R: {result.r:.6f}")
            plot_idx += 1

        for i in range(plot_idx, len(axes)):
            axes[i].set_visible(False)

        fig.suptitle(title)
        plt.tight_layout()
        return fig
