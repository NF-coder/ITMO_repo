from ..Solver import Solver
from typing import Callable


class ChordMethod(Solver):
    def __init__(
        self,
        f: Callable[[float], float],
        a: float,
        b: float,
        eps: float = 1e-2
    ):
        self._eps = eps
        self._f = f
        self._a = a
        self._b = b

    def step(self) -> float: # type: ignore
        # x_next = b - f(b) * (b - a) / (f(b) - f(a))
        fa = self._f(self._a)
        fb = self._f(self._b)
        
        x_next = self._b - fb * (self._b - self._a) / (fb - fa)
        
        self._a = self._b
        self._b = x_next
        self.iteration += 1
        
        return x_next

    def solve(self) -> tuple[float, int]:
        self.iteration = 0
        while True:
            x_new = self.step()
            if abs(self._f(x_new)) < self._eps: break
        
        return self._b, self.iteration
