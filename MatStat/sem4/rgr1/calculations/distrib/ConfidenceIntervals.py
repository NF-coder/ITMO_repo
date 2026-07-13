from distrib.DistribType import DistribType
from sires.SiresInfo import SiresInfo
from scipy.stats import norm, t, chi2
from typing import Tuple
import math

class ConfidenceIntervals:
    def __init__(
        self,
        info: SiresInfo,
        alpha: float=0.05
    ) -> None:
        self._info = info
        self._alpha = alpha

    def CPT(self) -> Tuple[float, float]:
        z = float(norm.ppf(1 - self._alpha / 2))

        return (
            self._info.mean - z * self._info.s / math.sqrt(self._info.n),
            self._info.mean + z * self._info.s / math.sqrt(self._info.n)
        )
    
    def uniform_exact(self) -> Tuple[Tuple[float, float], Tuple[float, float]]:
        # --- ДИ для mu ---
        t_val = float(t.ppf(1 - self._alpha / 2, df=self._info.n - 1))

        mu_interval = (
            self._info.mean - t_val * self._info.s / math.sqrt(self._info.n),
            self._info.mean + t_val * self._info.s / math.sqrt(self._info.n)
        )

        # --- ДИ для s2 ---
        chi2_left = float(chi2.ppf(self._alpha / 2, df=self._info.n - 1))
        chi2_right = float(chi2.ppf(1 - self._alpha / 2, df=self._info.n - 1))

        sigma2_interval = (
            (self._info.n - 1) * self._info.s**2 / chi2_right,
            (self._info.n - 1) * self._info.s**2 / chi2_left
        )

        return mu_interval, sigma2_interval