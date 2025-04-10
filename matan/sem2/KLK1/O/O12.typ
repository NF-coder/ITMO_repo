#set page(width: 20cm, height: 7cm, fill: color.hsl(197.14deg, 71.43%, 90.39%), margin: 15pt)
#set align(left + top)
= О12.  Верхняя и нижняя суммы Дарбу
\
*Понятие сумм Дарбу* Пусть функция $f$ задана на отрезке [a, b] и $tau$ — некоторое разбиение этого отрезка. Величины
#let cache1 = $x in Delta_i$
$
  S_tau (f) = sum_"i=1"^n M_i Delta x_i
  space space space
  M_i = sup_cache1 f (x),
  space space space
  i in {1,2, dots, n}
  \
  s_tau (f) = sum_"i=1"^n M_i Delta x_i
  space space space
  M_i = inf_cache1 f (x),
  space space space
  i in {1,2, dots, n}
$
называют верхней и нижней суммами Дарбу для функции $f$ , отвечающими разбиению $tau$, соответственно.