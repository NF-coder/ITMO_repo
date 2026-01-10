#let frame(stroke) = (x, y) => (
  left: if x > 0 { 0pt } else { stroke },
  right: stroke,
  top: if y < 1 { stroke } else { 0pt },
  bottom: stroke,
)

* Задание 1.1 * \
Пусть
$
  g(t) = cases(
    2 quad t in [4, 8],
    0 quad t in.not [4, 8]
  )\
  u(t) = g(t) + 1 dot xi(t) + 0 dot sin (10 dot t)\

  a = 2, space t_1 = 4, space t_2 = 8, space b = 1, space c = 0, space d = 10
$

Применятеся фильтр первого порядка с формулой
$
  W_1(p)=1/(T_p+1)
$

Выводы:
1. #block[
  Фильтр первого порядка
  $W_1(p)=1/(T_p+1)$
  является низкочастотным, подавляющим высокочастотные шумовые компоненты сигнала.
]
2. #block[
  При малых значениях $T$ фильтрация выражена слабо: сигнал сохраняет шум, но форма исходного сигнала практически не искажается.
]
3. #block[
  При увеличении $T$ шум эффективно подавляется, однако наблюдаются сглаживание фронтов сигнала, уменьшение его амплитуды и задержка по времени 
]
4. #block[
  Увеличение параметра $a$ (амплитуды полезного сигнала) улучшает отношение сигнал/шум и повышает эффективность фильтрации.
]

#figure(
  table(
    columns: 2,
    stroke: frame(1pt + rgb("#4e4e4e")),
    [#image("../t1.1-1/signals_1.1_(T=0.1,a=2).svg", width: 95%)],
    [#image("../t1.1-1/signals_1.1_(T=0.3,a=2).svg", width: 95%)],
    [#image("../t1.1-1/signals_1.1_(T=0.6,a=2).svg", width: 95%)],
    [#image("../t1.1-1/signals_1.1_(T=1,a=2).svg", width: 95%)],
    [#image("../t1.1-1/signals_1.1_(T=2,a=2).svg", width: 95%)],
    [#image("../t1.1-1/signals_1.1_(T=3,a=2).svg", width: 95%)],
  ),
  caption: [Сравнительные графики при фиксированом $a$, но различных $T$],
)

#figure(
  table(
    columns: 2,
    stroke: frame(1pt + rgb("#4e4e4e")),
    [#image("../t1.1-2/signals_1.1_(T=0.6,a=0.1).svg", width: 95%)],
    [#image("../t1.1-2/signals_1.1_(T=0.6,a=0.5).svg", width: 95%)],
    [#image("../t1.1-2/signals_1.1_(T=0.6,a=1).svg", width: 95%)],
    [#image("../t1.1-2/signals_1.1_(T=0.6,a=2).svg", width: 95%)],
    [#image("../t1.1-2/signals_1.1_(T=0.6,a=3).svg", width: 95%)],
    [#image("../t1.1-2/signals_1.1_(T=0.6,a=6).svg", width: 95%)],
  ),
  caption: [Сравнительные графики при фиксированом $a$, но различных $T$],
)