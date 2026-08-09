#set figure.caption(separator: [ -- ])

#show ref: underline

#show math.equation.where(block: true): block.with(width: 100%)

#block()[
  = Цель работы
  
    1. Измерение зависимости магнитной индукции в ферромагнетике от напряженности магнитного поля $B=B(H)$
    2. Определение по предельной петле гистерезиса индукции насыщения, остаточной индукции и коэрцитивной силы
    3. Получение зависимости магнитной проницаемости от напряженности магнитного поля $mu=mu(H)$ и оценка максимального значения величины магнитной проницаемости
    4. Расчет мощности потерь энергии в ферромагнетике в процессе его перемагничивания
]
#block()[
  = Задачи, решаемые при выполнении работы
    1. Экспериментально получить зависимость магнитной индукции $B$ от напряжённости магнитного поля $H$ для исследуемого ферромагнитного образца.
    2. Построить предельную петлю гистерезиса и определить по ней основные характеристики материала: коэрцитивную силу и остаточную индукцию.
    3. Рассчитать магнитную проницаемость $mu$ при различных значениях $H$ и определить её максимальное значение.
    4. Оценить энергетические потери в ферромагнетике при перемагничивании на основе площади петли гистерезиса.

]
#block()[
  = Объект исследования
    Сердечник (магнитопровод) трансформатора как образец для изучения магнитных свойств ферромагнитного материала.
]
#block()[
  = Метод экспериментального исследования
    Многократное повторение измерений целевых велечин
]
#block()[
  = Рабочие формулы и исходные данные
  #figure(
    table(
      align: horizon+center,
      columns: 2,
      inset: 6pt,
      [*Величина*], [*Значение*],
      [$N_1$],  [$1665$],
      [$N_2$],  [$970$],
      [$l$],    [$0.078 plus.minus 0.001 "м"$],
      [$R_1$],  [$68 plus.minus 6.8 "Ом"$],
      [$R_2$],  [$47 dot 10^4 plus.minus 47 dot 10^3 "Ом" $],
      [$C_1$],  [$47 dot 10^(-8) plus.minus 47 dot 10^(-9) "Ф"$],
      [$S$],    [$64 dot 10^(-6) plus.minus 5 dot 10^(-6) "м"^2$],
      [$mu_0$], [$4 dot pi dot 10^(-7) "Гн"/"м"$],
    ),
    caption: [Справочная информация об установке]
  ) <table:basic_info>
  
  Частота сигнала
  $
    f = 31 plus.minus 1 "Гц"
  $
  
  + Коэффициент $alpha$
    $
      alpha = N_1 / (l dot R_1)\
      Delta alpha = sqrt(((Delta N_1)/(l dot R_1))^2 + ((N_1 dot Delta l)/(l^2 dot R_1))^2 + ((N_1 dot Delta R_1)/(l dot R_1^2))^2)
    $
  + Коэффициент $beta$
    $
      beta = (R_2 dot C_1) / (N_2 dot S)\
      Delta beta = sqrt(((C_1 dot Delta R_2)/(N_2 dot S))^2 + ((R_2 dot Delta C_1)/(N_2 dot S))^2 + ((R_2 dot C_1 dot Delta N_2)/(S dot N_2^2))^2 + ((R_2 dot C_1 dot Delta S)/(N_2 dot S^2))^2)
    $
  + Напряжённость $H$
    $
      H = alpha dot K_x dot X\
      Delta H = sqrt((Delta alpha dot K_x dot X)^2 + (alpha dot Delta K_x dot X)^2 + (alpha dot K_x dot Delta X)^2)
    $
  + Индукция $B$
    $
      B = beta dot K_y dot Y\
      Delta B = sqrt((Delta beta dot K_y dot Y)^2 + (beta dot Delta K_y dot Y)^2 + (beta dot K_y dot Delta Y)^2)
    $
  + Магнитная проницаемость $mu$
    $
      mu = B/(mu_0 dot H)\
      Delta mu = sqrt(((Delta B)/(mu_0 dot H))^2 + ((B dot Delta H)/(mu_0 dot H^2))^2)
    $
  + Коэффициент $chi$
    $
      chi = K_x dot K_y dot (N_1 dot R_2 dot C_1)/(N_2 dot R_1) dot f\
      Delta chi = sqrt(
        (Delta K_x dot K_y dot (N_1 dot R_2 dot C_1)/(N_2 dot R_1) dot f)^2 +
        (K_x dot Delta K_y dot (N_1 dot R_2 dot C_1)/(N_2 dot R_1) dot f)^2 +\
        (K_x dot K_y dot (Delta N_1 dot R_2 dot C_1)/(N_2 dot R_1) dot f)^2 +
        (K_x dot K_y dot (N_1 dot Delta R_2 dot C_1)/(N_2 dot R_1) dot f)^2 +\
        (K_x dot K_y dot (N_1 dot R_2 dot Delta C_1)/(N_2 dot R_1) dot f)^2 +
        (K_x dot K_y dot (N_1 dot R_2 dot C_1 dot Delta N_2)/(N_2^2 dot R_1) dot f)^2 +\
        (K_x dot K_y dot (N_1 dot R_2 dot C_1 dot Delta R_1)/(N_2 dot R_1^2) dot f)^2 +
        (K_x dot K_y dot (N_1 dot R_2 dot C_1)/(N_2 dot R_1) dot Delta f)^2
      )
    $
  + Мощность необходимая для перемагничивания $P$
    $
      P = chi dot S_"ПГ"\
      Delta P = sqrt((S_"ПГ" dot Delta chi)^2 + (chi dot Delta S_"ПГ")^2)
    $
]
#block()[
  = Измерительные приборы
    #table(
      columns: (auto, 2fr, 1fr, 1fr),
      align: center + horizon,
      table.header([№], [Наименование], [Тип], [$epsilon_и$]),
      [1],[Запоминающий осциллограф],
      [Цифровой],
      [$plus.minus 3 %$]
    )
]
#block(width: 100%)[
  = Схема установки
    #figure(
      image("assets/schema.png"),
      caption: [Принципиальная схема экспериментальной установки]
    )
]
#block()[
  = Результаты прямых измерений и их обработки

  1. Подберём значения $K_x$ и $К_y$ чтобы сигналы по обоим канадам занимали как можно большую часть экрана и занесём в @table:coeffs

  2. Выровняем петлю и запишем rоординаты $X_c$ и $Y_r$ пересечения петли гистерезиса с осями координат в @table:intersection

  3. Измерим координаты $X_m$ и $Y_m$ вершины петли гистерезиса и занесём в @table:top_params

  4. Приняв деление за $0.5 "см"$ найдём площадь петли гистерезиса
  $
    S_"ПГ" approx 143 dot 0.25 = 35.75 "см"^2 = 357.5 dot 10^(-5) "м"^2 
  $

  5. Изменяя с шагом в 1 В амплитуду напряжения генератора занесём в @table:result_list параметры $K_x$ и $K_y$, при который амплитуда петли максимальна
]



#block()[
  = Результаты косвенных измерений и их обработка
  1. По данным из @table:basic_info вычислим коэффициенты $alpha$ и $beta$
  $
    alpha = N_1 / (l dot R_1) = 1665/(0.078 dot 68) approx 313.91 1/("м" dot "Ом")\
    beta = (R_2 dot C_1)/(N_2 dot S) = (47 dot 10^4 dot 47 dot 10^(-8))/(970 dot 64 dot 10^(-6)) approx 3.56 ("Ом" dot "Ф")/("м"^2)
  $

  Определим коэрцитивную силу $H_c$ и остаточную индукцию $B_r$ для исследуемого образца и занесём результаты в @table:intersection

  $
    H_c = alpha dot K_x dot X_c = 313.91 dot 0.1 dot 3.8 approx 119.28 А/м \
    B_r = beta dot K_y dot Y_r = 3.56 dot 0.05 dot 6.5 = 1.16 "Тл"
  $
  2. Дозаполним @table:top_params

  $
    H_m = alpha dot K_x dot X_m = 313.91 dot 0.1 dot 17.5 approx 549.34 А/м \
    B_m = beta dot K_y dot Y_m = 3.56 dot 0.05 dot 15.1 = 2.68 "Тл"\
    mu_m = B_m/(mu_0 dot H_m) = 2.68 / (4 dot pi dot 10^(-7) dot 549.34) approx 3890.87
  $

  3. Определим коэффициент $chi$ и среднюю мощность $P$, расходуемую на перемагничивание образца

  $
    chi = K_x dot K_y dot (N_1 dot R_2 dot C_1)/(N_2 dot R_1) dot f = 0.1 dot 0.05 dot (1665 dot 47 dot 10^4 dot 47 dot 10^(-8))/(970 dot 68) dot 31 = 8.64 dot 10^(-4)\
    P = chi dot S_"ПГ" = 8.64 dot 10^(-4) dot 357.5 dot 10^(-5) = 308.88 dot 10^(-8) "Вт"
  $

  4. По аналоги дозаполним столбцы в @table:result_list

  5. По графику @fig:H_and_mu видно что максимальное $mu$ достигается при $H_"max"=125.56 A/м$ и $B_"max"=1.12 "Тл"$ \
    Тогда $
      mu_"max" = B_"max"/(mu_0 dot H_"max") = 7103.53
    $
]
#block()[
  = Расчет погрешностей измерений
  + Рассчитаем погрешность для $alpha$
    $
      Delta alpha = sqrt(((Delta N_1)/(l dot R_1))^2 + ((N_1 dot Delta l)/(l^2 dot R_1))^2 + ((N_1 dot Delta R_1)/(l dot R_1^2))^2) approx 31.64 space 1/("м" dot "Ом")
    $
  + Рассчитаем погрешность для $beta$
    $
      Delta beta = sqrt(((C_1 dot Delta R_2)/(N_2 dot S))^2 + ((R_2 dot Delta C_1)/(N_2 dot S))^2 + ((R_2 dot C_1 dot Delta N_2)/(S dot N_2^2))^2 + ((R_2 dot C_1 dot Delta S)/(N_2 dot S^2))^2) approx\
      approx 0.57 space ("Oм" dot "Ф")/"м"^2
    $
  + Рассчитаем погрешность для $H_c$
    $
      Delta H_c = sqrt((Delta alpha dot K_x dot X_c)^2 + (alpha dot Delta K_x dot X_c)^2 + (alpha dot K_x dot Delta X_c)^2) approx 12.93 space "А"/"м"
    $
  + Рассчитаем погрешность для $B_r$
    $
      Delta B_r = sqrt((Delta beta dot K_y dot Y_r)^2 + (beta dot Delta K_y dot Y_r)^2 + (beta dot K_y dot Delta Y_r)^2) approx 0.38 "Тл"
    $
  + Рассчитаем погрешность для $H_m$
    $
      Delta H_m = sqrt((Delta alpha dot K_x dot X)^2 + (alpha dot Delta K_x dot X)^2 + (alpha dot K_x dot Delta X)^2) approx 57.87 space "А"/"м"
    $
  + Рассчитаем погрешность для $B_m$
    $
      Delta B_m = sqrt((Delta beta dot K_y dot Y)^2 + (beta dot Delta K_y dot Y)^2 + (beta dot K_y dot Delta Y)^2) approx 0.44 "Тл"
    $
  + Рассчитаем погрешность для $chi$
    $
      Delta chi = ... = 0.15 dot 10^(-3)
    $
  + Рассчитаем погрешность для $P$
    $
      Delta P = sqrt((S_"пг" dot Delta chi)^2 + (chi dot Delta S_"пг")^2) = 54.32 dot 10^(-8) "Вт"
    $
  + Рассчитаем погрешность для $mu_"max"$
    $
      Delta B_"max" = 13.58\
      Delta H_"max" = 0.19\
      Delta mu_"max" = sqrt(((Delta B_"max")/(mu_0 dot H_"max"))^2 + ((B_"max" dot Delta H_"max")/(mu_0 dot H_"max"^2))^2) = 1401.84\
    $
]
#block(width: 100%)[
  = Графики
  #figure(
    image(
      "img/H_and_B.png"
    ),
    caption: [Кривая начльного намагничивания ($B_m = B_m (H_m)$)]
  )

  #figure(
    image(
      "img/H_and_mu.png"
    ),
    caption: [Кривая магнитной проницаемости ($mu = mu (H_m)$)]
  ) <fig:H_and_mu>

]
#block()[
  = Окончательные результаты

  В результате выполнения лабораторной работы были плучены следующие значения:

  + Параметры исследуемого образца
    - коэрцитивной силы: $H_c = (119.28 plus.minus 12.94) space "А"/"м"$ 
    - остаточной индукции: $B_r = (1.156 plus.minus 0.191) space "Тл"$ 
  + Получены значения в состоянии насыщени
    - Индукции $B_m = 2.67 plus.minus 0.44 "Тл"$
    - Напряженности $H_m = (549.35 plus.minus 57.87) space "А"/"м"$
    - Магнитной проницаемости $mu_m = (3890.87 plus.minus 759.50)$
  + Получена мощность потерь на перемагничивание ферромагнетика\
    - $P = (3088.8 dot 10^(-9) plus.minus 5.43 dot 10^(-7)) "Вт"$
  + Графически получено максимальное значение проницаемости
    - $mu_"max" = (7103.53 plus.minus 1401.84)$
]
#block()[
  = Выводы

  В ходе выполнения лабораторной работы были экспериментально исследованы магнитные свойства ферромагнитного сердечника трансформатора.

  Получена зависимость $B(H)$ и построена петля гистерезиса, что позволило определить основные характеристики материала\
  Коэрцитивная сила составила  
  $ H_c = (119 plus.minus 13) "А"/"м" $
  остаточная индукция --
  $ B_r = (1.156 plus.minus 0.191) "Тл" $

  В области насыщения были получены значения:\
  $ B_m = (2.67 plus.minus 0.44) "Тл" quad H_m = (549.35 plus.minus 57.87) "А"/"м" quad mu_m = (3890.87 plus.minus 759.50) $

  Также по графику установлено максимальное значение магнитной проницаемости:
  $ mu_"max" = (7104 plus.minus 1402) $
  что соответствует области наибольшей чувствительности материала к внешнему магнитному полю.

  Оценка энергетических потерь показала, что мощность, затрачиваемая на перемагничивание образца, равна  
  $ P = (309  plus.minus 54) dot 10^(-8) "Вт" $  
  что свидетельствует о наличии гистерезисных потерь в ферромагнетике.
]


#block()[
  #set heading(numbering: none)
  = Приложение A

  #figure(
    table(
      align: center + horizon,
      columns: (1fr, 1fr),
      inset: 6pt,
      [$K_x$, _В_], [$K_y$, _В_],
      [0.1], [0.05]
    ),
    caption: [Коэффициенты усиления]
  ) <table:coeffs>

  = Приложение B
  #figure(
    table(
      align: center + horizon,
      columns: (1fr, 1fr, 1fr, 1fr),
      inset: 6pt,
      [$X_c$, _дел_], [$Y_r$, _дел_], [$H_c$, _А/м_], [$B_r$, _Тл_],
      [3.8], [6.5], [119.28], [1.16]
    ),
    caption: [Параметры первой петли гистерезиса]
  ) <table:intersection>

  = Приложение C
  #figure(
    table(
      align: center + horizon,
      columns: (1fr, 1fr, 1fr, 1fr, 1fr),
      inset: 6pt,
      [$X_m$, _дел_], [$Y_m$, _дел_], [$H_m$, _А/м_], [$B_m$, _Тл_], [$mu_m$],
      [17.5], [15.1], [549.34], [2.68], [3890.87]
    ),
    caption: [Параметры вершины петли гистерезиса]
  ) <table:top_params>

  = Приложение D
  #figure(
    text(12pt)[
      #table(
        align: center + horizon,
        columns: (auto, auto, auto, auto, auto, auto, auto, auto),
        inset: 7pt,
        [$U$, _В_], [$X$, _дел_], [$H$, _$"А"/"м"$_], [$Y$, _дел_], [$K_y$, _$"В"/"дел"$_], [$B$, _Тл_], [$K_x$, _$"В"/"дел"$_], [$mu$],
        [$20$], [$4.0$], [$125.57 plus.minus 13.58$], [$6.3$], [$0.05$], [$1.12 plus.minus 0.19$], [$0.10$], [$7103.53 plus.minus 1401.84$],
	      [$19$], [$4.0$], [$125.57 plus.minus 13.58$], [$6.0$], [$0.05$], [$1.07 plus.minus 0.18$], [$0.10$], [$6765.26 plus.minus 1335.53$],
	      [$18$], [$3.9$], [$122.43 plus.minus 13.25$], [$5.5$], [$0.05$], [$0.98 plus.minus 0.16$], [$0.10$], [$6360.50 plus.minus 1257.00$],
	      [$17$], [$3.5$], [$109.87 plus.minus 11.98$], [$5.0$], [$0.05$], [$0.89 plus.minus 0.15$], [$0.10$], [$6443.11 plus.minus 1277.04$],
	      [$16$], [$3.5$], [$109.87 plus.minus 11.98$], [$4.5$], [$0.05$], [$0.80 plus.minus 0.13$], [$0.10$], [$5798.80 plus.minus 1150.71$],
	      [$15$], [$3.2$], [$100.45 plus.minus 11.02$], [$4.5$], [$0.05$], [$0.80 plus.minus 0.13$], [$0.10$], [$6342.43 plus.minus 1261.14$],
	      [$14$], [$3.1$], [$97.31 plus.minus 10.71$], [$4.2$], [$0.05$], [$0.75 plus.minus 0.12$], [$0.10$], [$6110.56 plus.minus 1217.14$],
	      [$13$], [$6.0$], [$94.17 plus.minus 10.03$], [$4.0$], [$0.05$], [$0.71 plus.minus 0.12$], [$0.05$], [$6013.57 plus.minus 1187.14$],
	      [$12$], [$5.5$], [$86.33 plus.minus 9.22$], [$4.0$], [$0.05$], [$0.71 plus.minus 0.12$], [$0.05$], [$6560.26 plus.minus 1295.94$],
	      [$11$], [$5.2$], [$81.62 plus.minus 8.73$], [$3.5$], [$0.05$], [$0.62 plus.minus 0.10$], [$0.05$], [$6071.39 plus.minus 1202.90$],
	      [$10$], [$5.0$], [$78.48 plus.minus 8.40$], [$3.2$], [$0.05$], [$0.57 plus.minus 0.10$], [$0.05$], [$5773.02 plus.minus 1146.56$],
	      [$9$], [$5.0$], [$78.48 plus.minus 8.40$], [$7.5$], [$0.02$], [$0.53 plus.minus 0.09$], [$0.05$], [$5412.21 plus.minus 1063.96$],
	      [$8$], [$4.5$], [$70.63 plus.minus 7.59$], [$6.8$], [$0.02$], [$0.48 plus.minus 0.08$], [$0.05$], [$5452.30 plus.minus 1073.67$],
	      [$7$], [$4.3$], [$67.49 plus.minus 7.27$], [$5.3$], [$0.02$], [$0.38 plus.minus 0.06$], [$0.05$], [$4447.24 plus.minus 877.86$],
	      [$6$], [$3.5$], [$54.93 plus.minus 5.99$], [$5.0$], [$0.02$], [$0.36 plus.minus 0.06$], [$0.05$], [$5154.49 plus.minus 1021.63$],
	      [$5$], [$4.0$], [$62.78 plus.minus 6.79$], [$8.5$], [$0.01$], [$0.30 plus.minus 0.05$], [$0.05$], [$3833.65 plus.minus 755.45$]
      )
    ],
    caption: [Результаты наблюдений]
  ) <table:result_list>

  = Приложение E
    #figure(
      image("assets/source1.png", width: 90%),
      caption: [Результаты сбора данных №1]
    )

  = Приложение F
    #figure(
      image("assets/source2.png", width: 90%),
      caption: [Результаты сбора данных №2]
    )
]




