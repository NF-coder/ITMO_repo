import re
from math import log2

class Validator():

    def __init__(self, lenght: int = 7):
        self.inp_pattern = re.compile("[0-1]+")
        self.lenght = lenght

    def ValidateInput(self, inp: str):
        return len(inp) == self.lenght and bool(re.fullmatch(self.inp_pattern, inp))
    
    @staticmethod
    def ValidateBits(inp: str):
        return log2(int(inp)+1)%1 == 0