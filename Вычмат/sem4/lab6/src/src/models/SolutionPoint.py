from dataclasses import dataclass


@dataclass(frozen=True)
class SolutionPoint:  
    index: int
    x: float
    y: float