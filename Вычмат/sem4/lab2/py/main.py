import math
from pathlib import Path
from typing import Callable

from SceneManager import SceneManager
from fileUtils.run import run_from_file
from plot.plotFunc import plot_function
from result_builders.buildEqRes import build_equation_result
from result_builders.buildSysRes import build_system_result


# Functions
FUNCTIONS: list[
    tuple[
        str,
        Callable[[float | int], float | int ]
    ]
] = [
    ("f1(x) = 4.45*x^3 + 7.81*x^2 - 9.62*x - 8.17",
     lambda x: 4.45*x**3 + 7.81*x**2 - 9.62*x - 8.17),
    ("f2(x) = x^3 - 2*x - 5",
     lambda x: x**3 - 2*x - 5),
    ("f3(x) = cos(x) - x",
     lambda x: math.cos(x) - x),
]

SYSTEMS: list[
    tuple[
        str,
        tuple[
            Callable[[float | int, float | int], float | int ],
            Callable[[float | int, float | int], float | int ]
        ]
    ]
] = [
    ("tan(xy+0.2)-x^2=0, x^2+2y^2-1=0",
     (lambda x, y: math.tan(x*y + 0.2) - x**2,
      lambda x, y: x**2 + 2*y**2 - 1)),
]

METHODS = ["Простая итерация", "Метод Ньютона", "Метод хорд"]


def choose_output_destination(result: str) -> None:
    destination = SceneManager.choose_from_list(
        "[?] Куда вывести результат?",
        [("На экран", "screen"), ("В файл", "file")]
    )

    if destination == "file":
        path = input("[?] Путь к файлу для вывода:\n").strip()
        try:
            Path(path).expanduser().write_text(result + "\n", encoding="utf-8")
            print(f"[+] Результат записан в файл: {path}\n")
        except OSError as exc:
            print(f"[!] Не удалось записать результат: {exc}\n")
    else:
        print(result)

def run_file_mode() -> None:
    print("[i] Пример для уравнения:")
    print("    task=equation, function=1, a=-3, b=-2, method=2, eps=0.01")
    print("    output=file, output_file=/tmp/result.txt, plot=no")
    print("[i] Пример для системы:")
    print("    task=system, system=1, x0=0.5, y0=0.5, eps=0.01\n")

    path = input("[?] Путь к файлу с исходными данными:\n").strip()
    run_from_file(path, SYSTEMS, FUNCTIONS, METHODS)


def main_menu() -> None:
    opts = [
        ("Уравнение f(x) = 0", "equation"),
        ("Система уравнений", "system"),
        ("Ввод из файла", "file"),
        ("Выход", "exit"),
    ]
    
    choice = SceneManager.choose_from_list(
        "\nМЕНЮ",
        [(name, val) for name, val in opts]
    )
    
    if choice == "exit":
        print("\nДо свидания!\n")
        exit(0)

    if choice == "file":
        run_file_mode()
        return
    
    if choice == "equation":
        print("\nРЕЖИМ: УРАВНЕНИЕ\n")
        func_choice = SceneManager.choose_from_list(
            "[?] Выберите функцию:",
            [(name, (name, func)) for name, func in FUNCTIONS]
        )
        if func_choice is None: return
        
        name, func = func_choice
        print(f"[+] Функция: {name}\n")

        bounds = SceneManager.input_pair(
            "[?] Левая граница a:",
            "[?] Правая граница b:",
            validator=lambda a, b: b > a # pyright: ignore[reportUnknownLambdaType, reportOperatorIssue]
        )
        if not bounds: return
        a, b = bounds
        
        method = SceneManager.choose_from_list(
            "[?] Выберите метод:",
            [(m, i) for i, m in enumerate(METHODS)]
        )
        if method is None: return
        
        eps_val = SceneManager.input_float_optional(
            "[?] Точность (по умолчанию 0.01):",
            default=0.01,
            validator=lambda e: e > 0,
            error_msg="[!] Должно быть положительным\n"
        )
        if eps_val is None: return

        print()
        print(f"[+] Интервал: [{a}, {b}]")
        print(f"[+] Метод: {METHODS[method]}")
        print(f"[+] Точность: {eps_val}")
        print()
        
        result = build_equation_result(name, func, a, b, method, eps_val, METHODS)
        choose_output_destination(result)
        
        if SceneManager.confirm("[?] Показать график?"):
            plot_function(a, b, func)
    
    elif choice == "system":
        print("\nРЕЖИМ: СИСТЕМА\n")
        sys_choice = SceneManager.choose_from_list(
            "[?] Выберите систему:",
            [(name, (name, funcs)) for name, funcs in SYSTEMS]
        )
        if sys_choice is None: return
        
        name, funcs = sys_choice
        f1, f2 = funcs
        print(f"[+] Система: {name}\n")

        eps_val = SceneManager.input_float(
            "[?] Точность (по умолчанию 0.01):",
            default=0.01,
            validator=lambda e: e > 0,
            error_msg="[!] Должно быть положительным\n"
        )
        if eps_val is None: return
        
        approx = SceneManager.input_pair(
            "[?] Начальное приближение x0:",
            "[?] Начальное приближение y0:"
        )
        if not approx: return
        x0, y0 = approx

        print(f"[+] Точность: {eps_val}")
        print(f"[+] Начальные значения: x0={x0}, y0={y0}\n")
        
        result = build_system_result(name, f1, f2, x0, y0, eps_val)
        choose_output_destination(result)


if __name__ == "__main__":
    try:
        while True:
            main_menu()
    except KeyboardInterrupt:
        print("\n\n[!] Прервано пользователем\n")
        exit(0)
