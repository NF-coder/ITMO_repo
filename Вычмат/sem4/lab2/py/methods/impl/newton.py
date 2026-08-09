from ..Solver import Solver
from typing import Callable, Union
from ..utils.diff import diff


class NewtonMethod(Solver):
    def __init__(
        self,
        f: Callable[[float], float],
        x0: float,
        eps: float = 1e-2
    ):
        self._f = f
        self._x = x0
        self._eps = eps
        self._df = lambda x: diff(self._f, x, 1e-5)

    def step(self) -> float: # type: ignore
        fx = self._f(self._x)
        dfx = self._df(self._x)
        
        self._x = self._x - fx / dfx
        self.iteration += 1

        return self._x

    def solve(self) -> tuple[float, int]:
        self.iteration = 0
        prev_x = self._x
        
        while True:
            x_new = self.step()
            
            if abs(x_new - prev_x) < self._eps: break
            
            prev_x = x_new
        
        return self._x, self.iteration
