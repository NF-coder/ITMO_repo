#set page(width: 20cm, height: 20.5cm, fill: color.hsv(260.82deg, 19.22%, 100%), margin: 15pt)
#set align(left + top)
= T22. Усиленная формула Ньютона-Лейбница
*Усиленная формула Ньютона–Лейбница*

Пусть $f in R[a, b]$ и $F$ — некоторая первообразная $f$ на $[a, b]$. Тогда:

$ integral_a^b f space d (x) = F(b) - F(a). $

*Док-во.*

Введем следующее разбиение отрезка $[a, b]$:

$ x_k = a + k(b-a)/(n), quad k in {0, 1, dots, n}. $

Пусть $F$ — какая-то первообразная $f$ на $[a, b]$. Тогда

$ F(b) - F(a) = F(x_n) - F(x_0) = sum_(k=1)^n (F(x_k) - F(x_(k-1))). $

Согласно теореме Лагранжа (56), существует $xi_k^n in (x_(k-1), x_k)$, что

$ F(x_k) - F(x_(k-1)) = f(xi_k^n)(x_k - x_(k-1)), $

а тогда

$ F(b) - F(a) = sum_(k=1)^n f(xi_k^n) Delta x_k, $

и мы получаем интегральную сумму для функции $f$ по отрезку $[a, b]$ с оснащенным разбиением $(tau^n, xi^n)$.

Так как $f in R[a, b]$ и так как при $n -> infinity$ выполняется $lambda(tau^n) -> 0$, то

$ lim_(n->infinity) sum_(k=1)^n f(xi_k^n) Delta x_k = integral_a^b f space d (x). $

С другой стороны,

$ F(b) - F(a) = lim_(n->infinity) sum_(k=1)^n f(xi_k^n) Delta x_k, $

а значит

$ integral_a^b f space d (x) = F(b) - F(a). $