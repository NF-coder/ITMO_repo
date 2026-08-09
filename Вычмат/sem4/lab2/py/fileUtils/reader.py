import re
from pathlib import Path

def read_input_file(path: str) -> tuple[dict[str, str], list[str]]:
    params: dict[str, str] = {}
    values: list[str] = []

    for line in Path(path).expanduser().read_text(encoding="utf-8-sig").splitlines():
        line = line.partition("#")[0].strip()
        if not line:
            continue

        if "=" in line:
            matches = re.finditer(
                r"([A-Za-zА-Яа-я0-9_]+)\s*=\s*([^;]+?)(?=(?:[,;]?\s*[A-Za-zА-Яа-я0-9_]+\s*=)|$)",
                line
            )
            for match in matches:
                key = match.group(1).strip().lower()
                value = match.group(2).strip().rstrip(",;")
                params[key] = value
        else:
            values.extend(line.replace(",", ".").split())

    return params, values


