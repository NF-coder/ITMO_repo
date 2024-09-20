class Convert_fib:
    
    def __init__(self) -> None:
        sqrt_5 = 5**0.5
        phi = (1 + sqrt_5)/2
        self.calc_n_fib = lambda n: round(
            (phi ** (n + 2) - (-phi) ** (-1*(n + 2))) / sqrt_5
        )
        # Форммула Бине с округлением (почти) по правилам математики
        # и поправкой на +2 члена (коррекция для СС + учёт нумерации в циклах)

    @staticmethod
    def create_fib_array(max_num: int) -> list:
        '''
            Функция для создания массива чисел Фибоначчи не превосходящих данного
        '''
        result = [1]
        while max_num > result[-1]:

            # 2-ой элемент массива добавляется этим ветвлением (чтоб корректно обработать max_num = 1)
            if result == [1]: 
                result.append(2)
                continue
            result.append(result[-1]+result[-2])
        return result

    def convert_to(self, num: str) -> str:
        '''
            Конвертация десятичного числа в Фиббоначевую СС
        '''
        num = int(num)
        result = ""
        for elem in self.create_fib_array(num)[::-1]:

            # проверяем, подходит ли число + исклчение подряд идущих 1
            if num - elem >= 0 and (result == "" or result[-1] != "1"): 
                num -= elem
                result += "1"
            else: result += "0"
        return int(result) # убираем лишние нули

    def convert_from(self, num: str) -> str:
        '''
            Конвертация из Фиббоначевой СС в десятичную
        '''
        result = 0
        for num_idx, num_sym in enumerate(num[::-1]):
            result += int(num_sym) * self.calc_n_fib(num_idx)
        return result