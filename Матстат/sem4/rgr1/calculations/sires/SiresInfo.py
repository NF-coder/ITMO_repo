from sires.SortedSires import SortedSires
import math

def quantile(sorted_data: SortedSires, q: float):
    n = len(sorted_data)
    idx = q * (n - 1)
    lower = int(math.floor(idx))
    upper = int(math.ceil(idx))
    
    if lower == upper:
        return sorted_data[lower]
    
    weight = idx - lower
    return sorted_data[lower] * (1 - weight) + sorted_data[upper] * weight

class SiresInfo:
    def __init__(self, sorted_data: SortedSires):
        self.n = len(sorted_data)
        self.mean = sum(sorted_data) / len(sorted_data)
        self.s2_biased = (1 / len(sorted_data)) * sum([abs(elem - self.mean) ** 2 for elem in sorted_data])
        self.s2 = (1 / (len(sorted_data) - 1)) * sum([abs(elem - self.mean) ** 2 for elem in sorted_data])
        self.s = math.sqrt(self.s2)
        self.s_biased = math.sqrt(self.s2_biased)
        self.median = (sorted_data[len(sorted_data) // 2 - 1] + sorted_data[len(sorted_data) // 2]) / 2
        self.x_min = sorted_data.get_min()
        self.x_max = sorted_data.get_max()
        self.q25 = quantile(sorted_data, 0.25)
        self.q75 = quantile(sorted_data, 0.75)

    def __repr__(self) -> str:
        return "Выборочные оценки:" +\
            f"\n    Среднее:                    x̄ = {self.mean:.3f}"                   +\
            f"\n    Медиана:                    x̃ =  {self.median:.3f}"                +\
            f"\n    Размах:                     [{self.x_min:.1f}, {self.x_max:.1f}]"  +\
            f"\n    Дисперсия (смещённая):      S² =  {self.s2_biased:.3f}"            +\
            f"\n    Дисперсия (несмещённая):    σ² =  {self.s2:.3f}"                   +\
            f"\n    Ст. отклонение (смещ.):     S =  {self.s_biased:.3f}"              +\
            f"\n    Ст. отклонение (несмещ.):   σ =  {self.s:.3f}"                     +\
            f"\n    Квантиль 25%:               {self.q25:.3f}"                        +\
            f"\n    Квантиль 50%:               {self.median:.3f}"                     +\
            f"\n    Квантиль 75%:               {self.q75:.3f}"