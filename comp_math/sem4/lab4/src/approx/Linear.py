import numpy as np
from approx.base import ApproximationModel

class LinearApprox:
    """Линейная аппроксимация y = ax + b"""
    name = "linear"

    def fit(self, x: np.ndarray, y: np.ndarray) -> ApproximationModel:
        sum_x = np.sum(x)
        sum_y = np.sum(y)
        sum_x2 = np.sum(x ** 2)
        sum_xy = np.sum(x * y)
        
        A = np.array([[len(x), sum_x], [sum_x, sum_x2]], dtype=float)
        B = np.array([sum_y, sum_xy])
        
        try:
            coeffs = np.linalg.solve(A, B)
            b, a = coeffs

            def predict(x_values: np.ndarray) -> np.ndarray:
                return a * x_values + b

            return ApproximationModel(
                name=self.name,
                equation=f"y = {a:.6f}*x + {b:.6f}",
                coeffs={"a": float(a), "b": float(b)},
                predict=predict,
            )
        except np.linalg.LinAlgError:
            raise ValueError("Ошибка при вычислении линейной аппроксимации")
