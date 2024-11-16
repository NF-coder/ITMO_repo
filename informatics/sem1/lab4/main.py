# 25
# XML -> JSON Среда, пятница

from converters import *
import time

def main(converter: object, inpFile: str = "./timetable.xml", outFile: str = "out.json") -> None:
    with open(inpFile, "r", encoding="utf-8-sig") as f:
        data = f.read()
    out = converter(data)
    with open(outFile, "w+", encoding="utf-8-sig") as f:
        f.write(out)

def x100_time(converter: object, inpFile: str = "./timetable.xml") -> float:
    with open(inpFile, "r", encoding="utf-8-sig") as f:
        data = f.read()

    start = time.time_ns()
    converter(data)

    return (time.time_ns() - start)*100

if __name__ == "__main__":
    
    main(С1(True).main, outFile = "out1.json") # ОЗ, ДЗ-3
    main(С2(True).main, outFile = "out2.json") # ДЗ-2
    main(C3().main, outFile = "out3.json") # ДЗ-1

    for i in [С1(True).main, С2(True).main, C3().main]:
        print(i.__code__.co_filename, f"{x100_time(i)/10**9:.6f}c ({x100_time(i)}нс)")
    
    main(C4().main, outFile = "out4.proto")
