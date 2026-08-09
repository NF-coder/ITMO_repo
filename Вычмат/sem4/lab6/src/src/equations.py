from dataclasses import dataclass
from math import exp
from typing import Callable

from .models.InitialValueProblem import InitialValueProblem


@dataclass(frozen=True)
class DifferentialEquation:
    name: str
    equation: str
    exact_equation: str
    function: Callable[[float, float], float]
    exact_factory: Callable[[InitialValueProblem], Callable[[float], float]]
    default_problem: InitialValueProblem

    def exact(self, problem: InitialValueProblem) -> Callable[[float], float]:
        return self.exact_factory(problem)


class EquationCatalog:
    @staticmethod
    def available() -> list[DifferentialEquation]:
        return [
            DifferentialEquation(
                name="пример из лекции",
                equation="y' = y + (1 + x)y^2",
                exact_equation="y = -1 / x",
                function=lambda x, y: y + (1 + x) * y**2,
                exact_factory=EquationCatalog._bernoulli_exact,
                default_problem=InitialValueProblem(x0=1.0, y0=-1.0, xn=1.5, h=0.1, eps=1e-4),
            ),
            DifferentialEquation(
                name="линейное уравнение",
                equation="y' = x + y",
                exact_equation="y = 2e^x - x - 1",
                function=lambda x, y: x + y,
                exact_factory=EquationCatalog._linear_exact,
                default_problem=InitialValueProblem(x0=0.0, y0=1.0, xn=1.0, h=0.1, eps=1e-4),
            ),
            DifferentialEquation(
                name="нелинейное уравнение",
                equation="y' = y - x^2 + 1",
                exact_equation="y = (x + 1)^2 - 0.5e^x",
                function=lambda x, y: y - x**2 + 1,
                exact_factory=EquationCatalog._parabolic_exact,
                default_problem=InitialValueProblem(x0=0.0, y0=0.5, xn=2.0, h=0.2, eps=1e-4),
            )
        ]

    @staticmethod
    def _bernoulli_exact(problem: InitialValueProblem) ->  Callable[[float], float]:
        if abs(problem.y0) < 1e-15:  return lambda x: 0.0

        constant = exp(problem.x0) * (1 / problem.y0 + problem.x0)
        return lambda x: 1 / (constant * exp(-x) - x)

    @staticmethod
    def _linear_exact(problem: InitialValueProblem) ->  Callable[[float], float]:
        constant = (problem.y0 + problem.x0 + 1) * exp(-problem.x0)
        return lambda x: constant * exp(x) - x - 1

    @staticmethod
    def _parabolic_exact(problem: InitialValueProblem) ->  Callable[[float], float]:
        constant = (problem.y0 - problem.x0**2 - 2 * problem.x0 - 1) * exp(-problem.x0)
        return lambda x: constant * exp(x) + x**2 + 2 * x + 1
