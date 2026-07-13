from dataclasses import dataclass


@dataclass(frozen=True)
class InitialValueProblem:
    x0: float
    y0: float
    xn: float
    h: float
    eps: float

    def validate(self) -> None:
        if self.h <= 0:
            raise ValueError(f"шаг должен быть положительным (задано: {self.h})")
        if self.eps <= 0:
            raise ValueError(f"точность должна быть положительной (задано: {self.eps})")
        if self.xn <= self.x0:
            raise ValueError(f"правая граница ({self.xn}) должна быть больше начальной ({self.x0})")
        
        interval = self.xn - self.x0
        steps = interval / self.h
        
        if round(steps) < 1:
            raise ValueError(f"шаг слишком большой для заданного интервала (интервал: {interval}, шаг: {self.h}, шагов: {steps:.2f})")
        if abs(steps - round(steps)) > 1e-9:
            raise ValueError(f"длина интервала ({interval}) должна делиться на шаг ({self.h}) без остатка (остаток: {steps % 1:.2e})")

    @property
    def steps_count(self) -> int:
        return int(round((self.xn - self.x0) / self.h))
