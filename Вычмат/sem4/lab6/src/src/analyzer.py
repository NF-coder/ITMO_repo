
from .equations import DifferentialEquation
from .models.InitialValueProblem import InitialValueProblem
from .models.MethodReport import MethodReport
from .solvers.Solver import Solver


class AccuracyAnalyzer:
    def build_report(
        self,
        solver: Solver,
        equation: DifferentialEquation,
        problem: InitialValueProblem,
    ) -> MethodReport:
        try:
            solution = solver.solve(equation, problem)
            exact = equation.exact(problem)
            
            exact_error = max(abs(exact(point.x) - point.y) for point in solution.points)
            runge_error = self._compute_runge_error(solver, equation, problem, solution, exact)
            
            return MethodReport(solution=solution, runge_error=runge_error, exact_error=exact_error)
        except Exception as error:
            raise RuntimeError(f"ошибка при анализе метода {solver.name}: {error}")

    @staticmethod
    def _compute_runge_error(solver: Solver, equation: DifferentialEquation, problem: InitialValueProblem, solution, exact) -> float | None:
        try:
            if solver.order not in (1, 2, 4) or "Адамса" in solver.name:
                return None
            
            half_problem = InitialValueProblem(problem.x0, problem.y0, problem.xn, problem.h / 2, problem.eps)
            half_solution = solver.solve(equation, half_problem)
            runge_error = abs(solution.last_y - half_solution.last_y) / (2**solver.order - 1)
            
            return runge_error
        except Exception:
            return None

