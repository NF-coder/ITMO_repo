from abc import ABCMeta, abstractmethod
from typing import Tuple, Union

class Solver(metaclass=ABCMeta):    
    def __init__(self, eps: float = 1e-2):
        self.eps = eps
        self.iteration = 0
    
    @abstractmethod
    def step(self) -> Union[Tuple[float], Tuple[Tuple[float, ...]]]:
        ...
    
    @abstractmethod
    def solve(self) -> Union[Tuple[float, int], Tuple[Tuple[float, ...], int]]:
        ...