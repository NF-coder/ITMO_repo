from pathlib import Path
from typing import Callable

from .analyzer import AccuracyAnalyzer
from .equations import DifferentialEquation
from .equations import EquationCatalog
from .models.InitialValueProblem import InitialValueProblem
from .plotter.plotter import OdePlotter
from .solvers.Variant11Solvers import Variant11Solvers
from .tables import ResultTableBuilder


class OdeConsoleApp:
    def run(self) -> None:
        try:
            print("Лабораторная работа №6: численное решение оду")
            print("Вариант 11: Усовершенствованный Эйлер, Рунге-Кутта 4-го порядка, Адамс")

            equation = self._safe_call(self._read_equation)
            problem = self._safe_call(self._read_problem, equation)

            self._run_analysis(equation, problem)
        
        except KeyboardInterrupt: print("Программа прервана пользователем.")
        except Exception as error: print(f"Критическая ошибка: {error}")

    def _run_analysis(self, equation: DifferentialEquation, problem: InitialValueProblem) -> None:
        try:
            analyzer = AccuracyAnalyzer()
            reports = [analyzer.build_report(solver, equation, problem) for solver in Variant11Solvers.build()]
            tables = ResultTableBuilder()

            print("Таблица приближенных значений")
            print(tables.build_values_table(equation, problem, reports))

            print("Оценка точности")
            print(tables.build_accuracy_table(reports))

            output_path = OdePlotter().save(equation, problem, reports, Path("plots") / "solution.png")
            print(f"График сохранен: {output_path}")

        except Exception as error:
            print(f"Ошибка при анализе: {error}")
            raise

    @staticmethod
    def _safe_call[T](callback: Callable[..., T], *args, **kwargs) -> T:
        while True:
            try:
                return callback(*args, **kwargs)
            except (ValueError, IndexError) as error:
                print(f"{error}. Пожалуйста, повторите попытку.\n")
            except KeyboardInterrupt: raise
            except Exception as error:
                print(f"{error}. Пожалуйста, повторите попытку.\n")

    def _read_equation(self) -> DifferentialEquation:
        equations = EquationCatalog.available()
        
        print("Доступные уравнения:")
        for index, equation in enumerate(equations, start=1):
            default = equation.default_problem

            print(f"{index}. {equation.name}: {equation.equation}")
            print(f"   Точное решение: {equation.exact_equation}")
            print(f"   По умолчанию: x0={default.x0}, y0={default.y0}, xn={default.xn}, h={default.h}, eps={default.eps}\n")
        
        choice = self._read_int("Выберите уравнение (1-{}): ".format(len(equations)))
        if choice < 1 or choice > len(equations):
            raise ValueError(f"Нет уравнения с номером {choice}. Доступны номера 1-{len(equations)}")
        
        return equations[choice - 1]

    def _read_problem(self, equation: DifferentialEquation) -> InitialValueProblem:
        default = equation.default_problem
        print("\nВведите параметры задачи или оставьте строку пустой для значения по умолчанию:")
        
        problem = InitialValueProblem(
            x0=self._read_float("x0", default.x0),
            y0=self._read_float("y0", default.y0),
            xn=self._read_float("xn", default.xn),
            h=self._read_float("h", default.h),
            eps=self._read_float("eps", default.eps),
        )
        
        try:
            problem.validate()
        except ValueError as error:
            raise ValueError(f"Ошибка параметров: {error}")
        
        return problem

    @staticmethod
    def _read_float(name: str, default: float) -> float:
        try:
            raw_value = input(f"  {name} [{default}]: ").strip().replace(",", ".")
            
            if not raw_value: return default
            
            return float(raw_value)
        except ValueError:
            raise ValueError(f"{raw_value} не является числом для параметра '{name}'")

    @staticmethod
    def _read_int(prompt: str) -> int:
        try:
            raw_value = input(prompt).strip()
            return int(raw_value)
        except ValueError:
            raise ValueError(f"{raw_value} не является целым числом")
