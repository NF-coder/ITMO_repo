from ..Solver import Solver
import numpy as np
from typing import Callable
from ..utils import diff


class SimpleIter(Solver):
    def __init__(
        self,
        f: Callable[[float], float],
        a: float,
        b: float,
        eps: float = 1e-2
    ):
        super().__init__(eps)
        self._f = f
        self._a = a
        self._b = b
        self._x = (a + b) / 2  # начальное приближение в середине интервала
        self._lambda = self._find_lambda()
        self._phi = lambda x: x + self._lambda * self._f(x)

    def _find_lambda(self, n: int = 1000) -> float:
        xs = np.linspace(self._a, self._b, n)
        max_df = max(abs(diff(self._f, x, 1e-7)) for x in xs)
        
        mid_df = diff(self._f, (self._a + self._b) / 2, 1e-7)
        
        return -1 / max_df if mid_df > 0 else 1 / max_df

    def step(self) -> float: # type: ignore
        self._x = self._phi(self._x)
        self.iteration += 1
        return self._x

    def solve(self) -> tuple[float, int]:
        self.iteration = 0
        prev_x = self._x
        
        while True:
            x_new = self.step()
            
            if abs(x_new - prev_x) < self.eps:  break
            
            prev_x = x_new
        
        return self._x, self.iteration
