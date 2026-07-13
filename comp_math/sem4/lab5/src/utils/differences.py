from prettytable import PrettyTable
from .dataset import InterpolationDataset
from typing_extensions import Any

class FiniteDifferenceTable:
    def __init__(self, dataset: InterpolationDataset) -> None:
        self.dataset = dataset
        self.levels = self._build_levels(dataset.y)

    @staticmethod
    def _build_levels(values: list[float]) -> list[list[float]]:
        levels = [values]
        current: list[float] = values
        
        while len(current) > 1:
            current = [current[i + 1] - current[i] for i in range(len(current) - 1)]
            levels.append(current)

        return levels

    def value(self, order: int, index: int) -> float:
        if order < 0 or order >= len(self.levels):
            raise IndexError("Порядок разности вне таблицы")
        if index < 0 or index >= len(self.levels[order]):
            raise IndexError("Индекс разности вне таблицы")
        return self.levels[order][index]

    def as_pretty_table(self, precision: int = 6) -> PrettyTable:
        field_names = ["i", "x", "y"] + [f"Δ^{order} y" for order in range(1, len(self.levels))]
        table = PrettyTable(field_names)
        table.align = "r"
        for row_index, x_value in enumerate(self.dataset.x):
            row: list[Any] = [row_index, self._format(x_value, precision), self._format(self.dataset.y[row_index], precision)]
            for order in range(1, len(self.levels)):
                if row_index < len(self.levels[order]):
                    row.append(self._format(self.levels[order][row_index], precision))
                else:
                    row.append("")
            table.add_row(row)
        return table

    def as_typst_rows(self, precision: int = 6) -> list[list[str]]:
        rows: list[list[str]] = []
        for row_index, x_value in enumerate(self.dataset.x):
            row = [str(row_index), self._format(x_value, precision), self._format(self.dataset.y[row_index], precision)]
            for order in range(1, len(self.levels)):
                if row_index < len(self.levels[order]):
                    row.append(self._format(self.levels[order][row_index], precision))
                else:
                    row.append("")
            rows.append(row)
        return rows

    @staticmethod
    def _format(value: float, precision: int) -> str:
        text = f"{value:.{precision}f}".rstrip("0").rstrip(".")
        return text if text not in {"-0", ""} else "0"
