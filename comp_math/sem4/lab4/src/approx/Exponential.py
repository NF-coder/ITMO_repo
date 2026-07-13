import numpy as np
from approx.base import ApproximationModel

class ExponentialApprox:
    """
    Экспоненциальная аппроксимация y = a * exp(bx)
    Преобразуем в линейную: ln(y) = ln(a) + bx
    """
    name = "exponential"

    def fit(self, x: np.ndarray, y: np.ndarray) -> ApproximationModel:
        if np.any(y <= 0):
            raise ValueError("Экспоненциальная аппроксимация требует y > 0")

        sum_x = np.sum(x)
        ln_y = np.log(y)
        sum_x2 = np.sum(x ** 2)
        sum_ln_y = np.sum(ln_y)
        sum_x_ln_y = np.sum(x * ln_y)

        try:
            A = np.array([[len(x), sum_x], [sum_x, sum_x2]], dtype=float)
            B = np.array([sum_ln_y, sum_x_ln_y])
            coeffs = np.linalg.solve(A, B)

            ln_a, b = coeffs
            a = np.exp(ln_a)

            def predict(x_values: np.ndarray) -> np.ndarray:
                return a * np.exp(b * x_values)

            return ApproximationModel(
                name=self.name,
                equation=f"y = {a:.6f}*exp({b:.6f}*x)",
                coeffs={"a": float(a), "b": float(b)},
                predict=predict,
            )
        except np.linalg.LinAlgError:
            raise ValueError("Ошибка при вычислении экспоненциальной аппроксимации")
