from ..equations import DifferentialEquation
from ..models.InitialValueProblem import InitialValueProblem
from ..models.Solution import Solution
from .Solver import Solver


class ImprovedEulerSolver(Solver):
    name = "Усовершенствованный метод Эйлера"
    order = 2

    def solve(self, equation: DifferentialEquation, problem: InitialValueProblem) -> Solution:
        try:
            problem.validate()
            f = equation.function
            values = [problem.y0]
            x = problem.x0
            y = problem.y0
            
            for _ in range(problem.steps_count):
                predictor = y + problem.h * f(x, y)
                y += problem.h / 2 * (f(x, y) + f(x + problem.h, predictor))
                x += problem.h
                values.append(y)
            
            return Solution(self.name, self.order, self._build_points(problem, values))
        except Exception as error:
            raise RuntimeError(f"ошибка при решении методом {self.name}: {error}")
