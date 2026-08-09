from sires.SortedSires import SortedSires
from sires.SiresInfo import SiresInfo
from distrib.Estimation import Estimation
from distrib.DistribType import DistribType
from distrib.utils.PlotUtils import PlotUtils
import numpy as np
import random
import math
import matplotlib.pyplot as plt


class EstimatedParamsPlots:
    def __init__(self, data: SortedSires, dist_type: DistribType, samples_cnt: int = 1000):
        self._samples_cnt = samples_cnt
        self._data = data
        self._dist_type = dist_type
    
    def _estimate_samples(self) -> list:
        estim_results = []
        data_list = [i for i in self._data]

        for _ in range(self._samples_cnt):
            sample = random.choices(data_list, k=len(data_list))
            sample_info = SiresInfo(SortedSires(sample))

            estim_results.append(Estimation(sample_info, self._dist_type)())
        
        return estim_results

    def draw(self):
        estimation_results = self._estimate_samples()
        
        param1_name, param2_name = "", ""
        param1_MM_arr, param2_MM_arr = [], []
        param1_MLM_arr, param2_MLM_arr = [], []

        if self._dist_type == DistribType.EXP:
            param1_name, param2_name = "λ", "c"
            param1_MM_arr = [i[0].l for i in estimation_results]
            param2_MM_arr = [i[0].c for i in estimation_results]
            param1_MLM_arr = [i[1].l for i in estimation_results]
            param2_MLM_arr = [i[1].c for i in estimation_results]

        elif self._dist_type == DistribType.UNIFORM:
            param1_name, param2_name = "a", "b"
            param1_MM_arr = [i[0].a for i in estimation_results]
            param2_MM_arr = [i[0].b for i in estimation_results]
            param1_MLM_arr = [i[1].a for i in estimation_results]
            param2_MLM_arr = [i[1].b for i in estimation_results]

        elif self._dist_type == DistribType.NORMAL:
            param1_name, param2_name = "a", "σ"
            param1_MM_arr = [i[0].a for i in estimation_results]
            param2_MM_arr = [math.sqrt(i[0].sigma2) for i in estimation_results]
            param1_MLM_arr = [i[1].a for i in estimation_results]
            param2_MLM_arr = [math.sqrt(i[1].sigma2) for i in estimation_results]
        
        else: raise Exception("No suchdistribution method")

        PlotUtils.plot_density_histograms(
            {
                f'{param1_name} estimates (MM)': param1_MM_arr,
                f'{param1_name} estimates (MLE)': param1_MLM_arr,
                f'{param2_name} estimates (MM)': param2_MM_arr,
                f'{param2_name} estimates (MLE)': param2_MLM_arr,
            },
            bins=30,
            figsize=(12, 8),
            suptitle='',
        )
        plt.show()

        PlotUtils.plot_scatter(
            param1_MM_arr,
            param2_MM_arr,
            x_label=param1_name,
            y_label=param2_name,
            title='Метод моментов',
            label='MM estimates',
            color='blue',
        )
        plt.show()

        PlotUtils.plot_scatter(
            param1_MLM_arr,
            param2_MLM_arr,
            x_label=param1_name,
            y_label=param2_name,
            title='Метод максимального правдоподобия',
            label='MLE estimates',
            color='red',
        )
        plt.show()

        PlotUtils.plot_boxplots(
            {
                f'{param1_name} (MM)': param1_MM_arr,
                f'{param1_name} (MLE)': param1_MLM_arr,
            },
            title=f'Boxplot of {param1_name} estimates',
            ylabel=param1_name,
        )
        plt.show()
        PlotUtils.plot_boxplots(
            {
                f'{param2_name} (MM)': param2_MM_arr,
                f'{param2_name} (MLE)': param2_MLM_arr,
            },
            title=f'Boxplot of {param2_name} estimates',
            ylabel=param2_name,
        )
        plt.show()