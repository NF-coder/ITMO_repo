#set page(width: 20cm, height: auto, fill: color.hsl(288.46deg, 100%, 89.8%), margin: 15pt)
#set align(left + top)
= Л10\*. Лемма к достаточному условию сходимости ряда Фурье
Пусть функция $ f$ является $2pi $-периодической на $RR $. Тогда  

$ T_n(x) = 1/(2pi) integral_0^pi (f(x-t) + f(x+t)) D_n(t) d t $

*Доказательство.* Вспомним, что  

$ T_n(x) = 1/(2pi) integral_(-pi)^pi f(t) D_n (x-t) d t $

Сделаем замену переменной $ p = x - t$ и учтем, что, согласно условию и свойствам ядра Дирихле (90), подынтегральная функция является $2pi $-периодической. Тогда  

$ T_n(x) = 1/(2pi) integral_(-pi)^(+pi) f(x-p) D_n (p) d p = 1/(2pi) integral_(-pi)^pi f(x-p) D_n (p) d p $

Так как ядро Дирихле является четным (лемма 90), то

$ T_n(x) = 1/(2pi) integral_0^pi (f(x-p) + f(x+p)) D_n (p) d p $

что и доказывает лемму.