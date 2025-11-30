* Задание №1 * \

Найти и построить область определения сложной функции:
$
  z = arcsin(x^2/y)
$
_Вспомним область определения для функции $arcsin(t)$:_
$
   t in [-1;1]
$
_Тогда область определения нашей сложной функции:_
$
  -1 <= x^2/y <= 1 <==>
  cases(
    y != 0,
    cases(
      delim: "[",
      y > 0 ":" space cases(
        y >= x^2,
        y >= -x^2
      ),
      y < 0 ":" space cases(
        y<=x^2,
        y <= -x^2
      ),
    )
  ) <==>
  cases(
    y != 0,
    cases(
      delim: "[",
      y >= x^2  quad &y > 0,
      y <= -x^2 quad &y < 0
    )
  )
$
_Построим её график:_
#align(center)[
  #include "plot.typ"
]


_Ответ:_
$cases(
    y != 0,
    cases(
      delim: "[",
      y >= x^2  quad &y > 0,
      y <= -x^2 quad &y < 0
    )
  )
$