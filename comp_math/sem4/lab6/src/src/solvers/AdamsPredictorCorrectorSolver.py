from ..equations import DifferentialEquation
from ..models.InitialValueProblem import InitialValueProblem
from ..models.Solution import Solution
from .Solver import Solver
from .RungeKutta4Solver import RungeKutta4Solver


class AdamsPredictorCorrectorSolver(Solver):
    name = "Метод Адамса"
    order = 4

    def solve(self, equation: DifferentialEquation, problem: InitialValueProblem) -> Solution:
        try:
            problem.validate()
            if problem.steps_count < 4:
                raise ValueError("для метода Адамса нужно не менее четырех шагов (текущих: {})".format(problem.steps_count))
            
            f = equation.function
            values = [problem.y0]
            x = problem.x0
            y = problem.y0
            
            # Инициализация с помощью Рунге-Кутта
            for _ in range(3):
                y = RungeKutta4Solver.next_value(f, x, y, problem.h)
                x += problem.h
                values.append(y)
            
            # Применение метода Адамса
            for index in range(3, problem.steps_count):
                x_next = problem.x0 + (index + 1) * problem.h
                f_i = f(problem.x0 + index * problem.h, values[index])
                f_i_1 = f(problem.x0 + (index - 1) * problem.h, values[index - 1])
                f_i_2 = f(problem.x0 + (index - 2) * problem.h, values[index - 2])
                f_i_3 = f(problem.x0 + (index - 3) * problem.h, values[index - 3])
                
                predicted = values[index] + problem.h / 24 * (55 * f_i - 59 * f_i_1 + 37 * f_i_2 - 9 * f_i_3)
                corrected = predicted
                
                for _ in range(50):
                    previous = corrected
                    f_next = f(x_next, previous)
                    corrected = values[index] + problem.h / 24 * (9 * f_next + 19 * f_i - 5 * f_i_1 + f_i_2)
                    if abs(corrected - previous) <= problem.eps:
                        break
                
                values.append(corrected)
            
            return Solution(self.name, self.order, self._build_points(problem, values))
        except Exception as error:
            raise RuntimeError(f"ошибка при решении методом {self.name}: {error}")


