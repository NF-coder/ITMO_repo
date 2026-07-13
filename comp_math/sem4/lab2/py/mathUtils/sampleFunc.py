from mathUtils.safeApply import safe_apply
from typing_extensions import Callable
from math import nan

def sample_function(
    f: Callable[[float | int], float | int],
    xs: list[float | int]
) -> list[float | int]:
    values: list[float] = []
    for xi in xs:
        value = safe_apply(f, float(xi))
        values.append(float(value) if value is not None else nan)

    return values