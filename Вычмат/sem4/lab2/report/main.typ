#set text(
  lang: "ru",
  size: 12pt,
  font: "New Computer Modern",
)
#set page(
  margin: 1.5cm,
  numbering: ("1")
)
#set par(justify: true)
#show raw: it => block(
  fill: luma(95%),
  inset: 8pt,
  radius: 4pt,
)[
  #set text(size: 6pt)
  #it
]
#show heading: set text(size: 14pt)
#set heading(numbering: "1.",)

#align(center)[
  #text(size:12pt)[
    Федеральное государственное автономное образовательное учреждение высшего
    образования «Национальный исследовательский университет ИТМО»\
    Дисциплина «Вычислительлная математика»\
  ]
]

#align(center + horizon)[
  #box(
    width: 100%,
    height: 8cm
  )[
    #text(size: 14pt)[
      *Лабораторная работа №2*\
      "Численное решение нелинейных уравнений и систем"\
      Вариант №11
    ]
  ]
]
#align(right)[  
  Выполнил:\  
  Студент группы P3208\
  Решетников С.Е.\ 

  Преподаватели:\
  Рыбаков С.Д.
]

#align(center + bottom)[
  Дата сдачи: 21 марта 
  
  Cанкт-Петербург, 2026
]

#pagebreak()

= Цель работы
Изучить численные методы решения нелинейных уравнений и их систем, найти корни заданного нелинейного уравнения/системы нелинейных уравнений, выполнить программную реализацию методов.

= Вычислительная реализация задачи
== Решение нелинейного уравнения
Уравнение
$
  y = 4.45 dot x^3 + 7.81 dot x^2 - 9.62 dot x - 8.17 
$

График уравнения
#image("assets/image.png")

Интервалы изоляции корней
#table(
  align: center + horizon,
  columns: (auto, 1fr, 1fr),
  [№], [Начало], [Конец],
  [1], [-2.5],   [-2],
  [2], [-1],     [-0.5],
  [3], [1],      [1.5]
)

=== Нахождение левого корня методом половинного деленяи
$
  a = -2.5 quad b = -2 quad epsilon = 0.01
$
#table(
  align: center + horizon,
  columns: (auto, 1fr, 1fr, 1fr, 1fr, 1fr, 1fr, 1fr),
  [№], [a],     [b],     [x],     [f(a)],  [f(b)], [f(x)],  [$abs(a-b)$],
  [1], [-2.5],  [-2],    [-2.25], [-4.84], [6.71], [2.32],  [0.5],
  [2], [-2.5],  [-2.25], [-2.38], [-2.25], [2.32], [-0.88], [0.25],
  [3], [-2.38], [-2.25], [-2.32], [-0.88], [2.32], [0.74],  [0.13],
  [4], [-2.38], [-2.32], [-2.35], [-0.88], [0.74], [-0.18], [0.07]
)
Результат: $x=-2.35 quad f(x)=-0.18$

=== Нахождение центрального корня методом простой итерации
$
  a = -1 quad b = -0.5\
  max(f') in [-1; -0.5] quad
  max(f') approx -11.89 quad
  lambda = 1/abs(max(f')) approx 0.09\

  phi(x) = x + 0.09 dot f(x)
$
#table(
  align: center + horizon,
  columns: (auto, 1fr, 1fr, 1fr, 1fr),
  [№], [$x_k$],  [$x_(k+1)$], [$f(x_(k+1))$], [$abs(x_k - x_(k+1))$],
  [1], [-1],     [-0.567],    [-1.016],       [0.433],
  [2], [-0.567], [-0.658],    [0.274],        [0.091],
  [3], [-0.658], [-0.633],    [-0.080],       [0.025],
  [4], [-0.633], [-0.640],    [0.019],        [0.007]
)
Результат: $x=-0.640 quad f(x)=0.019$

=== Нахождение правого корня методом секущих
$
  a = 1 quad b = 1.5\
  x_(k+1) = x_k - (x_k - x_(k-1))/(f(x_k) - f(x_(k-1))) dot f(x_k)\
  x_(0): f(x_0) dot f''(x_0) > 0 quad => quad
  x_0 = 1.5, space x_1 = 1.51
$
#table(
  align: center + horizon,
  columns: (auto, 1fr, 1fr, 1fr, 1fr, 1fr),
  [№], [$x_(k-1)$], [$x_k$], [$x_(k+1)$], [$f(x_(k+1))$], [$abs(x_k - x_(k+1))$],
  [1], [1.500],     [1.510], [1.274],     [1.452],        [0.236],
  [2], [1.51],      [1.274], [1.236],     [0.274],        [0.038],
  [3], [1.274],     [1.236], [1.227],     [0.004],        [0.009]
 )
Результат: $x=1.227 quad f(x)=0.009$

== Решение системы нелинейных уравнений методом Ньютона
Система
$
  cases(
    tg(x dot y + 0.2) = x^2,
    x^2 + 2y^2 = 1
  )
$
График системы
#image("assets/image-1.png")

Интервалы изоляции корней
#table(
align: center + horizon,
  columns: (auto, 1fr, 1fr),
  [№], [x], [y],
  [1], [[-0.7; -0.8]],  [[-0.4; -0.6]],
  [2], [[-0.3; -0.2]],  [[0.6; 0.8]],
  [3], [[0.7; 0.8]],    [[0.4; 0.6]],
  [4], [[0.3; 0.2]],    [[-0.6; -0.8]]
)

$
  mat(
    delim: "|",
    1/(cos^2(x dot y + 0.2)) dot y - 2x, quad 1/(cos^2(x dot y + 0.2)) dot x;
    2x, 4y 
  ) dot mat(Delta x; Delta y) = mat(
    x^2- tg(x dot y + 0.2);
    1 - x^2 - 2y^2
  ) <=>\
  <=> cases(
    (1/(cos^2(x dot y + 0.2)) dot y - 2x) dot Delta x +
    quad 1/(cos^2(x dot y + 0.2)) dot x dot Delta y = x^2 - tg(x dot y + 0.2),
    2x dot Delta x + 4y dot Delta y = 1 - x^2 - 2y^2,
  )
$

*Корень 1 $(x < 0, y < 0)$*\
Шаг 1
$
  x_0 = -0.8,quad y_0 = -0.4\

  cases(
    1.068 dot Delta x - 1.064 dot Delta y = 0.067,
    -1.6 dot Delta x -1.6 dot Delta y = 0.04,
  ) => cases(
    Delta x approx 0.019,
    Delta y approx -0.044
  )\

  x_1 = -0.781,quad y_1 = -0.444
$

Шаг 2
$
  cases(
    1.15 dot Delta x - 1.03 dot Delta y = 0.004,
    -1.56 dot Delta x -1.78 dot Delta y = -0.004,
  ) => cases(
    Delta x approx 0.006,
    Delta y approx -0.010
  )\

  x_2 = -0.775,quad y_2 = -0.454
$

Шаг 3
$
  cases(
    1.14 dot Delta x - 1.02 dot Delta y = 0.001,
    -1.55 dot Delta x -1.82 dot Delta y = -0.001,
  ) => cases(
    Delta x approx 0.002,
    Delta y approx -0.003
  )\

  x_3 = -0.773,quad y_3 = -0.457
$

Результат:
$
  x = -0.773,quad y = -0.457
$

*Корень 2 $(x < 0, y > 0)$*\

Шаг 1
$
  cases(
    1.103 dot Delta x - 0.201 dot Delta y = -0.020,
    -0.4 dot Delta x + 2.8 dot Delta y = -0.02,
  ) => cases(
    Delta x approx -0.015,
    Delta y approx -0.010
  )\

  x_1 = -0.215,quad y_1 = 0.690
$

Шаг 2
$
  cases(
    1.09 dot Delta x - 0.21 dot Delta y = -0.006,
    -0.43 dot Delta x + 2.76 dot Delta y = -0.001,
  ) => cases(
    Delta x approx -0.006,
    Delta y approx -0.004
  )\

  x_2 = -0.221,quad y_2 = 0.686
$

Шаг 3
$
  cases(
    1.08 dot Delta x - 0.22 dot Delta y = 0.000,
    -0.44 dot Delta x + 2.74 dot Delta y = 0.000,
  ) => cases(
    Delta x approx 0.000,
    Delta y approx 0.000
  )\

  x_3 = -0.221,quad y_3 = 0.686
$

Результат:
$
  x = -0.221,quad y = 0.686
$

*Корень 3 $(x > 0, y > 0)$*

Шаг 1
$
x_0 = 0.8, quad y_0 = 0.4\

  cases(
    -1.068 dot Delta x + 1.064 dot Delta y = 0.067,
    1.6 dot Delta x + 1.6 dot Delta y = 0.04,
  ) => cases(
    Delta x approx -0.019,
    Delta y approx 0.044
  )\

  x_1 = 0.781, quad y_1 = 0.444
$

Шаг 2
$
  cases(
    -1.15 dot Delta x + 1.03 dot Delta y = 0.004,
    1.56 dot Delta x + 1.78 dot Delta y = -0.004,
  ) => cases(
    Delta x approx -0.006,
    Delta y approx 0.010
  )\

  x_2 = 0.775, quad y_2 = 0.454
$

Шаг 3
$
  cases(
    -1.14 dot Delta x + 1.02 dot Delta y = 0.001,
    1.55 dot Delta x + 1.82 dot Delta y = -0.001,
  ) => cases(
    Delta x approx -0.002,
    Delta y approx 0.003
  )\

  x_3 = 0.773, quad y_3 = 0.457
$

Результат:
$
  x = 0.773, quad y = 0.457
$

*Корень 4 $(x > 0, y < 0)$*

Шаг 1
$
x_0 = 0.2, quad y_0 = -0.7\

  cases(
    -1.103 dot Delta x + 0.201 dot Delta y = -0.020,
    0.4 dot Delta x - 2.8 dot Delta y = -0.02,
  ) => cases(
    Delta x approx 0.015,
    Delta y approx 0.010
  )\

  x_1 = 0.215, quad y_1 = -0.690
$

Шаг 2
$
  cases(
    -1.09 dot Delta x + 0.21 dot Delta y = -0.006,
    0.43 dot Delta x - 2.76 dot Delta y = -0.001,
  ) => cases(
    Delta x approx 0.006,
    Delta y approx 0.004
  )\

  x_2 = 0.221, quad y_2 = -0.686
$

Шаг 3
$
  cases(
    -1.08 dot Delta x + 0.22 dot Delta y = 0.000,
    0.44 dot Delta x - 2.74 dot Delta y = 0.000,
  ) => cases(
    Delta x approx 0.000,
    Delta y approx 0.000
  )\

  x_3 = 0.221, quad y_3 = -0.686
$

Результат:
$
  x = 0.221, quad y = -0.686
$

= Программная реализация задачи
== Листинг
Частичный листинг кода
#raw(lang: "py", read("../py/methods/impl/chord.py"))
#raw(lang: "py", read("../py/methods/impl/simple_iter.py"))
#raw(lang: "py", read("../py/methods/impl/newton.py"))
#raw(lang: "py", read("../py/methods/impl/newton_system.py"))

== Образцы работы
=== Уравнение
input-files/eq.txt
```
task=equation
function=1
a=-3
b=-2
method=2
eps=0.01
output=file
output_file=/tmp/result.txt
plot=no
```
Результат:
```
Функция: f1(x) = 4.45*x^3 + 7.81*x^2 - 9.62*x - 8.17
Интервал: [-3.0, -2.0]
Метод: Метод Ньютона
Точность: 0.01

[*] Корней на [-3.0, -2.0]: ~1
[>] МЕТОД НЬЮТОНА
    Корень: x = -2.3432520954
    Итераций: 4
    f(x) = -8.66e-06
```

=== Система уравнений
input-files/sys.txt
```
task=equation
function=1
a=-3
b=-2
method=2
eps=0.01
output=file
output_file=/tmp/result.txt
plot=no
```
Результат:
```
Система: tan(xy+0.2)-x^2=0, x^2+2y^2-1=0
Метод: Метод Ньютона
Точность: 0.01
Начальные значения: x0=0.5, y0=0.5

[>] РЕШЕНИЕ СИСТЕМЫ (Метод Ньютона)
    x = 0.7789662086, y = 0.4434027217
    Итераций: 4
    f1(x, y) = -3.49e-07
    f2(x, y) = 3.01e-07
```

= Вывод

В ходе лабораторной работы изучены численные методы решения нелинейных уравнений и систем: метод половинного деления, простой итерации, секущих и метод Ньютона.

Для уравнения $4.45x^3 + 7.81x^2 - 9.62x - 8.17 = 0$ найдены три корня: $-2.35$, $-0.640$ и $1.227$ с точностью $0.01$.

Для системы $cases(tan(x y+0.2)=x^2, x^2+2y^2=1)$ методом Ньютона найдены четыре корня, например $(0.773; 0.457)$ и $(-0.221; 0.686)$.

Разработанная программа успешно реализует все указанные методы. Цель работы достигнута.