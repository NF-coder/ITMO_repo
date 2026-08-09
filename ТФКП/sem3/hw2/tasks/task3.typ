= Задание 3

Решите ОДУ с начальными условиями:
$
  accent(y, dot.double)(t) - 2 accent(y, dot)(t) + y(t) = e^t , quad y(0) = 0, quad accent(y, dot)(0) = 0
$

== Решение

Преобразование левой части

$
  Im(accent(y, dot)(t)) = s Y(s) - y(0) quad
  Im(accent(y, dot.double)(t)) = s^2 Y(s) - s y(0) - accent(y, dot)(0)
$

С учётом начальных условий $y(0) = 0$, $accent(y, dot)(0) = 0$, получаем:

$
  Im(accent(y, dot.double)(t)) = s^2 Y(s)
  quad Im(-2 accent(y, dot)(t)) = -2 s Y(s)
  quad Im(y(t)) = Y(s)
$
$
  Im(y(t)) = (s^2 - 2 s + 1) Y(s)
$

Преобразование правой части

$
  Im(e^t) = 1 / (s - 1)
$

Получаем уравнение:

$
  (s^2 - 2 s + 1) Y(s) = 1 / (s - 1)\
  (s - 1)^2 Y(s) = 1 / (s - 1)\
  Y(s) = 1 / (s - 1)^3
$

Найдём оригинал:

$
  Im(t^2 e^(a t)) = 2 / (s - a)^3 space => space Im(t^2 e^t) = 2 / (s - 1)^3\
$

$
  Y(s) = 1 / (s - 1)^3 = (1 / 2) Im(t^2 e^t)\
  y(t) = t^2 e^t / 2
$

Ответ: $y(t) = (t^2 e^t)/ 2 $