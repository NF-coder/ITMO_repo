from pathlib import Path

from interpolators.InerpolationResult import InterpolationResult
from utils.dataset import FunctionCatalog, InterpolationDataset
from utils.differences import FiniteDifferenceTable
from utils.plotter import InterpolationPlotter
from interpolators import *

from typing_extensions import Any, Callable


class InterpolationApp:
    def run(self) -> None:
        print("Лабораторная работа №5: интерполяция функции")

        dataset = InterpolationApp._safe_call(
            self._read_dataset,
        )
        x_value = InterpolationApp._safe_call(
            self._read_float,
            "Введите значение аргумента для интерполяции: "
        )

        differences = FiniteDifferenceTable(dataset)

        print("\nТаблица конечных разностей")
        print(differences.as_pretty_table())

        results: list[InterpolationResult] = [LagrangeInterpolator().build(dataset).evaluate(x_value)] # type: ignore 
        if dataset.step is not None:
            interpolators: list[Any] = [NewtonInterpolator(), GaussInterpolator(), StirlingInterpolator(), BesselInterpolator()]
            for interpolator in interpolators:
                try:
                    interpolator = interpolator.build(dataset, differences)
                    results.append(interpolator.evaluate(x_value))
                except ValueError as error:
                    print(f"\nМетод пропущен: {error}")
        else:
            print("\nУзлы не равноотстоящие, поэтому формулы с конечными разностями пропущены")
        
        print("\nРезультаты")
        print(ResultTable(results).as_pretty_table())
        output_path = InterpolationPlotter(dataset).save(Path("plots") / "interpolation.png")
        print(f"\nГрафик сохранен: {output_path}")

    @staticmethod
    def _safe_call[T](callback: Callable[..., T],*args: ..., **kwargs: ...) -> T:
         while True:
            try:
                return callback(*args, **kwargs)
            except Exception as e:
                print(e)

    def _read_dataset(self) -> InterpolationDataset:
        print("\nСпособ задания исходных данных")
        print("1. Ручной ввод таблицы")
        print("2. Чтение из файла")
        print("3. Табулирование функции")

        choice = input("Выберите пункт: ").strip()

        if choice == "1":
            return self._read_manual_dataset()
        if choice == "2":
            path = input("путь к файлу: ").strip()
            return InterpolationDataset.from_file(path)
        if choice == "3":
            return self._read_function_dataset()
        
        raise ValueError("нужно выбрать 1, 2 или 3")

    def _read_manual_dataset(self) -> InterpolationDataset:
        count = self._read_int("количество точек: ")

        pairs: list[tuple[float, float]] = []
        for index in range(count):
            x_value = InterpolationApp._safe_call(
                self._read_float,
                f"x{index}: "
            )
            y_value = InterpolationApp._safe_call(
                self._read_float,
                f"y{index}: "
            )
            pairs.append((x_value, y_value))
        
        return InterpolationDataset.from_pairs(pairs)

    def _read_function_dataset(self) -> InterpolationDataset:
        functions = list(FunctionCatalog.available())

        print("\nДоступные функции")
        for index, name in enumerate(functions, start=1):
            print(f"{index}. {name}")
        
        choice = InterpolationApp._safe_call(
            self._read_func_choice,
            functions
        )
        
    
        left = InterpolationApp._safe_call(
            self._read_float,
            "Левая граница: "
        )
        right = InterpolationApp._safe_call(
            self._read_float,
            "Правая граница: "
        )
        count = InterpolationApp._safe_call(
            self._read_int,
            "Количество точек: "
        )

        return InterpolationDataset.from_function(functions[choice - 1], left, right, count)

    def _read_func_choice(self, functions: list[str]) -> int:
        choice = self._read_int("Выберите функцию: ")
        if choice < 1 or choice > len(functions):
            raise ValueError("Нет функции с таким номером")
        
        return choice

    @staticmethod
    def _read_float(prompt: str) -> float:
        return float(input(prompt).strip().replace(",", "."))

    @staticmethod
    def _read_int(prompt: str) -> int:
        return int(input(prompt).strip())

if __name__ == "__main__":
    InterpolationApp().run()
