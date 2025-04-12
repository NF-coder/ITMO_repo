#set page(width: 20cm, height: 9.4cm, fill: color.hsv(260.82deg, 19.22%, 100%), margin: 15pt)
#set align(left + top)
= T30\*. Вычисление длины кривой. Кривая задана параметрически
*О вычислении длины пути*

Пусть $gamma: [a, b] -> RR^2$ — гладкий путь, тогда

$ l_gamma = integral_a^b sqrt(x'(t)^2 + y'(t)^2) d (t). $

*Док-во.*

Так как $l'_gamma in C[a, b]$ и $l_gamma(a) = 0$, то, по формуле Ньютона–Лейбница (теорема 100),

$ l_gamma(t) = l_gamma(t) - l_gamma(a) = integral_a^t l'_gamma d (t). $

Так как $l_gamma = l_gamma(b)$, то

$ l_gamma = l_gamma(b) = integral_a^b l'_gamma d (t) = integral_a^b sqrt(x'^2(t) + y'^2(t)) d (t). $