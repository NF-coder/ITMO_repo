from ..equations import DifferentialEquation
from ..models.InitialValueProblem import InitialValueProblem
from ..models.Solution import Solution
from .Solver import Solver

class RungeKutta4Solver(Solver):
    name = "метод Рунге-Кутта 4-го порядка"
    order = 4

    def solve(self, equation: DifferentialEquation, problem: InitialValueProblem) -> Solution:
        try:
            problem.validate()
            f = equation.function
            values = [problem.y0]
            x = problem.x0
            y = problem.y0
            
            for _ in range(problem.steps_count):
                y = self.next_value(f, x, y, problem.h)
                x += problem.h
                values.append(y)
            
            return Solution(self.name, self.order, self._build_points(problem, values))
        except Exception as error:
            raise RuntimeError(f"ошибка при решении методом {self.name}: {error}")

    @staticmethod
    def next_value(f, x: float, y: float, h: float) -> float:
        k1 = h * f(x, y)
        k2 = h * f(x + h / 2, y + k1 / 2)
        k3 = h * f(x + h / 2, y + k2 / 2)
        k4 = h * f(x + h, y + k3)
        return y + (k1 + 2 * k2 + 2 * k3 + k4) / 6

