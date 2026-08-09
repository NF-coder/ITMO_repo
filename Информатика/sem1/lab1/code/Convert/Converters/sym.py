import re

class Convert_sym:
    
    def __init__(self, osn: str) -> None:
        self.osn_num = int(osn[1:])
        self.parse_pattern = r"[\^]\d|(?<!\^)\d|^\d" # regex "цифра перед которой ^ или цифра перед которой нет ^ или цифра в начале строки"
        self.calc_overfill = lambda num, m_num: num-2*m_num-1

    def parse(self, num: str):
        return [
            int(i.replace("^", "-").replace("}", "")) # заменяем ^, оставляемые re на - и удаляем } (в текущей версии regex их быть не должно, но на случай косяка)
            for i in re.findall(self.parse_pattern, num)
        ]

    def convert_from(self, num: str):
        # очев, тут без объяснений
        result = 0
        for idx, sym in enumerate(self.parse(num)[::-1]):
            result += sym*self.osn_num**idx
        return result

    def convert_to(self, num: str) -> str: # TODO: заняться декомпозицией
        result = ""
        sign = abs(int(num))//int(num) # узнаём знак числа
        num = abs(int(num)) # берём модуль числа

        # перегоняем в НЕ симметрическую СС с этим же основанием
        cache = ""
        while num != 0:
            cache += str(num%self.osn_num)
            num //= self.osn_num
        cache = cache[::-1]
        
        cache_symblos = [int(i) for i in cache] # разбиваем результат конвертации поразрядно
        m_num = self.osn_num//2 # узнаём максимальную цифру в разряде симметрической СС

        arr = []
        for elem in cache_symblos:
            if len(arr) == 0: # если рассматриваемый разряд - первый
                if elem > m_num: arr = [1, self.calc_overfill(elem, m_num)] # если разряд более, чем макс. возможная цифра
                else: arr = [elem]
                continue # попахивает антипаттреном... но пусть будет
            if elem > m_num: # если разряд более, чем макс. возможная цифра

                # превышение макс цифры
                arr[-1] += 1
                for idx in range(-1,-len(arr), -1): # рассматриваем все разряды числа, кроме старшего
                    if arr[idx] > m_num: # если разряд переполнен
                        arr[idx] = self.calc_overfill(arr[idx], m_num) # рассчёт новой цифры разряда
                        arr[idx-1] += 1 # увеличение следующего разряда
                    else: break # вываливаемся если всё ок
                if arr[0] > m_num: # рассматриваем старший разряд числа
                    arr = [1, self.calc_overfill(arr[0], m_num)] + arr[1:]

                #arr[-1] += 1 # прибавляем к предыдущему 1. TODO: пофиксить возможность превышения макс. возмож. цифры (DONE)
                
                arr.append(self.calc_overfill(elem, m_num))
            else: # если разряд не более, чем макс. возможная цифра
                arr.append(elem)  

        arr = [i*sign for i in arr] # коррекция на знак

        # конвертим в нужный формат
        for i in arr:
            if i < 0: result += "{^"+str(-i)+"}"
            else: result += str(i)

        # time complexity: min: O(3n) max: ~O(2n+n^2). Много!
        return result