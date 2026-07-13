def parse_float(value: str, field_name: str) -> float:
    try:
        return float(value.replace(",", "."))
    except ValueError as exc:
        raise ValueError(f"{field_name}: ожидалось число, получено {value!r}") from exc


def parse_method(value: str, methods: list[str]) -> int:
    try:
        method = int(value)
    except ValueError as exc:
        raise ValueError(f"method: ожидался номер метода 1..{len(methods)}") from exc

    if not 1 <= method <= len(methods):
        raise ValueError(f"method: номер должен быть от 1 до {len(methods)}")

    return method - 1


def parse_number(value: str, field_name: str, upper_bound: int) -> int:
    try:
        number = int(value)
    except ValueError as exc:
        raise ValueError(f"{field_name}: ожидался номер 1..{upper_bound}") from exc

    if not 1 <= number <= upper_bound:
        raise ValueError(f"{field_name}: номер должен быть от 1 до {upper_bound}")

    return number - 1


def parse_bool(value: str, field_name: str) -> bool:
    normalized = value.strip().lower()
    if normalized in ("1", "true", "yes", "y", "да", "д"):
        return True
    if normalized in ("0", "false", "no", "n", "нет", "н"):
        return False

    raise ValueError(f"{field_name}: ожидалось yes/no или true/false")