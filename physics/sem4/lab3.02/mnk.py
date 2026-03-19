from math import sqrt
from dataclasses import dataclass
import matplotlib.pyplot as plt

from typing import Callable


@dataclass
class Deviations():
    sigma: float
    delta: float
    epsilon: float

@dataclass
class LinearParams():
    k: float
    shift: float

@dataclass
class ChartParams():
    deviation_sector_min: LinearParams
    deviation_sector_max: LinearParams
    taret: LinearParams

class CalcLinear():
    def __init__(self, x_arr: list[float|int], y_arr: list[float|int]) -> None:
        self._x_arr = x_arr
        self._y_arr = y_arr
    
    def _calc_k(self) -> float:
        avg_x, avg_y = sum(self._x_arr)/len(self._x_arr), sum(self._y_arr)/len(self._y_arr)
        return sum([(x - avg_x)*(y - avg_y) for y,x in zip(self._y_arr, self._x_arr)]) /\
            sum([(x - avg_x)**2 for x in self._x_arr])

    def _calc_shift(self, k: float) -> float:
        avg_x, avg_y = sum(self._x_arr)/len(self._x_arr), sum(self._y_arr)/len(self._y_arr)
        return avg_y - k*avg_x
        
    def __call__(self) -> LinearParams:
        k = self._calc_k()
        shift = self._calc_shift(k)
        return LinearParams(k, shift)

class CalcDeviations():
    def __init__(self, x_arr: list[float|int], y_arr: list[float|int], linear_params: LinearParams) -> None:
        self._x_arr = x_arr
        self._y_arr = y_arr
        self._linear_params = linear_params

    def _calc_sigma(self) -> float:
        function = lambda x: self._linear_params.shift + self._linear_params.k * x
        return sqrt(
            sum([(y - function(x))**2 for x,y in zip(self._x_arr, self._y_arr)]) /\
            (sum([(i-sum(self._x_arr)/6)**2 for i in self._x_arr])*(len(self._x_arr)-2))
        )

    def _calc_delta(self, sigma: float) -> float:
        return 2 * sigma

    def _calc_epsilon(self, delta: float) -> float:
        return delta / abs(self._linear_params.k)
    
    def __call__(self) -> Deviations:
        sigma = self._calc_sigma()
        delta = self._calc_delta(sigma)
        epsilon = self._calc_epsilon(delta)

        return Deviations(sigma, delta, epsilon)


class CalcChartParams():
    def __init__(self, x_arr: list[float|int], y_arr: list[float|int]) -> None:
        self._x_arr = x_arr
        self._y_arr = y_arr

    def __call__(self) -> ChartParams:
        linear_params: LinearParams = CalcLinear(self._x_arr, self._y_arr)()
        deviations: Deviations = CalcDeviations(self._x_arr, self._y_arr, linear_params)()

        return ChartParams(
            deviation_sector_min = LinearParams(
                linear_params.k - deviations.delta,
                linear_params.shift
            ),
            deviation_sector_max = LinearParams(
                linear_params.k + deviations.delta,
                linear_params.shift,
            ),
            taret = linear_params
        )
        
    
class CreateEquations():
    @dataclass
    class Equations():        
        target_eq: "Equation"
        min_linear_eq: "Equation"
        max_linear_eq: "Equation"

        @dataclass
        class Equation():
            k: float
            shift: float
            def __call__(self, x): return x*self.k + self.shift

    def __init__(self, x_arr: list[float|int], y_arr: list[float|int]) -> None:
        self._x_arr = x_arr
        self._y_arr = y_arr
    
    def __call__(self) -> Equations:
        linear_equations_params = CalcChartParams(self._x_arr, self._y_arr)()

        target_equation = self.Equations.Equation(
            linear_equations_params.taret.k,
            linear_equations_params.taret.shift
        )
        min_linear_equation = self.Equations.Equation(
            linear_equations_params.deviation_sector_min.k,
            linear_equations_params.deviation_sector_min.shift
        )
        max_linear_equation = self.Equations.Equation(
            linear_equations_params.deviation_sector_max.k,
            linear_equations_params.deviation_sector_max.shift
        )

        return self.Equations(
            target_equation,
            min_linear_equation,
            max_linear_equation
        )