import numpy as np
from approx.base import ApproximationModel

class LogarithmicApprox:
    """
    Логарифмическая аппроксимация y = a * ln(x) + b
    Преобразуем в линейную: y = a*ln(x) + b
    """
    name = "logarithmic"

    def fit(self, x: np.ndarray, y: np.ndarray) -> ApproximationModel:
        if np.any(x <= 0):
            raise ValueError("Логарифмическая аппроксимация требует x > 0")

        ln_x = np.log(x)
        sum_ln_x = np.sum(ln_x)
        sum_y = np.sum(y)
        sum_ln_x2 = np.sum(ln_x ** 2)
        sum_ln_x_y = np.sum(ln_x * y)

        try:
            A = np.array([[len(x), sum_ln_x], [sum_ln_x, sum_ln_x2]], dtype=float)
            B = np.array([sum_y, sum_ln_x_y])
            
            coeffs = np.linalg.solve(A, B)
            b, a = coeffs

            def predict(x_values: np.ndarray) -> np.ndarray:
                values = np.asarray(x_values, dtype=float)
                y_approx = np.full_like(values, np.nan)
                mask = values > 0
                y_approx[mask] = a * np.log(values[mask]) + b
                return y_approx

            return ApproximationModel(
                name=self.name,
                equation=f"y = {a:.6f}*ln(x) + {b:.6f}",
                coeffs={"a": float(a), "b": float(b)},
                predict=predict,
            )
        except np.linalg.LinAlgError:
            raise ValueError("Ошибка при вычислении логарифмической аппроксимации")
