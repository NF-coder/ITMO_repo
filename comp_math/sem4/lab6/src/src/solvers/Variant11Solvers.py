from .Solver import Solver
from .AdamsPredictorCorrectorSolver import AdamsPredictorCorrectorSolver
from .ImprovedEulerSolver import ImprovedEulerSolver
from .RungeKutta4Solver import RungeKutta4Solver

class Variant11Solvers:
    
    @staticmethod
    def build() -> list[Solver]:
        return [
            ImprovedEulerSolver(),
            RungeKutta4Solver(),
            AdamsPredictorCorrectorSolver(),
        ]