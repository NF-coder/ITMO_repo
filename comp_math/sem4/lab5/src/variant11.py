from utils.dataset import InterpolationDataset
from utils.differences import FiniteDifferenceTable
from utils.plotter import InterpolationPlotter
from interpolators import *


def build_dataset() -> InterpolationDataset:
    return InterpolationDataset(
        x=[0.25, 0.30, 0.35, 0.40, 0.45, 0.50, 0.55],
        y=[1.2557, 2.1764, 3.1218, 4.0482, 5.9875, 6.9195, 7.8359],
        name="Вариант 11",
    )


def main() -> None:
    dataset = build_dataset()
    differences = FiniteDifferenceTable(dataset)
    
    print("Таблица конечных разностей")
    print(differences.as_pretty_table())

    for x_value in [0.255, 0.405]:
        print(f"\nx = {x_value}")
        results = [
            LagrangeInterpolator().build(dataset).evaluate(x_value),
            NewtonInterpolator().build(dataset, differences).evaluate(x_value),
            GaussInterpolator().build(dataset, differences).evaluate(x_value),
            StirlingInterpolator().build(dataset, differences).evaluate(x_value),
            BesselInterpolator().build(dataset, differences).evaluate(x_value),
        ]
        print(ResultTable(results).as_pretty_table())
        for result in results:
            print(f"{result.method}: {result.details}")
    
    path = InterpolationPlotter(dataset).save("plots/variant11.png")
    print(f"\nГрафик сохранен: {path}")


if __name__ == "__main__":
    main()
