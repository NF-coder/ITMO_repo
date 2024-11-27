import re

class Main():
    def __init__(self, smile: str = r"\;\<\)") -> None:
        self.regex = re.compile(smile)

    def count_matches(self, inp: str) -> int:
        return len(re.findall(self.regex, inp))
    
    def findall(self, inp: str) -> list:
        return re.findall(self.regex, inp)
    
    def sub(self, inp: str) -> str:
        return re.sub(self.regex, "", inp)
