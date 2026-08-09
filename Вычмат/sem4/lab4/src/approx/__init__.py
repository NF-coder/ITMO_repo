from .Cubic import CubicApprox
from .Exponential import ExponentialApprox
from .Linear import LinearApprox
from .Logarithmic import LogarithmicApprox
from .Power import PowerApprox
from .Quadratic import QuadraticApprox
from .base import ApproximationModel

__all__ = [
    "ApproximationModel",
    "LinearApprox",
    "QuadraticApprox",
    "CubicApprox",
    "ExponentialApprox",
    "LogarithmicApprox",
    "PowerApprox",
]
