#set page(width: 20cm, height: 11.6cm, fill: color.hsv(260.82deg, 19.22%, 100%), margin: 15pt)
#set align(left + top)
= T9. Связь интегрируемости и непрерывности
\
*Об интегрируемости непрерывной функции*

$ f in C[a, b] => f in R[a, b]. $

*Док-во.*

Пусть $epsilon > 0$. Согласно теореме Кантора (47), непрерывная на отрезке функция равномерно непрерывна на нем, а значит

$ exists delta > 0 : forall x_1, x_2 in [a, b] : |x_1 - x_2| < delta |f(x_1) - f(x_2)| < epsilon/(b - a). $

Пусть $tau$ — такое разбиение отрезка $[a, b]$, что $lambda(tau) < delta$, тогда

$ omega(f, Delta_i) = sup_(x, y in Delta_i) |f(x) - f(y)| < epsilon/(b - a) $

и

$ sum_(i=1)^n omega(f, Delta_i) Delta x_i < epsilon/(b - a) sum_(i=1)^n Delta x_i = epsilon. $

Значит, по следствию из критерия Дарбу, $f in R[a, b]$.
