#set page(width: 20cm, height: 18cm, fill: color.hsv(300deg, 13.73%, 100%), margin: 15pt)
#set align(left + top)
= Л5\*. Связь сумм Дарбу и интегральных сумм
\
*О связи сумм Дарбу и интегральных сумм*
Справедливы равенства
$
  S_tau (f) = sup_xi sigma_tau (f, xi), space space s_tau (f) = inf_xi sigma_tau (f, xi)
$
*Док-во*\
Докажем первое равенство. Рассмотрим сначала случай, когда
функция f ограничена сверху на [a, b]. Пусть $epsilon$ > 0, тогда, по определению супремума,
$
  exists xi_i in Delta_i: M_i - epsilon/(b-a) < f(xi_i), space space i in {1,2, dots, n}
$
Домножим каждое неравенство на $Delta x_i$ и сложим по $i$, получим
$
  sum_(i=1)^n ( M_i - epsilon/(b-a) ) Delta x_i < sum_(i=1)^n f(xi_i) Delta x_i
$
или
$
 sum_(i=1)^n M_i Delta x_i - epsilon < sigma_tau (f, xi) <=> S_tau (f) - epsilon < sigma_tau (f, xi)
$
Так как, как уже отмечалось, $S_tau (f) gt.eq sigma_tau (f, xi)$, то в итоге проверено, что
$
  S_tau (f) = sup_xi sigma_tau (f, xi)
$
Пусть теперь $f$ не ограничена сверху на [a, b], тогда $S_tau (f) = +infinity$. Ясно, что при фиксированном разбиении $tau$ функция $f$ не ограничена сверху хотя бы на одном отрезке разбиения $Delta_i$. Не нарушая общности можно считать, что она не ограничена на $Delta_1$. Тогда существует последовательность $xi^k_1$, что $f(xi^k_1) -->_(k->infinity) +infinity$. Пусть $xi_i in Delta_i$, $i in {2, dots, n}$, -- какие-то фиксированные точки, $xi^k = {xi^k_1, xi^k_2, dots, xi^k_n}$. Тогда, в силу определения супремума,
$
 sup_xi sigma_tau (f, xi) gt.eq lim_(k->infinity) ( f(xi^k_1) Delta x_1 + sum_(i=2)^n f(xi_i) Delta x_i ) = +infinity = S_tau (f)
$