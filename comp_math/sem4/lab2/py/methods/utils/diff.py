from typing import Callable

diff: Callable[
    [
        Callable[[float | int], float | int],
        float | int,
        float | int
    ],
    float | int
] = lambda f, x, eps: (f(x + eps) - f(x - eps)) / (2 * eps)

diff_x: Callable[
    [
        Callable[[float | int, float | int,], float | int],
        float | int,
        float | int,
        float | int,
    ],
    float | int
] = lambda f, x, y, eps: (f(x + eps, y) - f(x - eps, y)) / (2*eps)

diff_y: Callable[
    [
        Callable[[float | int, float | int,], float | int],
        float | int,
        float | int,
        float | int
    ],
    float | int
] = lambda f, x, y, eps: (f(x, y + eps) - f(x, y - eps)) / (2*eps)
