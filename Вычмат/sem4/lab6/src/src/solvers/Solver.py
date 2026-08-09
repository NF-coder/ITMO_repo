from abc import ABCMeta, abstractmethod

from ..equations import DifferentialEquation
from ..models.SolutionPoint import SolutionPoint
from ..models.InitialValueProblem import InitialValueProblem
from ..models.Solution import Solution


class Solver(metaclass = ABCMeta):
    name: str
    order: int

    @abstractmethod
    def solve(self, equation: DifferentialEquation, problem: InitialValueProblem) -> Solution:
        ...

    @staticmethod
    def _build_points(problem: InitialValueProblem, values: list[float]) -> list[SolutionPoint]:
        return [
            SolutionPoint(index=index, x=problem.x0 + index * problem.h, y=value)
            for index, value in enumerate(values)
        ]