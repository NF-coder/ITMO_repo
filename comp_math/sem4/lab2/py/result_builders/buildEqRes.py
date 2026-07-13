from typing_extensions import Callable
from solvers.solve_func import solve_function


def build_equation_result(
    name: str,
    func: Callable[[float | int], float | int],
    a: float | int,
    b: float | int,
    method: int,
    eps: float,
    methods: list[str]
) -> str:
    return (
        f"Функция: {name}\n"
        f"Интервал: [{a}, {b}]\n"
        f"Метод: {methods[method]}\n"
        f"Точность: {eps}\n\n"
        f"{solve_function(func, a, b, method, eps)}"
    )