from validators import Validator
from CheckHamming import CheckHamming

from math import log2

def main():
    while True:
        inp_bits = input("Введите количество бит: ")
        if not Validator.ValidateBits(inp_bits):
            print("Некорректное количество бит")
            continue

        validator = Validator(int(inp_bits))
        _ = (
            int(inp_bits),
            int(inp_bits) - int(log2(int(inp_bits)+1))
        )

        inp = input(f"Введите классический код хэмминга {str(_).replace(", ", ";")}: ")
        
        if not validator.ValidateInput(inp):
            print("Проверьте ввод!")
            continue

        result = CheckHamming(lenght=_[0]).run(inp)
        
        print()
        if result["hasError"]:
            errorIndex = result['errorIndex']
            print("Корректное сообщение:", inp[:errorIndex] + str((int(inp[errorIndex])+1)%2) + inp[errorIndex+1:])
            print("Указатель на ошибку: ", " "*errorIndex +"^" + " "*(len(inp)-errorIndex))
        else:
            print("Введённое число корректно!")
        print()

if __name__ == "__main__":
    main()