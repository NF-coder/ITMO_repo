from ..Solver import Solver
from typing import Callable, Tuple
from ..utils.diff import diff, diff_x, diff_y


class NewtonSystemMethod(Solver):
    def __init__(
        self,
        f1: Callable[[float, float], float],
        f2: Callable[[float, float], float],
        x0: float,
        y0: float,
        eps: float = 1e-2,
        h: float = 1e-5
    ):
        super().__init__(eps)
        self._f1 = f1
        self._f2 = f2
        self._x = x0
        self._y = y0
        self._h = h

    def step(self) -> Tuple[float, float]: # type: ignore
        # Якобиан
        J11 = diff_x(self._f1, self._x, self._y, 1e-7)
        J12 = diff_y(self._f1, self._x, self._y, 1e-7)
        J21 = diff_x(self._f2, self._x, self._y, 1e-7)
        J22 = diff_y(self._f2, self._x, self._y, 1e-7)

        # Значения функций
        F1 = self._f1(self._x, self._y)
        F2 = self._f2(self._x, self._y)

        # Определитель якобиана
        det = J11 * J22 - J12 * J21

        if abs(det) < 1e-10:
            raise ValueError("Якобиан вырожден!")

        # Шаг Ньютона (метод Крамера)
        dx = (-F1 * J22 + F2 * J12) / det
        dy = (-J11 * F2 + J21 * F1) / det

        self._x += dx
        self._y += dy
        self.iteration += 1

        return self._x, self._y

    def solve(self) -> Tuple[Tuple[float, float], int]:
        self.iteration = 0
        prev_x, prev_y = self._x, self._y

        while True:
            x_new, y_new = self.step()

            if max(abs(x_new - prev_x), abs(y_new - prev_y)) < self.eps:  break

            prev_x, prev_y = x_new, y_new

        return (self._x, self._y), self.iteration
