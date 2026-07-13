from typing_extensions import Callable
from solvers.solve_system import solve_system


def build_system_result(
    name: str,
    f1: Callable[[float | int, float | int], float | int],
    f2: Callable[[float | int, float | int], float | int],
    x0: float | int,
    y0: float | int,
    eps: float
) -> str:
    return (
        f"Система: {name}\n"
        f"Метод: Метод Ньютона\n"
        f"Точность: {eps}\n"
        f"Начальные значения: x0={x0}, y0={y0}\n\n"
        f"{solve_system(f1, f2, x0, y0, eps)}"
    )