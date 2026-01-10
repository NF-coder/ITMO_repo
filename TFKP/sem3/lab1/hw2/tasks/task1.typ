= Задание 1

Найти изображение Лапласа функции  
$
  f(t) = 4 t^2 sin(t) + 3 e^t - 1
$

== Решение

Используем свойство линейности преобразования Лапласа:
$
  Im(4 t^2 sin(t) + 3 e^t - 1) = 4 Im(t^2 sin(t)) + 3 Im(e^t) - Im(1)
$

$
  Im(1) = 1 / s quad
  Im(e^t) = 1 / (s - 1)
$

Для нахождения $Im(t^2 sin(t))$ используем свойство дифференцирования оригинала:
$
  "Пусть" g(t) = t^2 sin(t) ", тогда"\
  accent(g, dot)(t) = 2 t sin(t) + t^2 cos(t) quad
  accent(g, dot.double)(t) = 2 sin(t) + 4 t cos(t) - t^2 sin(t)\
  accent(g, dot.double)(t) + g(t) = 2 sin(t) + 4 t cos(t)
$
#align(center)[
  #table(
    columns: (1fr, 1fr),
    inset: 0pt,
    stroke: none,
    [
      $
        "Преобразование левой части"\
        Im(accent(g, dot.double)(t)) = s^2 G(s) - s g(0) - accent(g, dot)(0)\
        g(0) = 0, quad accent(g, dot)(0) = 0\
        Im(accent(g, dot.double)(t)) = s^2 G(s)\
        Im(accent(g, dot.double)(t) + g(t)) = (s^2 + 1) G(s)\
      $
    ],
    [
      $
        "Преобразование правой части"\
        Im(sin(t)) = 1 / (s^2 + 1) quad Im(cos(t)) = s / (s^2 + 1)\
        Im(t cos(t)) = -partial (Im(cos(t)), s) = \
        =- partial (s / (s^2 + 1), s) = (s^2 - 1) / (s^2 + 1)^2\
        Im(2 sin(t) + 4 t cos(t)) = 2 / (s^2 + 1) + 4 (s^2 - 1) / (s^2 + 1)^2 =\
        = (6 s^2 - 2) / (s^2 + 1)^2
      $
    ]
  )
]
$
  G(s) = (6 s^2 - 2) / (s^2 + 1)^3 quad => quad
  Im(t^2 sin(t)) = (6 s^2 - 2) / (s^2 + 1)^3
$

Итоговое изображение Лапласа
$
  Im(f(t)) = 4 dot (6 s^2 - 2) / (s^2 + 1)^3 + 3 / (s - 1) - 1 / s
$