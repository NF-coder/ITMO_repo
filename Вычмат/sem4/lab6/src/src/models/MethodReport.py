from dataclasses import dataclass
from .Solution import Solution


@dataclass(frozen=True)
class MethodReport:
    solution: Solution
    runge_error: float | None
    exact_error: float
