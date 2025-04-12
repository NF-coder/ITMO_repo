#set page(width: 20cm, height: 7.4cm, fill: color.hsv(260.82deg, 19.22%, 100%), margin: 15pt)
#set align(left + top)
= T17\*. Связь модуля интеграла и интеграла от модуля
*О связи модуля интеграла и интеграла от модуля*
Пусть $f in R[a, b]$, тогда 
$
  abs(integral_a^b d space d(x)) lt.eq abs(integral_a^b abs(f) space d(x))
$
*Док-во:*
Интегрируемость функции $|f|$ известна из теоремы об арифмети-
ческих свойствах интегрируемых функций. Так как
$
  abs(sum_(i=1)^n f (xi_i) Delta x_i) lt.eq abs(sum_(i=1)^n abs(f (xi_i) Delta x_i))
$
то при $lambda(tau) -> 0$ получается требуемое.