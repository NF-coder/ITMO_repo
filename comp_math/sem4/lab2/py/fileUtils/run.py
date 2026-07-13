from fileUtils.parsers import *
from fileUtils.reader import read_input_file
from typing_extensions import Optional, Callable
from pathlib import Path
from result_builders.buildEqRes import build_equation_result
from result_builders.buildSysRes import build_system_result
from plot.plotFunc import plot_function


def get_output_path(params: dict[str, str]) -> Optional[str]:
    output = params.get("output", "screen").strip()
    output_lower = output.lower()

    if output_lower in ("screen", "stdout", "console", "экран"):
        return None
    if output_lower in ("file", "файл"):
        return get_required(params, ("output_file", "out", "result_file"))

    return output


def get_required(params: dict[str, str], keys: tuple[str, ...]) -> str:
    for key in keys:
        if key in params:
            return params[key]

    raise KeyError(keys[0])

def write_result(result: str, output_path: Optional[str]) -> None:
    if output_path:
        Path(output_path).expanduser().write_text(result + "\n", encoding="utf-8")
        print(f"[+] Результат записан в файл: {output_path}\n")
    else:
        print(result)

def parse_positional_output(values: list[str], output_idx: int) -> Optional[str]:
    if len(values) <= output_idx:
        return None

    output = values[output_idx]
    if output.lower() in ("screen", "stdout", "console", "экран", "-"):
        return None

    return output


def run_from_file(
    path: str,
    systems: list[
        tuple[
            str,
            tuple[
                Callable[[float | int, float | int], float | int ],
                Callable[[float | int, float | int], float | int ]
            ]
        ]
    ],
    functions: list[
        tuple[
            str,
            Callable[[float | int], float | int ]
        ]
    ],
    methods: list[str]
) -> None:
    try:
        params, values = read_input_file(path)

        if params:
            task = get_required(params, ("task", "mode", "type")).strip().lower()
        else:
            if not values:
                raise ValueError("файл пуст")
            task = values[0].strip().lower()

        if task in ("equation", "eq", "function", "уравнение"):
            if params:
                function_idx = parse_number(
                    get_required(params, ("function", "func", "f")),
                    "function",
                    len(functions)
                )
                a = parse_float(get_required(params, ("a", "left")), "a")
                b = parse_float(get_required(params, ("b", "right")), "b")
                method = parse_method(get_required(params, ("method", "m")), methods)
                eps = parse_float(get_required(params, ("eps", "epsilon")), "eps")
                plot = parse_bool(params.get("plot", "no"), "plot")
            else:
                if len(values) < 6:
                    raise ValueError("для уравнения нужно: equation function a b method eps")
                function_idx = parse_number(values[1], "function", len(functions))
                a = parse_float(values[2], "a")
                b = parse_float(values[3], "b")
                method = parse_method(values[4], methods)
                eps = parse_float(values[5], "eps")
                plot = parse_bool(values[7], "plot") if len(values) > 7 else False

            if b <= a:
                raise ValueError("правая граница b должна быть больше a")
            if eps <= 0:
                raise ValueError("eps должен быть положительным")

            name, func = functions[function_idx]
            result = build_equation_result(name, func, a, b, method, eps, methods)
            output_path = get_output_path(params) if params else parse_positional_output(values, 6)
            write_result(result, output_path)

            if plot:
                plot_function(a, b, func)

        elif task in ("system", "sys", "система"):
            if params:
                system_idx = parse_number(
                    get_required(params, ("system", "sys", "s")),
                    "system",
                    len(systems)
                )
                x0 = parse_float(get_required(params, ("x0", "x")), "x0")
                y0 = parse_float(get_required(params, ("y0", "y")), "y0")
                eps = parse_float(get_required(params, ("eps", "epsilon")), "eps")
            else:
                if len(values) < 5:
                    raise ValueError("для системы нужно: system system_number x0 y0 eps")
                system_idx = parse_number(values[1], "system", len(systems))
                x0 = parse_float(values[2], "x0")
                y0 = parse_float(values[3], "y0")
                eps = parse_float(values[4], "eps")

            if eps <= 0:
                raise ValueError("eps должен быть положительным")

            name, funcs = systems[system_idx]
            f1, f2 = funcs
            result = build_system_result(name, f1, f2, x0, y0, eps)
            output_path = get_output_path(params) if params else parse_positional_output(values, 5)
            write_result(result, output_path)

        else:
            raise ValueError("task должен быть equation или system")

    except (OSError, KeyError, ValueError) as exc:
        print(f"[!] Не удалось выполнить задачу из файла: {exc}\n")