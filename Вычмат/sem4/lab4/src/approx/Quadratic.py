import numpy as np
from approx.base import ApproximationModel

class QuadraticApprox:
    """Квадратичная аппроксимация  y = a_0 + a_1 x + a_2 x^2"""
    name = "quadratic"

    def fit(self, x: np.ndarray, y: np.ndarray) -> ApproximationModel:
        sum_x = np.sum(x)
        sum_y = np.sum(y)
        sum_x2 = np.sum(x ** 2)
        sum_x3 = np.sum(x ** 3)
        sum_x4 = np.sum(x ** 4)
        sum_xy = np.sum(x * y)
        sum_x2y = np.sum((x ** 2) * y)

        
        A = np.array([
            [len(x), sum_x, sum_x2],
            [sum_x, sum_x2, sum_x3],
            [sum_x2, sum_x3, sum_x4]
        ], dtype=float)
        B = np.array([sum_y, sum_xy, sum_x2y])
        
        try:
            coeffs = np.linalg.solve(A, B)
            a0, a1, a2 = coeffs

            def predict(x_values: np.ndarray) -> np.ndarray:
                return a0 + a1 * x_values + a2 * x_values ** 2

            return ApproximationModel(
                name=self.name,
                equation=f"y = {a0:.6f} + {a1:.6f}*x + {a2:.6f}*x^2",
                coeffs={"a0": float(a0), "a1": float(a1), "a2": float(a2)},
                predict=predict,
            )
        except np.linalg.LinAlgError:
            raise ValueError("Ошибка при вычислении квадратичной аппроксимации")
