class SortedSires:
    def __init__(self, data: list[float]) -> None:
        self._sorted_data = sorted(data)

    def get_max(self) -> float:
        return self._sorted_data[-1]
    
    def get_min(self) -> float:
        return self._sorted_data[0]
    
    def __len__(self) -> int:
        return len(self._sorted_data)

    def __getitem__(self, key: int) -> float:
        return self._sorted_data[key]

    def __iter__(self):
        return iter(self._sorted_data)
    
    def __repr__(self) -> str:
        return "Вариационный ряд\n" +\
        f"   Всего эдементов: {len(self._sorted_data)}\n" +\
        "   Первые 5 элементов: " + ", ".join(map(str, self._sorted_data[:5])) + "\n" +\
        "   Последние 5 элементов: " + ", ".join(map(str,  self._sorted_data[-5:][::-1]))