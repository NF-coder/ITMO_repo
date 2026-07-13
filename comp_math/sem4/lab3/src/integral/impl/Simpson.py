from typing import Callable
from ..IntegralSolver import IntegralSolver, Result


class Simpson(IntegralSolver):
    @property
    def order(self) -> int:
        return 4
    
    def solve(
        self,
        func: Callable[[float | int], float | int], 
        a: float | int, 
        b: float | int, 
        n: int
    ) -> Result:
        """
        Метод Симпсона (парабол)
        Формула: I = (h/3) * [f(x_0) + 4*f(x_1) + 2*f(x_2) + 4*f(x_3) + ... + f(x_n)]
        n должно быть чётным
        """
        trace_x: list[float | int] = [0]*n
        trace_y: list[float | int] = [0]*n

        if n % 2 != 0: n += 1
        
        h = (b - a) / n
        result = func(a) + func(b)
        trace_x[0], trace_x[-1] = a, b
        trace_y[0], trace_y[-1] = func(a), func(b)
        
        # Нечётные коэффициенты (4)
        for i in range(1, n, 2):
            x_i = a + i * h
            y_i = func(x_i)

            trace_x[i] = x_i
            trace_y[i] = y_i
            result += 4 * y_i
        
        # Чётные коэффициенты (2)
        for i in range(2, n - 1, 2):
            x_i = a + i * h
            y_i = func(x_i)

            trace_x[i] = x_i
            trace_y[i] = y_i
            result += 2 * y_i
        
        return Result(
            result * h / 3,
            trace_x,
            trace_y
        )