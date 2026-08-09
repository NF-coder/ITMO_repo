from typing import Callable
from ..IntegralSolver import IntegralSolver, Result


class CentralRect(IntegralSolver):
    @property
    def order(self) -> int:
        return 2

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
        for i in range(n):
            x_middle = a + (i + 0.5) * h
            y_middle = func(x_middle)

            trace_x.append(x_middle)
            trace_y.append(y_middle)
            result += y_middle
        return Result(
            result * h,
            trace_x,
            trace_y
        )