#set page(width: 20cm, height: 7cm, fill: color.hsv(260.82deg, 19.22%, 100%), margin: 15pt)
#set align(left + top)
= T16\*. Монотонность интеграла Римана
\
*О монотонности интеграла*
Пусть $f, g in R[a,b]$, $a lt.eq b$ и $f(x) lt.eq g(x)$ при $ x in [a,b]$. Тогда
$
  integral_a^b f space d(x) lt.eq integral_a^b g space d(x)
$
*Док-во*
Для интегральных сумм справедливо следующее неравенство
$
  sum_(i=1)^n f (xi_i) Delta x_i lt.eq sum_(i=1)^n g (x_i) Delta x_i 
$
Переходя к пределу при $lambda (tau) -> 0$ получим требуемое