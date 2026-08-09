from distrib.DistribType import DistribType
from sires.SiresInfo import SiresInfo
from sires.SortedSires import SortedSires
import math
from typing import Tuple

def normal_cdf(x: float, mu: float, sigma: float) -> float: # Ф_0
    return 0.5 * (1 + math.erf((x - mu) / (sigma * math.sqrt(2))))

norm_distrib_param_prob = lambda x0, mean, s_biased: 1 - normal_cdf(x0, mean, s_biased)
uniform_distrib_param_prob = lambda x0, a, b: 1 if x0 < a else (0 if x0 > b else (b - x0) / (b - a))
exp_distrib_param_prob = lambda x0, c, mean: 1 if x0 < c else math.e**(-1 / (mean - c) * (x0 - c))

class ParametricProb():
    def __init__(self, sires: SortedSires, dist_type: DistribType) -> None:
        self._dist_type = dist_type
        self._info = SiresInfo(sires)
        self._data = sires

    def _emperical_prob(self, x0: float):
        return sum(1 for x in self._data if x > x0) / len(self._data)
    
    def __call__(self) -> Tuple[float, float]:
        x0 = self._info.mean + self._info.s

        emperical_prob = self._emperical_prob(x0)

        if self._dist_type == DistribType.NORMAL:
            return (
                emperical_prob,
                norm_distrib_param_prob(x0, self._info.mean, self._info.s_biased)
            )
        if self._dist_type == DistribType.UNIFORM:
            return (
                emperical_prob,
                uniform_distrib_param_prob(x0, self._info.x_min, self._info.x_max)
            )
        if self._dist_type == DistribType.EXP:
            return (
                emperical_prob,
                exp_distrib_param_prob(x0, self._info.x_min, self._info.mean)
            )
            
        raise Exception("No such distribution")