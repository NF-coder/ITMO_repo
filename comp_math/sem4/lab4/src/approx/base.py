from dataclasses import dataclass
from typing import Callable

import numpy as np


@dataclass
class ApproximationModel:
    name: str
    equation: str
    coeffs: dict[str, float]
    predict: Callable[[np.ndarray], np.ndarray]
