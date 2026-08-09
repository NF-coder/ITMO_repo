import re

class Validator():
    def __init__(self) -> None:
        self.available_systems = [
            ("Берг", "Берг"),
            ("Фиб", "Фиб"),
            (r"С+(?<![-\d])(?<!\d[.,])\d*[13579](?![.,]?\d)", "C*"),
            ("-10", "-10"),
            ("10", "10")
        ]
    
    def val_system(self, cs):
        return True if any([
            re.fullmatch(re.compile(temp[0]), cs)
            for temp in self.available_systems
        ]) else False
