from typing_extensions import Callable
from methods.utils import diff, count_sign_changes
from methods import SimpleIter, NewtonMethod, ChordMethod
from mathUtils.safeApply import safe_apply

def solve_function(
    f: Callable[[float | int], float | int],
    a: float,
    b: float,
    method: int,
    eps: float
) -> str:
    lines: list[str] = []
    cnt = count_sign_changes(f, a, b, n_points=1000)
    lines.append(f"[*] Корней на [{a}, {b}]: ~{cnt}")
    
    if cnt == 0:
        lines.append("[!] Корней не найдено в интервале")
        return "\n".join(lines) + "\n"
    
    try:
        method_names = ["ПРОСТАЯ ИТЕРАЦИЯ", "МЕТОД НЬЮТОНА", "МЕТОД ХОРД"]
        lines.append(f"[>] {method_names[method]}")
        
        if method == 0:
            solver = SimpleIter(f, a, b, eps)
        elif method == 1:
            d2: Callable[[float | int], float | int] = lambda x: diff(f, diff(f, x, 1e-7), 1e-7)
            f2_a = safe_apply(d2, a)
            x0 = a if (f2_a and f2_a > 0) else b
            solver = NewtonMethod(f, x0, eps)
        else:
            solver = ChordMethod(f, a, b, eps)
        
        root, iters = solver.solve()
        fval = safe_apply(f, root)
        lines.append(f"    Корень: x = {root:.10f}")
        lines.append(f"    Итераций: {iters}")
        if fval is not None:
            lines.append(f"    f(x) = {fval:.2e}")
    
    except Exception as e:
        lines.append(f"[!] Ошибка: {e}")

    return "\n".join(lines) + "\n"



