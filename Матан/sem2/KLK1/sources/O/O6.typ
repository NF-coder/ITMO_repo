// Page #O3
#set page(width: 20cm, height: 5cm, fill: color.hsl(197.14deg, 71.43%, 90.39%), margin: 15pt)
#set align(left + top)
= О6.  Мелкость (ранг, диаметр) разбиения
\
Говорят, что на отрезке [a, b] введение разбиение (дробление) $tau$, если введена система точек $x_i,i in {0, 1, dots, n}$, что:\
#set align(center)
$ a = x_0 < x_1 < x_2 < dots < x_n = b $

#let cache_1 = $i in {1,2,dots,n}$
#set align(left)
Величина $lambda (tau) = max_#cache_1 Delta x_i$ называется мелкостью (рангом, диаметром) разбиения (дробления). 