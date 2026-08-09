from typing import Callable, Optional, Tuple, List
from Control import ChoiceInput, InputCallback, NumericInput, NumericOrEmptyInput


class SceneManager:
    
    @staticmethod
    def choose_from_list[T](
        title: str,
        items: List[Tuple[str, T]]
    ) -> Optional[T]:
        while True:
            selected: Optional[T] = None
            
            def make_selector(idx: int):
                nonlocal selected
                def selector():
                    nonlocal selected
                    selected = items[idx][1]
                return selector
            
            def retry():
                print("[!] Неверный выбор. Попробуйте еще раз.\n")
            
            options = [
                (name, InputCallback(make_selector(i), str(i + 1)))
                for i, (name, _) in enumerate(items)
            ]
            ChoiceInput(title=title, options=options, on_failure=retry).render()
            
            if selected is not None:
                return selected
    
    @staticmethod
    def input_float(
        title: str,
        default: Optional[float] = None,
        validator: Optional[Callable[[float], bool]] = None,
        error_msg: str = "[!] Неверный ввод. Попробуйте еще раз.\n"
    ) -> Optional[float]:
        while True:
            result: Optional[int | float] = None
            
            def set_value(value: str):
                nonlocal result
                try:
                    val = float(value)
                    if validator and not validator(val):
                        print(error_msg)
                    else:
                        result = val
                except ValueError:
                    print("[!] Ошибка преобразования. Попробуйте еще раз. (Игнорируйте сообщение если ввели пустое значение)")
            
            def retry():
                pass
            
            NumericInput(
                title=title,
                callback=InputCallback(set_value, None),
                on_failure=retry
            ).render()
            
            if result is not None:
                return result
            elif default is not None:
                return default

    @staticmethod
    def input_float_optional(
        title: str,
        default: Optional[float] = None,
        validator: Optional[Callable[[float], bool]] = None,
        error_msg: str = "[!] Неверный ввод. Попробуйте еще раз.\n"
    ) -> Optional[float]:
        while True:
            result: Optional[int | float] = None
            
            def set_value(value: str):
                nonlocal result
                try:
                    if value == "":
                        result = None
                    elif validator and not validator(float(value)):
                        print(error_msg) 
                    else:
                        result = float(value)
                except ValueError:
                    print("[!] Ошибка преобразования. Попробуйте еще раз")
            
            def retry():
                pass
            
            NumericOrEmptyInput(
                title=title,
                callback=InputCallback(set_value, None),
                on_failure=retry
            ).render()
            
            if result is not None:
                return result
            elif default is not None:
                return default
    
    @staticmethod
    def input_pair(
        title_a: str,
        title_b: str,
        validator: Optional[
            Callable[
                [
                    Optional[int | float],
                    Optional[int | float]
                ],
                bool
            ]
        ] = None
    ) -> Optional[Tuple[float, float]]:
        while True:
            a: Optional[int | float] = None
            b: Optional[int | float] = None
            
            def set_a(value: str):
                nonlocal a
                try: a = float(value)
                except ValueError:
                    print("[!] Ошибка преобразования. Попробуйте еще раз.\n")
                    a = None
            
            def set_b(value: str):
                nonlocal b
                try:
                    b = float(value)
                    if validator and not validator(a, b):
                        print(f"[!] Неверная пара: a={a}, b={b}\n")
                        b = None
                    else:  b = b
                except ValueError:
                    print("[!] Ошибка преобразования. Попробуйте еще раз.\n")
                    b = None
            
            def retry_a(): pass
            def retry_b(): pass
            
            NumericInput(
                title=title_a,
                callback=InputCallback(set_a, None),
                on_failure=retry_a
            ).render()
            
            if a is not None:
                NumericInput(
                    title=title_b,
                    callback=InputCallback(set_b, None),
                    on_failure=retry_b
                ).render()
                
                if b is not None:
                    return (a, b)
    
    @staticmethod
    def confirm(title: str) -> bool:
        result = False
        
        def on_yes():
            nonlocal result
            result = True
        
        def on_no():
            nonlocal result
            result = False
        
        def retry():
            pass
        
        options = [
            ("Да", InputCallback(on_yes, "1")),
            ("Нет", InputCallback(on_no, "2")),
        ]
        ChoiceInput(title=title, options=options, on_failure=retry).render()
        return result
