import numpy as np
from typing_extensions import Callable
from mathUtils.sampleFunc import sample_function
import matplotlib.pyplot as plt

def plot_function(
    a: float,
    b: float,
    f: Callable[[float | int], float | int]
) -> None:
    margin = max((b - a) * 0.08, 1e-3)
    x = np.linspace(a - margin, b + margin, 600).tolist()
    y = sample_function(f, x)

    interval_x = np.linspace(a, b, 400).tolist()
    interval_y = sample_function(f, interval_x)
    finite_interval = np.isfinite(interval_y)

    plt.figure()
    plt.axhline(0, color="k", linewidth=0.8)
    plt.axvline(a, color="tab:red", linestyle="--", linewidth=1.2, label=f"a = {a:g}")
    plt.axvline(b, color="tab:green", linestyle="--", linewidth=1.2, label=f"b = {b:g}")
    plt.plot(x, y, color="tab:blue", linewidth=1.8, label="f(x)")
    plt.fill_between(
        interval_x,
        interval_y,
        0,
        where=finite_interval,
        color="tab:blue",
        alpha=0.18,
        interpolate=True,
        label="Область под графиком"
    )
    plt.title(f"График функции на [{a:g}, {b:g}]")
    plt.xlabel("x")
    plt.ylabel("f(x)")
    plt.grid()
    plt.legend()
    plt.show()