from Validators import CountSystemValidator
from Convert import Converter

from traceback import format_exc as exc

# класс с пользовательским инерфейсом
class Main():
    @staticmethod
    def __init__(self) -> None: pass

    def run():
        validator = CountSystemValidator() # инициализация класса валидатора сс
        # TODO: валидация чисел в зависимости от сс

        print("Программа по переводу чисел в различные СС\nДля завершения работы нажмите Ctrl+C")
        print(
            "Поддерживаемые СС:",
            " ".join([i[1] for i in validator.available_systems])
        )

        while True:
            cs_from = input("Введите систему счисления исходного числа: ")
            num = input("Введите исходное число: ")
            cs_target = input("Введите систему счисления желаемого числа: ")

            val_cs_from, val_cs_target = validator.val_system(cs_from), validator.val_system(cs_target) # вызовы методов для валидации

            if not( val_cs_target and val_cs_from): raise Exception("Одна из систем счисления не поддерживается!")
            
            try:
                print(
                    Converter.convert(cs_from, cs_target, num)
                )
            except Exception as e: # заглушка (не ловит 10 -> 10)
                raise Exception("При конвертации что-то  пошло не так. Проверьте правильность введённых чисел")

            

if __name__ == "__main__":
    Main.run()