from typing_extensions import Callable
from integral.IntegralSolver import IntegralSolver
from dataclasses import dataclass
from error import runge_rule


@dataclass(frozen=True)
class Solution:
    n: int
    result: float

class Solver():
    def __init__(
        self,
        f: Callable[[float | int], float],
        a: float | int,
        b: float | int
    ) -> None:
        self._func = f
        self._a = a
        self._b = b

    def __call__(
        self,
        method: IntegralSolver,
        eps: float = 1e-4,
        initial_n: int = 4,
        max_iter: int = 200
    ) -> "Solution":
        n: int = initial_n
        result: float = method.solve(self._func, self._a, self._b, n).result

        for _ in range(max_iter):
            new_n = n*2
            new_result = method.solve(self._func, self._a, self._b, new_n).result
            if runge_rule(result, new_result, method.order) < eps: break
            result = new_result
            n = new_n
        else:
            raise Exception("Iterations limit reached")
        
        return Solution(n, result)
        
        
