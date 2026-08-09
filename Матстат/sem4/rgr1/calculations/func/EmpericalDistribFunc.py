import matplotlib.pyplot as plt
from sires.SortedSires import SortedSires

class EmpericalDistribFunc:
    def __init__(self, sorted_data: SortedSires) -> None:
        self._sorted_data = sorted_data

    def _func(self) -> list[float]:
        return [(i+1)/len(self._sorted_data) for i in range(len(self._sorted_data))]

    def draw(self) -> None:
        emp_distrib_arr = self._func()
        sorted_data_list = [self._sorted_data[i] for i in range(len(self._sorted_data))]

        plt.step(sorted_data_list, emp_distrib_arr, where='post')
        plt.scatter(sorted_data_list, emp_distrib_arr)
        plt.title("Эмпирическая функция распределения")