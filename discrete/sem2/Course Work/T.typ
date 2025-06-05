#import "@preview/lilaq:0.3.0" as lq


#set page(
  width: 210mm,
  height: 297mm,
  margin: 2.5cm,
  footer: [
    #align(center)[
      Санкт-Петербург 2025
    ]
  ]
)

#set text(
  font: "Liberation Serif",
  size: 12pt,
)

#align(center)[
  Федеральное государственное автономное образовательное учреждение высшего образования «Национальный исследовательский университет ИТМО»
  
  #v(0.1em)
  
  Факультет Программной Инженерии и Компьютерной Техники
  
  #v(20em)
  
  Курсовая работа\
  Нечёткий вывод по схеме Мамдани
  
  
  #v(19em)
  
  #align(right)[
    Выполнил:\
    Решетников Сергей Евгеньевич\
    Группа Р3108\
    Проверил:\
    Поляков Владимир Иванович
  ]
]

#pagebreak()

#set page(footer: "", margin: (top: 2cm, right: 2.5cm, bottom: 1cm, left: 2.5cm) )
#set par(first-line-indent: 1.25cm, leading: 7pt)
= 1. Содержательная постановка задачи

= 1.1 Задача
Разработать алгоритм нечеткого вывода по схеме «Мамдани», по которому определяется, сколько баллов набрал студент за тест, исходя из количества и усреднённого качества шпаргалок.

= 1.2 Входные данные
1. Количество шпаргалок $a in [0; 8], a in ZZ$\
2. Усредненное качество шпаргалок $ b in [0; 1]$

= 1.3 Выходные данные
Оценка за тест в баллах БаРС $x in [0; 20]$

= 2 Фазификация
Во входных данных заданы две переменные:
1. a - Количество шпаргалок (0 ≤ h ≤ 8).
2. b - усредненная оценка за тесты (0 ≤ b ≤ 1).

Необходимо разбить каждую из этих переменных на лингвистические термы иопределить для них функции принадлежности.

= 2.1 Лингвистические термы для количества шпаргалок a

1. SA (Small Amount) – малое количество шпаргалок
2. MA (Medium Amount) – среднее количество шпаргалок
3. HA (High Amount) – большое количество шпаргалок

Функции принадлежности:

$ A_"SA" (a)=1-a/3 , quad 0 lt.eq a lt.eq 3 $
$ A_"SA" (a)=cases(
  a/2-1 quad 2 lt.eq a lt.eq 4,
  -a/2+3  quad 4 lt.eq a lt.eq 6
) $
$ A_"HA" (a)=a/4-1 , quad 4 lt.eq a lt.eq 8 $

#align(center)[
#lq.diagram(
  title: [Функции принадлежности для количества шпаргалок],
  xlabel: $a$, 
  ylabel: $A(a)$,

  width: 350pt,
  height: 150pt,
  
  lq.line(
    (0, 1), (3, 0),
    stroke: (paint: red, thickness: 1.3pt),
     label: [LA]
  ),

  lq.line(
    (2, 0), (4, 1),
    stroke: (paint: blue, thickness: 1.3pt),
     label: [MA]
  ),
  lq.line(
    (4, 1), (6, 0),
    stroke: (paint: blue, thickness: 1.3pt),
  ),

  lq.line(
    (4, 0), (8, 1),
    stroke: (paint: green, thickness: 1.3pt),
     label: [HA]
  )
)
]


= 2.2 Лингвистические термы для качества шпаргалок b
1. LQ (Low Quality) – плохое качество шпаргалок
2. MQ (Medium Quality) – среднее качество шпаргалок
3. HQ (High Quality) – высокое качество шпаргалок

Функции принадлежности:

$ Q_"LQ" (b)=-b dot 2.5+1  quad 0 lt.eq b lt.eq 0.4 $
$ Q_"MQ" (b)=cases(
  (b dot 10)/3-2/3  quad 0.2 lt.eq b lt.eq 0.5,
  -5 dot b + 3.5  quad 0.5 lt.eq b lt.eq 0.7
) $
$ Q_"HQ" (b)=-b dot 2.5+1.5  quad 0.6 lt.eq b lt.eq 1 $

#align(center)[
#lq.diagram(
  title: [Функции принадлежности для качества шпаргалок],
  xlabel: $b$, 
  ylabel: $Q(b)$,

  width: 350pt,
  height: 150pt,
  
  lq.line(
    (0, 1), (.4, 0),
    stroke: (paint: red, thickness: 1.3pt),
     label: [LQ]
  ),

  lq.line(
    (.2, 0), (.5, 1),
    stroke: (paint: blue, thickness: 1.3pt),
     label: [MQ]
  ),
  lq.line(
    (.5, 1), (.7, 0),
    stroke: (paint: blue, thickness: 1.3pt),
  ),

  lq.line(
    (.6, 0), (1, 1),
    stroke: (paint: green, thickness: 1.3pt),
     label: [HQ]
  )
)
]

= 2.3 Лингвистические термы для выходной переменной z
Выходная переменная x (количество баллов БаРС) лежит в диапазоне [0; 20]. Разобьём её на пять термов:
1. PS (Puny Score) — ничтожное количество баллов.
2. LS (Low Score) — малое количество баллов.
3. MS (Medium Score) — среднее количество баллов.
4. HS (High Score) — высокое количество баллов.
5. OS (Outstanding Score) — очень высокое количество баллов.
Функции принадлежности:
$ alpha_"PS" = -x/3 + 1  quad 0 lt.eq x lt.eq 3 $
$ alpha_"LS" = cases(
  x/3-2/3 quad 2 lt.eq x lt.eq 5,
  -x/3+8/3  quad 5 lt.eq x lt.eq 8
) $
$ alpha_"MS" = cases(
  x/3-7/3 quad 7 lt.eq x lt.eq 10,
  -x/3+13/3  quad 10 lt.eq x lt.eq 13
) $
$ alpha_"HS" = cases(
  x/3-12/3 quad 12 lt.eq x lt.eq 15,
  -x/3+18/3  quad 15 lt.eq x lt.eq 18
) $
$ alpha_"OS" = x/3 + 17/3  quad 17 lt.eq x lt.eq 20 $

#align(center)[
#lq.diagram(
  title: [Функции принадлежности для выходного значения],
  xlabel: $x$, 
  ylabel: $alpha(x)$,

  width: 450pt,
  height: 150pt,
  
  lq.line(
    (0, 1), (3, 0),
    stroke: (paint: red, thickness: 1.3pt),
     label: [PS]
  ),

  lq.line(
    (2, 0), (5, 1),
    stroke: (paint: blue, thickness: 1.3pt),
     label: [LS]
  ),
  lq.line(
    (5, 1), (8, 0),
    stroke: (paint: blue, thickness: 1.3pt),
  ),

  lq.line(
    (7, 0), (10, 1),
    stroke: (paint: orange, thickness: 1.3pt),
     label: [MS]
  ),
  lq.line(
    (10, 1), (13, 0),
    stroke: (paint: orange, thickness: 1.3pt),
  ),

  lq.line(
    (12, 0), (15, 1),
    stroke: (paint: green, thickness: 1.3pt),
     label: [HS]
  ),
  lq.line(
    (15, 1), (18, 0),
    stroke: (paint: green, thickness: 1.3pt),
  ),

  lq.line(
    (17, 0), (20, 1),
    stroke: (paint: yellow, thickness: 1.3pt),
     label: [OS]
  )
)
]


= 3 Блок выработки решения
На основе лингвистических термов построим базу правил

#align(center)[
#table(
  columns: (auto, auto, auto, auto),
  align: (center, center, center, center),
  stroke: (bottom: 1pt + black),
  [Количество \\ Среднее качество],
        [LQ], [MQ], [HQ],
  [SA], [PS], [LS], [MS],
  [MA], [LS], [MS], [HS],
  [HA], [MS], [HS], [OS]
)
]

= 3.1 Процедура вычисления истинности правил
Пусть заданы входные значения\
$ a = 5, quad b = 0.5 $

Вычислим сразу ненулевые степени принадлежности:
$ A_"MA" (5) = 0.5  quad A_"HA" (5) = 0.25 quad  Q_"MQ" (0.5) = 1 $

#align(center)[
#table(
  columns: (auto, auto, auto, auto),
  align: (center, center, center, center),
  stroke: (bottom: 1pt + black),
  [Количество шпаргалок \\ Среднее качество шпаргалок],
        [LQ], [MQ], [HQ],
  [SA], [PS], [LS], [MS],
  [MA], [LS], table.cell(fill: green.lighten(60%))[MS], [HS],
  [HA], [MS], table.cell(fill: green.lighten(60%))[HS], [OS]
)
]
Для каждой из этих двух активированных ячеек вычисляем степень истинности:
Аггрегирование:
$ beta_"MS" = min(A_"MA" (5), Q_"MQ" (0.5)) = min(0.5, 1) = 0.5 $
$ beta_"HS" = min(A_"MA" (5), Q_"MQ" (0.5))  = min(0.25, 1) = 0.25 $

Активация:
$ gamma_"MS" = min(alpha_"MS" (x), 0.5) quad quad gamma_"HS" = min(alpha_"HS" (x), 0.25) $

#pagebreak()

Аккумулирование:
$
  delta_"agg" = max(gamma_"MS" (x), gamma_"HS" (x)) quad quad x in [0; 20] 
$

= 4 Дефазификация
Для получения единственного числового ответа x\* применяем метод центра тяжести:
$ x\* = (integral_0^20 x dot delta_"agg" (x) quad d x)/(integral_0^20 delta_"agg" (x) quad d x) $
При численной аппроксимации получаем x\* ≈ 12.1,
Таким образом, при  $a = 5 " и " b = 0.5$ студент набирает примерно 12.1 балла БаРС.