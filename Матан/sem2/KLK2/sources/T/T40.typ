#set page(width: 20cm, height: auto, fill: color.hsl(253.71deg, 71.43%, 90.39%), margin: 15pt)
#set align(left + top)
= +T40\*. Достаточное условие сходимости ряда Фурье

Пусть $f$ - $2pi$-периодическая на $RR$ функция, причем $|f| in R[-pi, pi]$. Если функция $f$ удовлетворяет в точке $x in RR$ условиям Дини, то  

$ sum_(k=-infinity)^infinity c_k(f) e^(i k x) = (f(x+0) + f(x-0))/2 $

*Доказательство.* Так как (лемма 92)

$ T_n (x) = 1/(2pi) integral_0^pi (f(x-t) + f(x+t)) D_n (t) d t $

и так как (лемма 90)

$ integral_0^pi D_n (t) d t = pi $

то

$ T_n (x) - (f(x+0) + f(x-0))/2 = $

$ = 1/(2pi) integral_0^pi (f(x-t) + f(x+t)) D_n (t) d t - 1/(2pi) integral_0^pi (f(x+0) + f(x-0)) D_n (t) d t = $

$ = 1/(2pi) integral_0^pi (f(x-t)-f(x-0)+f(x+t)-f(x+0))/(sin t/2) sin(n + 1/2) t d t $

Так как $sin t/2 ~ t/2$ при $t -> 0+$, то, согласно условиям Дини, интегралы

$ integral_0^pi abs( (f(x-t)-f(x-0))/(sin t/2) ) d t " и " integral_0^pi abs( (f(x+t)-f(x+0))/(sin t/2) ) d t $

сходятся, а значит мы попадаем в условия леммы Римана (91). Тем самым,

$ lim_(n -> infinity) T_n (x) = (f(x+0) + f(x-0))/2 $