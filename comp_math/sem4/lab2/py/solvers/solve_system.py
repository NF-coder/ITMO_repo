from typing_extensions import Callable
from methods import NewtonSystemMethod
from mathUtils.safeApply import safe_apply

def solve_system(
    f1: Callable[[float | int, float | int], float | int],
    f2: Callable[[float | int, float | int], float | int],
    x0: float,
    y0: float,
    eps: float
) -> str:
    lines: list[str] = []
    try:
        lines.append("[>] РЕШЕНИЕ СИСТЕМЫ (Метод Ньютона)")
        solver = NewtonSystemMethod(f1, f2, x0=x0, y0=y0, eps=eps)
        (rx, ry), iters = solver.solve()
        f1v = safe_apply(f1, rx, ry)
        f2v = safe_apply(f2, rx, ry)
        lines.append(f"    x = {rx:.10f}, y = {ry:.10f}")
        lines.append(f"    Итераций: {iters}")
        if f1v is not None:
            lines.append(f"    f1(x, y) = {f1v:.2e}")
        if f2v is not None:
            lines.append(f"    f2(x, y) = {f2v:.2e}")
    except Exception as e:
        lines.append(f"[!] Ошибка: {e}")

    return "\n".join(lines) + "\n"