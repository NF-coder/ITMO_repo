from .utils.utils import Utils

class Convert_neg:
    
    def __init__(self) -> None:
        pass

    def convert_from(self, num: str):
        # тут всё просто, как-нибудь без описания
        result = 0
        for idx, sym in enumerate(num[::-1]):
            result += int(sym)*((-10)**(idx)) 

        return result
    
    def convert_to(self, num: str):
        # и тут всё просто, как-нибудь без описания

        result = ""
        num = int(num)

        while num != 0:
            result += str(num - num//10*10)
            num = Utils.div(num, -10)

        return int(result[::-1]) # удаляем лишние знаки

        
    