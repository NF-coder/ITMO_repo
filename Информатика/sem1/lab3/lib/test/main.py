class Main():
    def __init__(self, tests: object, test_name: str = None) -> None:
        self.tests = tests
        self.test_name = test_name if test_name is not None else tests.name

    def run(self, func: object) -> None:
        
        def inner() -> int:
            print(
                f"\n{func.__name__} тестируется на наборе тестов {self.test_name}"
            )
            for idx, test, result, flags in self.tests:
                if func(test) == result: print(f"\t✅ Тест {idx} пройден успешно")
                else:
                    print(f"\t❌ Тест {idx} провален")

                    if flags is not None and "SPACES_MODE" in flags:
                        R, L = "<", ">"
                    else: R, L = "", ""

                    print(
                        "\t\t" + f"Ввод: {L}{test}{R}",
                        f"Ожидаемый результат: {L}{result}{R}",
                        f"Полученный результат: {L}{func(test)}{R}",
                        sep = "\n\t\t"
                    )


                    if flags is not None and "IGNORE_ERROR" in flags:
                        print("\t\tIGNORE_ERROR flag activated!")
                        continue

                    break
            else: return -1
            return idx
        
        _ = inner()
        print("✅ Ошибок не обнаружено!" if _==-1 else f"❌ Ошибка на тесте {_}!")