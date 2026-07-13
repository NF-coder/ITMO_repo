
from pathlib import Path

from src.analyzer import AccuracyAnalyzer
from src.equations import EquationCatalog
from src.plotter.plotter import OdePlotter
from src.solvers.Variant11Solvers import Variant11Solvers
from src.tables import ResultTableBuilder


class Variant11Demo:
    def run(self) -> None:
        equations = EquationCatalog.available()
        analyzer = AccuracyAnalyzer()
        tables = ResultTableBuilder()

        for index, equation in enumerate(equations, start=1):
            reports = [
                analyzer.build_report(solver, equation, equation.default_problem)
                for solver in Variant11Solvers.build()
            ]
            print(f"Пример {index}: {equation.equation}")
            print(tables.build_values_table(equation, equation.default_problem, reports))
            print(tables.build_accuracy_table(reports))

            path = OdePlotter().save(equation, equation.default_problem, reports, Path("plots") / f"example_{index}.png")
            
            print(f"График сохранен: {path}\n")


if __name__ == "__main__":
    Variant11Demo().run()
