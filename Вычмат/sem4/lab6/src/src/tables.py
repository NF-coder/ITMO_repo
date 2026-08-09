from prettytable import PrettyTable

from .equations import DifferentialEquation
from .models.InitialValueProblem import InitialValueProblem
from .models.MethodReport import MethodReport


class ResultTableBuilder:  
    def build_values_table(
        self,
        equation: DifferentialEquation,
        problem: InitialValueProblem,
        reports: list[MethodReport],
        precision: int = 6,
    ) -> PrettyTable:
        try:
            headers = ["i", "x", "точное"]
            headers.extend(report.solution.method for report in reports)

            table = PrettyTable(headers)
            table.align = "r"
            
            exact = equation.exact(problem)
            for point_index in range(len(reports[0].solution.points)):
                source_point = reports[0].solution.points[point_index]
                row = [
                    source_point.index,
                    f"{source_point.x:.{precision}f}",
                    f"{exact(source_point.x):.{precision}f}",
                ]
                for report in reports:
                    row.append(f"{report.solution.points[point_index].y:.{precision}f}")
                table.add_row(row)
            
            return table
        except Exception as error:
            raise RuntimeError(f"ошибка при построении таблицы значений: {error}")

    @staticmethod
    def build_accuracy_table(reports: list[MethodReport], precision: int = 8) -> PrettyTable:
        try:
            table = PrettyTable(["метод", "порядок", "оценка Рунге", "max |y_точн - y|"])
            table.align = "r"
            table.align["метод"] = "l"
            
            for report in reports:
                runge_error = "-" if report.runge_error is None else f"{report.runge_error:.{precision}f}"
                table.add_row([
                    report.solution.method,
                    report.solution.order,
                    runge_error,
                    f"{report.exact_error:.{precision}f}",
                ])
            
            return table
        except Exception as error:
            raise RuntimeError(f"Ошибка при построении таблицы точности: {error}")
