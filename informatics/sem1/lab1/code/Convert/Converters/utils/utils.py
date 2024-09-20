class Utils:
    @staticmethod
    def __init__(self) -> None: pass

    def split_to_parts(num: str) -> list:
        if num.count(",") == 1: part1, part2 = num.split(",")
        elif num.count(".") == 1: part1, part2 = num.split(".")
        else: part1, part2 = num, ""
        
        return part1, part2
    
    def div(num: int, devisor: int) -> int:
        sign = devisor//abs(devisor) # узнаём знак числа
        return int(sign*(num//(devisor*sign))) # коррекция, чтоб остаток был >=0