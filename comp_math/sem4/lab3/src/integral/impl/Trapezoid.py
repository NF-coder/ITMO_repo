from typing import Callable
from ..IntegralSolver import IntegralSolver, Result


class Trapezoid(IntegralSolver):
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
        """
        Метод трапеций
        Формула: I = (h/2) * [f(x_0) + 2*f(x_1) + 2*f(x_@) + ... + 2*f(x_(n-1)) + f(x_n)]
        """
        trace_x: list[float] = []
        trace_y: list[float] = []

        h = (b - a) / n
        y_0 = func(a)
        y_n = func(b)

        trace_x.append(a)
        trace_y.append(y_0)

        result = (y_0 + y_n)/2
        for i in range(1, n):
            x_i = a + i * h
            y_i = func(x_i)

            trace_x.append(x_i)
            trace_y.append(y_i)

            result += y_i

        trace_x.append(b)
        trace_y.append(y_n)

        return Result(
            result * h,
            trace_x,
            trace_y
        )