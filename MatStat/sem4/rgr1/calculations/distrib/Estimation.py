from distrib.DistribType import DistribType
from distrib.DistribParams import *
from sires.SiresInfo import SiresInfo

import math

class Estimation():
    def __init__(self, info: SiresInfo, distrib_type: DistribType) -> None:
        self._distrib_type = distrib_type
        self._info = info

    def _normal_distrib_MM(self) -> NormalDistribParams:
        return NormalDistribParams(self._info.mean, self._info.s2_biased)
    def _normal_distrib_MLM(self) -> NormalDistribParams:
        return NormalDistribParams(self._info.mean, self._info.s2_biased)
    
    def _uniform_distrib_MM(self) -> UniformDistribParams:
        return UniformDistribParams(
            self._info.mean - math.sqrt(3 * self._info.s2_biased),
            self._info.mean + math.sqrt(3 * self._info.s2_biased),
        )
    def _uniform_distrib_MLM(self) -> UniformDistribParams:
        return UniformDistribParams(self._info.x_min, self._info.x_max)

    def _exp_distrib_MM(self) -> ExpDistribParams:
        return ExpDistribParams(
            1 / self._info.s_biased,
            self._info.mean - self._info.s_biased
        )
    def _exp_distrib_MLM(self) -> ExpDistribParams:
        return ExpDistribParams(
            1/(self._info.mean - self._info.x_min),
            self._info.x_min
        )
    
    def __call__(self):
        if self._distrib_type == DistribType.EXP:
            return (self._exp_distrib_MM(), self._exp_distrib_MLM())
        if self._distrib_type == DistribType.NORMAL:
            return (self._normal_distrib_MM(), self._normal_distrib_MLM())
        if self._distrib_type == DistribType.UNIFORM:
            return (self._uniform_distrib_MM(), self._uniform_distrib_MLM())
        
        raise Exception("No such distribution method")