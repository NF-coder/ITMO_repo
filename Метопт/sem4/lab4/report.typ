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

// Constants
#let dark_blue = oklch(45%, 0.095, 260deg)
#let dark_geen = oklch(45%, 0.095, 150deg)

#set figure.caption(separator: [ --- ])
#show math.cases: math.display
#show math.equation.where(block: false): it => math.display(it)
#show ref: it => underline(text(fill: dark_geen)[#it])
#show link: it => underline(text(fill: dark_blue)[#it])
#set heading(numbering: "1.")
#show bibliography: set heading(numbering: "1.")

#show heading.where(level: 1): set text(oklch(30%, 0.095, 260deg))
#show heading.where(level: 2): set text(oklch(40%, 0.095, 260deg))
#show heading.where(level: 3): set text(oklch(50%, 0.095, 260deg))
#show heading.where(level: 4): set text(oklch(60%, 0.095, 260deg))


// DOCUMENT TITLE PAGE
#align(center)[
  #text(size:12pt)[
    Федеральное государственное автономное образовательное учреждение высшего
    образования «Национальный исследовательский университет ИТМО»\
  ]
]

#align(center + horizon)[
  #box(
      width: 100%,
      height: 8cm
  )[
    #text(size: 14pt)[
      *Лабораторная работа №4*\
      "Численные методы безусловной оптимизации функции нескольких переменных на основе дифференциального исчисления"\
      Вариант №10
    ]
  ]
]
#align(right)[  
      Выполнили:\
      Горин С.Д.\
      Таустоб Г.В.\  
      Решетников С.Е.\
      
      Проверила:\  
      Селина Е.Г.
]

#align(center + bottom)[
  Санкт-Петербург, 2026
]

#pagebreak()

= Исходные данные
$
  f (x_1, x_2) = 3 x_1^2 + 2 x_1 x_2 + 4 x_2^2 + 12 x_1 + 26 x_2 + 45
$
Начальная точка: $(2,4)$

= Задание №1
Найдите все экстремумы функции по варианту аналитическими методами

Решение:
1. Найдём частные производные
$
  (partial f) / (partial x_1) = 6 x_1 + 2 x_2 + 12 quad quad
  (partial f) / (partial x_2) = 2 x_1 + 8 x_2 + 26
$
2. Приравняем к нули и найдём точки-кандидаты
$
  cases(
    6 x_1 + 2 x_2 + 12 = 0,
    2 x_1 + 8 x_2 + 26 = 0
  ) <=>
  mat(
    6,2, -12;
    2,8, -26;
    augment: #(-1)
  )\

  mat(
    0,-22, 66;
    2,8,   -26;
    augment: #(-1)
  ) <-> mat(
    0,1, -3;
    2,8, -26;
    augment: #(-1)
  ) <-> mat(
    0,1, -3;
    2,0, -2;
    augment: #(-1)
  ) <-> mat(
    0,1, -3;
    1,0, -1;
    augment: #(-1)
  )\
$
Точка-кандидат - $(-1; -3)$
3. Найдём Гессиан
$
  H(f) = mat(
    (partial^2 f)/(partial x_1^2), (partial^2 f)/(partial x_1 partial x_2);
    (partial^2 f)/(partial x_2 partial x_1), (partial^2 f)/(partial^2 x_2);
  ) = mat(
    6, 2;
    2, 8
  )\
  det(H(f)) = mat(
    delim: "|",
    6,2;
    2,8
  ) = 6 dot 8 - 2 dot 2 = 48 - 4 = 44
$
$
  cases(
    det(H(f)) > 0,
    (partial^2 f)/(partial x_1^2) > 0
  ) => (-1; -3) "- точка минимума"
$

= Задание №2
== Метод покоординатного спуска
1. Фиксируем $x^0 = (2;4)$
2. Шаг 1
  1. Шаг 1.1 Минимизируем $x_1$
  #box(width: 100%)[$
    f(x_1,4) = 3 x_1^2 + 2 x_1 dot 4 + 4 dot 4^2 + 12 x_1 + 26 dot 4 + 45 = 3 x_1^2 + 20 x_1 + 213\
    (partial f)/(partial x_1) = 6 dot x_1 + 20 = 0\
    x_1 = -10/3\
    x^0 = (-10/3; 4)
  $]
  2. Шаг 1.2 Минимизируем $x_2$
  #box(width: 100%)[$
    f(-10/3,x_2) = 3 (-10/3)^2 + 2 (-10/3) x_2 + 4 x_2^2 + 12 (-10/3) + 26 x_2 + 45 =\
    100/3 - 20/3 x_2 + 4 x_2^2 - 40 + 26 x_2 + 45 = 85/3 + 58/3 x_2 + 4 x_2^2\
    (partial f)/(partial x_2) = 58/3 + 8 x_2 = 0\
    x_2 = -29/12\
    x^1 = (-10/3; -29/12)
  $]
3. Шаг 2
  1. Шаг 2.1 Минимизируем $x_1$
  #box(width: 100%)[$
    f(x_1,-29/12) = 3 x_1^2 + 2 x_1 (-29/12) + 4 (-29/12)^2 + 12 x_1 + 26 (-29/12) + 45 =\
    3 x_1^2 - 29/6 x_1 + 12 x_1 + C = 3 x_1^2 + 43/6 x_1 + C\
    (partial f)/(partial x_1) = 6 x_1 + 43/6 = 0\
    x_1 = -43/36\
    x^1 = (-43/36; -29/12)\
  $]
  2. Шаг 2.2 Минимизируем $x_2$
  #box(width: 100%)[$
    f(-43/36,x_2) = 3 (-43/36)^2 + 2 (-43/36) x_2 + 4 x_2^2 + 12 (-43/36) + 26 x_2 + 45 =\
    4 x_2^2 + (2 (-43/36) + 26)x_2 + C =
    4 x_2^2 + 425/18 x_2 + C\
    (partial f)/(partial x_2) = 8 x_2 + 425/18 = 0\
    x_2 = -425/144\
    x^2 = (-43/36; -425/144)
  $]
4. Шаг 3
  1. Шаг 3.1 Минимизируем $x_1$
  #box(width: 100%)[$
    f(x_1,-425/144) = 3 x_1^2 + 2 x_1 (-425/144) + 12 x_1 + C =\
    3 x_1^2 + (-425/72 + 12)x_1 + C =
    3 x_1^2 + 439/72 x_1 + C\
    (partial f)/(partial x_1) = 6 x_1 + 439/72 = 0\
    x_1 = -439/432\
    x^2 = (-439/432; -425/144)
  $]
  2. Шаг 3.2 Минимизируем $x_2$
  #box(width: 100%)[$
    f(-439/432,x_2) = 4 x_2^2 + (2 (-439/432) + 26)x_2 + C =
    4 x_2^2 + 10349/432 x_2 + C\
    (partial f)/(partial x_2) = 8 x_2 + 10349/432 = 0\
    x_2 = -10349/3456\
    x^3 = (-439/432; -10349/3456)\
  $]

== Метод градиентного спуска
1. Найдём градиент
#box(width: 100%)[$
  nabla f(x_1,x_2) = (6x_1 + 2x_2 + 12; 2x_1 + 8x_2 + 26)\
$]
и определим начальные значения
$
  x^0 = (2;4) quad alpha = 0.1\
  f^0 = 265
$
2. Шаг 1
#box(width: 100%)[$
  nabla f(2,4) = (6 dot 2 + 2 dot 4 + 12; 2 dot 2 + 8 dot 4 + 26) = (32; 62)\
  x^1 = (2;4) - 0.1 dot (32;62) = (2 - 3.2; 4 - 6.2) = (-1.2; -2.2)\
  f^1= 2.36 quad f^0 > f^1
$]
3. Шаг 2
#box(width: 100%)[$
  nabla f(-1.2,-2.2) = (6(-1.2) + 2(-2.2) + 12; 2(-1.2) + 8(-2.2) + 26) = (0.4; 6)\
  x^2 = (-1.2;-2.2) - 0.1 dot (0.4;6) = (-1.24; -2.8)\
  f^2 = 0.23 quad f^1 > f^2
$]
4. Шаг 3
#box(width: 100%)[$
  nabla f(-1.24,-2.8) = (6(-1.24) + 2(-2.8) + 12; 2(-1.24) + 8(-2.8) + 26) = (-1.04; 1.12)\
  x^3 = (-1.24;-2.8) - 0.1 dot (-1.04;1.12) = (-1.136; -2.912)\
  f^3 = 0.06 quad f^2 > f^3
$]

== Метод наискорейшего спуска

1. Найдём градиент
#box(width: 100%)[$
  nabla f(x) = (6x_1 + 2x_2 + 12; 2x_1 + 8x_2 + 26)
$]

2. Шаг №1
#box(width: 100%)[
Движемся вдоль антиградиента
$
  nabla f(2,4) = (32;62) \
  ||nabla f|| = 69.77 \
  S = (32/69.77; 62/69.77) approx (0.45; 0.88) \
  
  x_1 = 2 - 0.45 lambda quad
  x_2 = 4 - 0.88 lambda
$
Подставляем
$
  f(lambda) = 3(2 - 0.45 lambda)^2 + 2(2 - 0.45 lambda)(4 - 0.88 lambda) + 4(4 - 0.88 lambda)^2 + 
  12(2 - 0.45 lambda) + 26(4 - 0.88 lambda) + 45 \
  f(lambda) approx 44.83 lambda^2 - 69.77 lambda + C
$
Находим оптимальный шаг
$
  (partial f)/(partial lambda) = 89.66 lambda - 69.77 = 0 \
  lambda_1 approx 69.77 / 89.66 approx 0.778 \
  x^(1) approx (2;4) - 0.778 (0.45;0.88) approx (1.65;3.32)
$]

3. Шаг №2
#box(width: 100%)[
Движемся вдоль антиградиента
$
  nabla f(1.65,3.32) approx (28.54;55.86) \
  ||nabla f|| approx 62.70 \
  S approx (0.46;0.89) \
  
  x_1 = 1.65 - 0.46 lambda quad
  x_2 = 3.32 - 0.89 lambda
$
Подставляем
$
  f(lambda) approx 39.30 lambda^2 - 62.70 lambda + C
$
Находим оптимальный шаг
$
  (partial f)/(partial lambda) = 78.60 lambda - 62.70 = 0 \
  lambda_2 approx 62.70 / 78.60 approx 0.798 \
  x^(2) approx (1.65;3.32) - 0.798 (0.46;0.89) approx (1.28;2.61)
$]

4. Шаг №3
#box(width: 100%)[
Движемся вдоль антиградиента
$
  nabla f(1.28,2.61) approx (24.90;48.02) \
  ||nabla f|| approx 54.17 \
  S approx (0.46;0.89) \
  
  x_1 = 1.28 - 0.46 lambda quad
  x_2 = 2.61 - 0.89 lambda
$
Подставляем
$
  f(lambda) approx 29.35 lambda^2 - 54.17 lambda + C
$
Находим оптимальный шаг
$
  (partial f)/(partial lambda) = 58.70 lambda - 54.17 = 0 \
  lambda_3 approx 54.17 / 58.70 approx 0.923 \
  x^(3) approx (1.28;2.61) - 0.923 (0.46;0.89) approx (0.86;1.79)
$]