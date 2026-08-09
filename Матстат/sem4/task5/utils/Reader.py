class Reader:
    def __init__(self, filename: str) -> None:
        self._filename = filename
    
    def read_column(self, column_idx: int, sep: str = ",") -> list[float]:
        with open(self._filename, "r", encoding="utf-8-sig") as f:
            data = [float(line.split(sep)[column_idx]) for line in f.read().split("\n")[1:]]
        return data