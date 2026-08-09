from typing import Callable, Optional
import re

class InputCallback:
    def __init__[T](
        self,
        callback: Callable[..., T],
        option: Optional[str]
    ) -> None:
        self._callback = callback
        self._option = option
    
    def __call__(self, *args: ..., **kwargs: ...) -> None:
        self._callback(*args, **kwargs)
    
    @property
    def option(self) -> Optional[str]:
        return self._option

class ChoiceInput:
    def __init__(
        self,
        title: str,
        options: list[tuple[str, InputCallback]],
        on_failure: Callable[[], None]
    ) -> None:
        self._title = title
        self._options = options
        self._on_failure = on_failure
    
    def _input(self) -> None:
        result = input()
        for option in self._options:
            if result == option[1].option:
                option[1]()
                return
        print("[!] Неверный вариант")
        self._on_failure()

    def render(self) -> None:
        print(self._title)
        print("\n" +
            "\n".join(
                [f"  {opt[1].option} - {opt[0]}" for opt in self._options]
            )
        )
        self._input()

class ValidatedInput:
    def __init__(
        self,
        title: str,
        pattern: str,
        callback: InputCallback,
        on_failure: Callable[[], None]
    ) -> None:
        self._title = title
        self._pattern = pattern
        self._callback = callback
        self._on_failure = on_failure
    
    def _input(self) -> None:
        result = input()
        if re.fullmatch(self._pattern, result):
            self._callback(result)
            return
        print("[!] Неверный ввод")
        self._on_failure()

    def render(self) -> None:
        print(self._title)
        self._input()

class NumericInput(ValidatedInput):
    def __init__(
        self,
        title: str,
        callback: InputCallback,
        on_failure: Callable[[], None]
    ) -> None:
        super().__init__(
            title,
            r'[+-]?\d+(?:\.\d+)?',
            callback,
            on_failure
        )

class NumericOrEmptyInput(ValidatedInput):
    def __init__(
        self,
        title: str,
        callback: InputCallback,
        on_failure: Callable[[], None]
    ) -> None:
        super().__init__(
            title,
            r'^$|[+-]?\d+(?:\.\d+)?',
            callback,
            on_failure
        )