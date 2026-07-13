import numpy as np
from typing import Callable, Tuple


def count_sign_changes(
    f: Callable[[float], float],
    a: float,
    b: float,
    n_points: int = 100
) -> int:
    
    xs = np.linspace(a, b, n_points)
    ys = np.array([f(x) for x in xs])
    
    cnt = 0
    for (i, j) in zip(ys[1:], ys[:-2]): cnt += i*j<0
    
    return cnt