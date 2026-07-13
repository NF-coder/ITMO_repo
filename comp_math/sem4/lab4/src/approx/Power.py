import numpy as np
from approx.base import ApproximationModel

class PowerApprox:
    """
    Степенная аппроксимация y = a * x^b
    Преобразуем в линейную: ln(y) = ln(a) + b*ln(x)
    """
    name = "power"

    def fit(self, x: np.ndarray, y: np.ndarray) -> ApproximationModel:
        if np.any(x <= 0):
            raise ValueError("Степенная аппроксимация требует x > 0")
        if np.any(y <= 0):
            raise ValueError("Степенная аппроксимация требует y > 0")

        ln_x = np.log(x)
        ln_y = np.log(y)
        sum_ln_x = np.sum(ln_x)
        sum_ln_y = np.sum(ln_y)
        sum_ln_x2 = np.sum(ln_x ** 2)
        sum_ln_x_ln_y = np.sum(ln_x * ln_y)

        try:
            A = np.array([[len(x), sum_ln_x], [sum_ln_x, sum_ln_x2]], dtype=float)
            B = np.array([sum_ln_y, sum_ln_x_ln_y])
            
            coeffs = np.linalg.solve(A, B)
            ln_a, b = coeffs
            a = np.exp(ln_a)

            def predict(x_values: np.ndarray) -> np.ndarray:
                values = np.asarray(x_values, dtype=float)
                y_approx = np.full_like(values, np.nan)
                mask = values > 0
                y_approx[mask] = a * np.power(values[mask], b)
                return y_approx

            return ApproximationModel(
                name=self.name,
                equation=f"y = {a:.6f}*x^{b:.6f}",
                coeffs={"a": float(a), "b": float(b)},
                predict=predict,
            )
        except np.linalg.LinAlgError:
            raise ValueError("Ошибка при вычислении степенной аппроксимации")
