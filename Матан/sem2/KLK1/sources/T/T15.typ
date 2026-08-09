#set page(width: 20cm, height: 10cm, fill: color.hsv(260.82deg, 19.22%, 100%), margin: 15pt)
#set align(left + top)
= T15\*. Аддитивность по промежутку интеграла Римана
\
*Об аддитивности по промежутку.* 

Пусть $f in R[a, b], c in [a, b]$, тогда

$ integral_a^b f space d(x) = integral_a^c f space d(x) + integral_c^b f space d(x). $
*Док-во:*

Интегрируемость функции $f$ на промежутках $[a, c]$ и $[c, b]$ известна из ранее доказанной теоремы (90). Значит, для вычисления интеграла мы можем брать удобное для нас разбиение. Пусть $tau$ — разбиение отрезка $[a, b]$, содержащее точку $c$. Это разбиение порождает разбиения $tau_1$ отрезка $[a, c]$ и $tau_2$ отрезка $[c, b]$, причем $lambda(tau_1) <= lambda(tau)$ и $lambda(tau_2) <= lambda(tau)$. Так как

$ sum_([a, b]) f(xi_i) Delta x_i = sum_([a, c]) f(xi_i) Delta x_i + sum_([c, b]) f(xi_i) Delta x_i, $

и при $lambda(tau) -> 0$ одновременно $lambda(tau_1) -> 0$ и $lambda(tau_2) -> 0$, то получаем требуемое.