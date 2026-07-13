import math
from typing import Callable

from distrib.DistribType import DistribType
from distrib.DistribParams import *
from sires.SiresInfo import SiresInfo


normal_dencity = lambda x, sigma, mean: 1/(sigma * math.sqrt(2*math.pi)) * math.e**(-((x - mean)**2)/(2*sigma**2))
uniform_dencity = lambda x, a, b: 1/(b - a) if a <= x <= b else 0
exp_dencity = lambda x, __lambda, c: __lambda * math.exp(-__lambda * (x - c)) if x >= c else 0

class DistribDencity:
    def __init__(
        self,
        params: UniformDistribParams | NormalDistribParams | ExpDistribParams ,
        distrib_type: DistribType
    ) -> None:
        self._params = params
        self._distrib_type = distrib_type
        
    def get_dencity(self) -> Callable[[float|int], float]:
        if self._distrib_type == DistribType.NORMAL:
            return lambda x: normal_dencity(x, math.sqrt(self._params.sigma2), self._params.a)
        
        if self._distrib_type == DistribType.UNIFORM:
            return lambda x: uniform_dencity(x, self._params.a, self._params.b)

        if self._distrib_type == DistribType.EXP:
            return lambda x: exp_dencity(x, self._params.l, self._params.c) 
        
        raise Exception("No such distribution method")