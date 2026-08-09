#set page(
  margin: 1.5cm,
  numbering: "1"
)
#set par(justify: true)
#set text(
  lang: "ru",
  size: 12pt,
  font: "New Computer Modern",
)

#show math.cases: math.display

#show link: it => underline(text(fill: dark_blue)[#it])

#include "pages/titlePage.typ"

#pagebreak()

Для подсчета числовых характеристик (выборочных средних $overline(x)$ и $overline(y)$, выборочных средних квадратичных отклонений $s_x$
и $s_y$ и выборочного корреляционного момента $s_(x y)$) составляем рассчётную таблицу. При заполнении таблицы осуществляем контроль по строкам и столбцам:
$
  sum_(i=1)^6 m_(x i) = sum_(j=1)^8 m_(y j) = n = 100\
  sum_(i=1)^6 sum_(j=1)^8 m_(i j) x_i = sum_(i=1)^6 m_(x_i) x_i = 1792\
  sum_(i=1)^6 sum_(j=1)^8 m_(i j) y_j = sum_(j=1)^8 m_(y j) y_j = 17900\ 
  sum_(i=1)^6(x_i sum_(j=1)^8  m_(i j) y_j) = sum_(j=1)^8 (y_j sum_(i=1)^6 m_(i j) x_i) = 331880
$

Вычисляем выборочные средние $overline(x)$ и $overline(y)$, $i=overline("1,6")$; $j=overline("1,8")$

$
  overline(x) = (sum sum m_(i j) x_i)/n = (sum m_(x i) x_i)/n = 1792/100 = 17.92 ;\
  overline(y) = (sum m_(y i) y_i)/n = 17900/100 = 179.
$

Выборочные дисперсии находим по формулам:

$
  s_x^2 = 1/(n-1) (sum m_(x i) x_i^2 - 1/n (sum m_(x i) x_i)^2 ) = 1/99 (33904 - 1/100 (1792)^2) approx 18.09\
  s_y^2 = 1/(n-1) (sum m_(y j) y_j^2 - 1/n (sum m_(y j) y_j)^2 ) = 1/99 (3302800 - 1/100 (17900)^2) approx 996.97
$

Корреляционный момент вычисляем по формуле:
$
  s_(x y) = 1/(n-1)(sum sum m_(i j) x_i y_j - 1/n (sum m_(x i) x_i)(sum m_(y j) y_j))=\ = 1/99 (331880 - 1/100 (1792 dot 17900)) approx 112.24
$

Оценкой теоретической линии регрессии является эмпирическая линия регрессии, уравнение которой имеет вид

$
  y = overline(y) + r_(x y) s_y/s_x (x - overline(x)) space "где"\
  s_x = sqrt(18.09) approx 4.25 quad quad quad
  s_y = sqrt(996.97) approx 31.57\
  r_(x y) = s_(x y) / (s_x s_y) = 112.24/(4.25 dot 31.57) approx 0.84
$

Составляем уравнение эмпирической линии регрессии $y$ на $x$
$
  y = 179 + 0.84 dot 31.57/4.25 (x - 17.92) approx 6.24 dot x + 179 - 111.82 = 6.24 dot x + 67.18
$

#pagebreak()

#include "pages/table.typ"

#pagebreak()

Строим линию регрессии и случайные точки $(x_i; y_j)$

#align(center)[
  #include "pages/plot.typ"
]