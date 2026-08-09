#set page(width: 20cm, height: 9cm, fill: color.hsv(260.82deg, 19.22%, 100%), margin: 15pt)
#set align(left + top)
= T14\*. Линейность интеграла Римана
\
*О линейности интеграла Римана.* 

Пусть $f, g in R[a, b]$, тогда

$ integral_a^b (alpha f + beta g) space d(x) = alpha integral_a^b f space d(x) + beta integral_a^b g space d(x). $
*Док-во:*

То, что $alpha f + beta g in R[a, b]$, известно из теоремы об арифметических свойствах интегрируемых функций (92). Осталось лишь в равенстве

$ sum_(i=1)^n (alpha f(xi_i) + beta g(xi_i)) Delta x_i = alpha sum_(i=1)^n f(xi_i) Delta x_i + beta sum_(i=1)^n g(xi_i) Delta x_i $

перейти к пределу при $lambda(tau) -> 0$, откуда и получим требуемое