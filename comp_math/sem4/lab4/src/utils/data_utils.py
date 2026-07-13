from typing import Callable

import numpy as np


def original_function(x: float | np.ndarray) -> float | np.ndarray:
    return 5 * x / (x ** 4 + 11)


def load_data_from_function(
    func: Callable[[float | np.ndarray], float | np.ndarray], x_start: float, x_end: float, step: float
) -> tuple[list[float], list[float]]:
    x_data: list[float] = []
    y_data: list[float] = []
    current = x_start
    while current <= x_end + 1e-6:
        x_data.append(current)
        y_data.append(float(func(current)))
        current += step
    return x_data, y_data


def load_data_from_file(filename: str) -> tuple[list[float] | None, list[float] | None]:
    try:
        data = np.loadtxt(filename, dtype=float)
        if data.ndim == 1:
            print("Ошибка: файл должен содержать два столбца (x, y)")
            return None, None
        if data.shape[1] != 2:
            print(f"Ошибка: файл должен содержать ровно два столбца, найдено {data.shape[1]}")
            return None, None

        x_data = data[:, 0].tolist()
        y_data = data[:, 1].tolist()
        if len(x_data) < 8 or len(x_data) > 12:
            print(f"Предупреждение: количество точек {len(x_data)} не в диапазоне [8, 12]")
        return x_data, y_data
    except Exception as exc:
        print(f"Ошибка при чтении файла: {exc}")
        return None, None
