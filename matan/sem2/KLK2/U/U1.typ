#set page(width: 20cm, height: auto, fill: color.hsl(0deg, 0%, 82.75%, 63.6%), margin: 15pt)
#set align(left + top)
= +Unspecified1. Ряд Фурье по произвольному промежутку длины 2L

До сих пор мы рассматривали $2 pi$-периодические функции, заданные на отрезке $[-pi, pi]$. Но что, если период у функции другой? Предположим, что функция $f$ задана на промежутке $[-l, l]$ и периодически продолжена на $RR$. Легко понять, что если $x in [-l, l]$, то

$ y = pi/l x in [-pi, pi] $

Значит, функции $f$ можно сопоставить ряд Фурье

$ (a_0 (f))/2 + sum_(k=1)^infinity (
  a_k (f) cos (pi k x)/l + 
  b_k (f) sin (pi k x)/l
) $

где

$ a_k (f) = 1/l integral_(-l)^l f(x) cos (pi k x)/l d x quad k in NN union {0} $

$ b_k (f) = 1/l integral_(-l)^l f(x) sin (pi k x)/l d x  quad k in NN $

Все сформулированные ранее результаты сохраняются с точностью до замены отрезка (или интервала) с концами $plus.minus pi$ на отрезок (или интервал) с концами $plus.minus l$.