from abc import ABCMeta, abstractmethod
from .InerpolationResult import InterpolationResult


class Interpolator(metaclass = ABCMeta):
    @abstractmethod
    def evaluate(self, x_value: float) -> InterpolationResult:
        ...