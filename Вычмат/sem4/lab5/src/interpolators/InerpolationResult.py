from dataclasses import dataclass
from prettytable import PrettyTable

@dataclass(frozen=True)
class InterpolationResult:
    method: str
    value: float
    details: str


@dataclass(frozen=True)
class ResultTable:
    results: list[InterpolationResult]

    def as_pretty_table(self, precision: int = 8) -> PrettyTable:
        table = PrettyTable(["метод", "значение"])
        table.align = "r"
        table.align["метод"] = "l"
        for result in self.results:
            table.add_row([result.method, f"{result.value:.{precision}f}"])
        return table