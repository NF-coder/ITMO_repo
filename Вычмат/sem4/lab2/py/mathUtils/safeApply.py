from typing_extensions import Optional, Callable

def safe_apply[V](func: Callable[..., V], *args: ...) -> Optional[V]:
    try:
        return func(*args)
    except (ValueError, ZeroDivisionError, OverflowError):
        return None