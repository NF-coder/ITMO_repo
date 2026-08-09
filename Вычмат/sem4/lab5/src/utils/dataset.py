from __future__ import annotations

from dataclasses import dataclass
from math import cos, exp, log, sin
from pathlib import Path
from typing import Callable


@dataclass(frozen=True)
class InterpolationDataset:
    x: list[float]
    y: list[float]
    name: str = "табличная функция"
    source_function: Callable[[float], float] | None = None

    def __post_init__(self) -> None:
        if len(self.x) != len(self.y):
            raise ValueError("количество значений x и y должно совпадать")
        if len(self.x) < 2:
            raise ValueError("для интерполяции нужно не менее двух узлов")
        if len(set(self.x)) != len(self.x):
            raise ValueError("значения x не должны повторяться")
        if self.x != sorted(self.x):
            raise ValueError("значения x должны быть упорядочены по возрастанию")

    @property
    def step(self) -> float | None:
        if len(self.x) < 2:
            return None
        h = self.x[1] - self.x[0]
        for left, right in zip(self.x, self.x[1:]):
            if abs((right - left) - h) > 1e-9:
                return None
        return h

    def contains(self, value: float) -> bool:
        return self.x[0] <= value <= self.x[-1]

    @classmethod
    def from_pairs(cls, pairs: list[tuple[float, float]], name: str = "ручной ввод") -> "InterpolationDataset":
        if not pairs:
            raise ValueError("таблица не может быть пустой")
        ordered = sorted(pairs, key=lambda item: item[0])
        return cls([point[0] for point in ordered], [point[1] for point in ordered], name)

    @classmethod
    def from_file(cls, file_path: str | Path) -> "InterpolationDataset":
        path = Path(file_path)
        if not path.exists():
            raise FileNotFoundError(f"файл {path} не найден")
        pairs: list[tuple[float, float]] = []
        for line_number, raw_line in enumerate(path.read_text(encoding="utf-8").splitlines(), start=1):
            line = raw_line.strip()
            if not line or line.startswith("#"):
                continue
            parts = line.replace(";", " ").replace(",", ".").split()
            if len(parts) != 2:
                raise ValueError(f"строка {line_number}: ожидаются два числа")
            pairs.append((float(parts[0]), float(parts[1])))
        return cls.from_pairs(pairs, f"данные из {path}")

    @classmethod
    def from_function(
        cls,
        function_name: str,
        left: float,
        right: float,
        points_count: int,
    ) -> "InterpolationDataset":
        functions = FunctionCatalog.available()
        if function_name not in functions:
            raise ValueError("неизвестная функция")
        if points_count < 2:
            raise ValueError("количество точек должно быть не меньше двух")
        if right <= left:
            raise ValueError("правая граница должна быть больше левой")
        step = (right - left) / (points_count - 1)
        x_values = [left + i * step for i in range(points_count)]
        function = functions[function_name]
        y_values = [function(value) for value in x_values]
        return cls(x_values, y_values, function_name, function)


class FunctionCatalog:
    @staticmethod
    def available() -> dict[str, Callable[[float], float]]:
        return {
            "sin(x)": sin,
            "cos(x)": cos,
            "exp(x)": exp,
            "ln(x)": log,
            "x^2 + 2x + 1": lambda x: x * x + 2 * x + 1,
        }
