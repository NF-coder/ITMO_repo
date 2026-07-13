def absolute_error(
    exact_value: float | int,
    approximate_value: float | int
) -> float | int:
    """
    Абсолютная погрешность
    delta = |I_exact - I_approx|
    """
    return abs(exact_value - approximate_value)

def relative_error(
    exact_value: float | int,
    approximate_value: float | int
) -> float:
    """
    Относительная погрешность
    eps = |I_exact - I_approx| / |I_exact| * 100%
    """
    if exact_value == 0:
        return 0
    return abs(exact_value - approximate_value) / abs(exact_value) * 100

def runge_rule(
    integral_h: float | int,
    integral_2h: float | int,
    method_order: int
) -> float | int:
    """
    Правило Рунге для оценки погрешности
    R = |I_h - I_(2h)| / (2^p - 1)
    """
    return abs(integral_h - integral_2h) / (2**method_order - 1)