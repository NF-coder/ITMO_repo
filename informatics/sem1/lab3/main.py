from lib import regex, test
from db import DB

def main() -> None:
    # Task 1
    Regex1 = regex(r"\;\<\)")
    @test(DB.Task1).run
    def count_smiles(inp):
        return Regex1.count_matches(inp)
    
    def count_smiles1(inp):
        return Regex1.count_matches(inp)

    # Task 2
    Regex2 = regex(r"\b(\w+)\s+(?=\1(\b))")
    @test(DB.Task2).run
    def del_repeats(inp):
        return Regex2.sub(inp)
    
    def del_repeats1(inp):
        return Regex2.sub(inp)

    # Task 3 - только русский!
    Regex3 = regex(r"(?i)\b([^оуэыияеёю ]+|[^ауэыияеёю ]+|[^аоэыияеёю ]+|[^аоуыияеёю ]+|[^аоуэияеёю ]+|[^аоуэыяеёю ]+|[^аоуэыиеёю ]+|[^аоуэыияёю ]+|[^аоуэыияею ]+|[^аоуэыияеё ]+)\b")
    Regex4 = regex(r"(?i)\b[^оуэыияеёюа ]+\b")
    @test(DB.Task3).run
    def vowel_find(inp):
        words = list(set(Regex3.findall(inp)) - set(Regex4.findall(inp)))
        return "\n".join(
                    sorted(
                        words,
                        key=lambda x: (len(x), x.lower())
                    )
                )
    
    def vowel_find1(inp):
        words = list(set(Regex3.findall(inp)) - set(Regex4.findall(inp)))
        return "\n".join(
                    sorted(
                        words,
                        key=lambda x: (len(x), x.lower())
                    )
                )

    print()
    
    print("MANUAL TEST MODE")
    regex_array = [count_smiles1, del_repeats1, vowel_find1]
    while True:
        _ = input("Введите номер регулярки: ")
        inp = input("Введите текст: ")
        
        if _ == "1": print(regex_array[int(_)-1](inp))
        elif _ == "2": print(regex_array[int(_)-1](inp))
        elif _ == "3": print(regex_array[int(_)-1](inp))
        else: print("Нет такой регулярки")

if __name__ == "__main__":
    main()