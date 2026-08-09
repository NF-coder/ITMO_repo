from sires.SiresInfo import SiresInfo
from sires.SortedSires import SortedSires
import matplotlib.pyplot as plt

from hist.IntervalRules import IntervalRules
from hist.Rules import *

from typing import Callable

class Histogram:
    def __init__(self, sorted_data: SortedSires, is_density: bool=False) -> None:
        self._sires_info = SiresInfo(sorted_data)
        self._sorted_data_list = [sorted_data[i] for i in range(len(sorted_data))]
        self._is_density = is_density

    def _select_rule_func(self, rule: IntervalRules) -> Callable[[SiresInfo], int]:
        if rule == IntervalRules.SCOTT: return scott_rule
        if rule == IntervalRules.FRIDMAN_DIANOKIS: return fridman_dianokis_rule
        if rule == IntervalRules.STREDZHES: return stredzhes_rule

    def _generate_hist(self, rule: IntervalRules) -> None:
        rule_func = self._select_rule_func(rule)

        plt.hist(self._sorted_data_list, bins=rule_func(self._sires_info), density=self._is_density)
        plt.axvline(self._sires_info.mean, linestyle='--', color="orange", label="Среднее знаачение")
        plt.title(f"Гистограмма {rule.value}")
        plt.xlabel("Значения")
        plt.ylabel("Частота")
        plt.legend()

    def draw(self, rule: IntervalRules) -> None:
        self._generate_hist(rule)
    

    def draw_all(self) -> None:
        plt.figure(figsize=(15,5))

        plt.subplot(1,3,1)
        self._generate_hist(IntervalRules.SCOTT)
        
        plt.subplot(1,3,2)
        self._generate_hist(IntervalRules.FRIDMAN_DIANOKIS)

        plt.subplot(1,3,3)
        self._generate_hist(IntervalRules.STREDZHES)