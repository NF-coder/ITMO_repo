from math import log2

class CheckHamming():
    def __init__(self, lenght: int = 7):
        self.lenght = lenght

        self.parity_bits = int(log2(lenght + 1))
        self.info_bits = lenght - self.parity_bits

        self.bin_mask = [
            "0"*(self.parity_bits - len(bin(i)[2:])) + bin(i)[2:] # добавляем 0 слева чтоб с индексацией по строкам не мучаться
            for i in range(1,lenght+1)
        ]

    def run(self, inp: str):
        parity_arr = [0 for i in range(self.parity_bits)]

        for bin_num, sym in zip(self.bin_mask, inp):
            #print("-", bin_num, sym) # DEBUG
            for bin_num_idx, bin_num_sym in enumerate(bin_num):
                #print("-----", bin_num_idx, bin_num_sym) # DEBUG
                parity_arr[bin_num_idx] += int(sym)*int(bin_num_sym)
        
        pointer = ""
        for i in parity_arr: pointer += str(i%2)

        return {
            "hasError": pointer.count("1") != 0,
            "errorIndex": int(pointer, 2) - 1
        }
