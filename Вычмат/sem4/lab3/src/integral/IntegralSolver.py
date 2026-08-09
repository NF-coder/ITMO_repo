from abc import ABCMeta, abstractmethod
from dataclasses import dataclass,field
from typing import Callable

class IntegralSolver(metaclass = ABCMeta):
    @property
    @abstractmethod
    def order(self) -> int:
        ...

    @abstractmethod
    def solve(
        self,
        func: Callable[[float | int], float | int],
        a: float | int,
        b: float | int,
        n: int
    ) -> "Result":
        ...

@dataclass
class Result:
    result: float | int
    x: list[float | int] = field(default_factory=list)
    y: list[float | int] = field(default_factory=list)