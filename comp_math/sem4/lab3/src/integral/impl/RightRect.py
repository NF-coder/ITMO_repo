from typing import Callable
from ..IntegralSolver import IntegralSolver, Result


class RightRect(IntegralSolver):
    @property
    def order(self) -> int:
        return 1
    
    def solve(
        self,
        func: Callable[[float | int], float | int], 
        a: float | int, 
        b: float | int, 
        n: int
    ) -> Result:
        trace_x: list[float] = []
        trace_y: list[float] = []

        h = (b - a) / n
        result = 0
        for i in range(1, n + 1):
            x_i = a + i * h
            y_i = func(x_i)

            trace_x.append(x_i)
            trace_y.append(y_i)
            result += y_i
        return Result(
            result * h,
            trace_x,
            trace_y
        )