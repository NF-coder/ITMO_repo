from dataclasses import dataclass
from .SolutionPoint import SolutionPoint


@dataclass(frozen=True)
class Solution:
    method: str
    order: int
    points: list[SolutionPoint]

    @property
    def last_y(self) -> float:
        return self.points[-1].y
