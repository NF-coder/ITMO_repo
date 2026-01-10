* Задание №1 * \

Плоская область $D$ ограничена заданными линиями
$
  y = sqrt(4-x) quad x+y=-2 quad x = sqrt(2y) - 2
$
1. Сделайте схематический рисунок области $D$.
2. С помощью двойного интеграла найдите площадь области $D$.

Решение:

#align(center)[
  #include "plot.typ"
]

#align(center)[
  #text[
    _Разделим на 2 подобласти - $D_1 (y<=2)$ и $D_2 (y>2)$ _
  ]
]
$
  S = integral.double_D_1 d x d y + integral.double_D_2 d x d y = 
  integral_0^2 d y integral^(sqrt(2y) - 2)_(-2-y) d x
  + integral_2^3 d y integral_(-2-y)^(4-y^2) d x =\
  = integral_0^2 (sqrt(2y) - 2) - (-2-y) space d y + integral_(2)^3 (4-y^2) - (-2-y) space d y =\
  = integral_0^2 y + sqrt(2y) space d y + integral_(2)^3 6 + y - y^2 space d y =
   lr((y^2/2 + sqrt(2) dot y^1.5/1.5 )|)_(0)^(2) + lr((6y + y^2/2 - y^3/3)|)_(2)^(3) =\
  = (2+4/1.5) + (18 + 9/2 - 27/3 - 12 - 2 + 8/3) = 2 + 8/3 + 18 + 9/2 - 9 - 14 + 8/3 =\
  = -3 + 16/3 + 9/2 = (-18 + 32 + 27)/6 = 41/6
$

Ответ: $41/6$