from .utils.utils import Utils

class Convert_berg:
    def __init__(self) -> None: 
        sqrt_5 = 5**0.5
        self.phi = (1 + sqrt_5)/2 # иррациональные числа - нелюбим, неумеем, непрактикуем 

    def convert_to(self, num: str, treshold_pow: int = -8):
        result = ""
        num = int(num)

        power = num**(1/self.phi)//1 + 1 # округление вверх
        treshold_num = self.phi**treshold_pow # порог по точности

        while power >= treshold_pow:
            if power == -1: result += "." 

            phi_pow = self.phi**power

            if num - phi_pow >= -treshold_num and abs(num-phi_pow) < abs(num): # жалкая попытка максимально приблизить число к требуему 
                num -= phi_pow
                result += "1"
            else: result += "0"
            
            power -= 1

        print(f"ВНИМАНИЕ! Погрешность перевода {abs(num)}") # погрешность перевода может быть велика... 
        
        return int(result) if float(result)%1 == 0 else float(result) # убираем лишние нули

    def convert_from(self, num: str) -> str:
        result = 0
        part1, part2 = Utils.split_to_parts(num)

        for idx,item in enumerate(part1[::-1]):
            result += self.phi**idx*int(item)
        for idx,item in enumerate(part2):
            result += self.phi**(-idx-1)*int(item)
        
        return result

