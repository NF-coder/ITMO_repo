from .Converters import fib, neg, sym, berg

class Main():
    def __init__(self) -> None:
        pass

    def convert(from_cs: str, to_cs: str, num: str) -> int:

        converter = None

        if from_cs == "Фиб": converter = fib.Convert_fib()
        elif from_cs == "-10":converter = neg.Convert_neg()
        elif from_cs[0] == "С": converter = sym.Convert_sym(from_cs)
        elif from_cs == "Берг": converter = berg.Convert_berg()

        result = num if from_cs == "10" else converter.convert_from(num = num)
        
        if to_cs == "Фиб": converter = fib.Convert_fib()
        elif to_cs == "-10": converter = neg.Convert_neg()
        elif to_cs[0] == "С": converter = sym.Convert_sym(to_cs)
        elif to_cs == "Берг": converter = berg.Convert_berg()

        result = result if to_cs == "10" else converter.convert_to(num = result)

        return result