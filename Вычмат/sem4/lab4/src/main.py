import matplotlib.pyplot as plt

from utils.data_utils import load_data_from_file, load_data_from_function, original_function
from utils.least_squares import LeastSquaresApproximation


def read_manual_points() -> tuple[list[float] | None, list[float] | None]:
    try:
        n = int(input("Введите количество точек (8-12): "))
        if n < 8 or n > 12:
            print("Ошибка: количество точек должно быть от 8 до 12")
            return None, None

        x_data: list[float] = []
        y_data: list[float] = []

        print("Введите пары (x, y):")
        for i in range(n):
            while True:
                try:
                    x, y = map(float, input(f"Точка {i + 1}: x, y = ").split())
                    x_data.append(x)
                    y_data.append(y)
                    break
                except ValueError:
                    print("Ошибка ввода. Введите два числа, разделенные пробелом")

        return x_data, y_data
    except ValueError:
        print("Ошибка: неверное значение")
        return None, None


def choose_data_source() -> tuple[list[float] | None, list[float] | None]:
    print("\nВыберите источник данных:")
    print("1. Табулирование функции (вариант 11)")
    print("2. Загрузить из файла")
    print("3. Ввести вручную")

    choice = input("\nВаш выбор (1-3): ").strip()

    if choice == "1":
        x_start, x_end, step = -2.0, 0.0, 0.2
        print(f"\nТабулирование функции на интервале [{x_start}, {x_end}] с шагом {step}")
        x_data, y_data = load_data_from_function(original_function, x_start, x_end, step)
        print(f"Загружено {len(x_data)} точек")
        return x_data, y_data

    if choice == "2":
        filename = input("Введите имя файла: ").strip()
        x_data, y_data = load_data_from_file(filename)
        if x_data is not None:
            print(f"Загружено {len(x_data)} точек из файла {filename}")
        return x_data, y_data

    if choice == "3":
        return read_manual_points()

    print("Неверный выбор")
    return None, None


def choose_output_target(approx: LeastSquaresApproximation) -> None:
    print("\nВыбор способа вывода результатов:")
    print("1. В консоль")
    print("2. В файл")
    print("3. В консоль и в файл")

    output_choice = input("Ваш выбор (1-3): ").strip()
    output_file = None

    if output_choice in ["2", "3"]:
        output_file = input("Введите имя файла для сохранения результатов: ").strip()
        if not output_file.endswith(".txt"):
            output_file += ".txt"

    if output_choice in ["1", "3"]:
        approx.print_results(output_file if output_choice == "3" else None)
    elif output_choice == "2":
        approx.print_results(output_file)
    else:
        print("Неверный выбор. Результаты выведены на консоль по умолчанию.")
        approx.print_results()


def main() -> None:
    x_data, y_data = choose_data_source()
    if x_data is None or y_data is None or len(x_data) == 0:
        print("Ошибка: не удалось загрузить данные")
        return

    print("\nВыполнение аппроксимаций...")
    approx = LeastSquaresApproximation(x_data, y_data)
    approx.perform_all_approximations()

    choose_output_target(approx)

    print("\nПостроение графиков...")
    fig = approx.plot_approximations()
    graph_file = "approximation_graph.png"
    fig.savefig(graph_file, dpi=150, bbox_inches="tight")
    print(f"График сохранен в файл: {graph_file}")
    plt.show()


if __name__ == "__main__":
    main()
