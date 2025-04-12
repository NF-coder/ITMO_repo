#set page(width: 20cm, height: 10cm, fill: color.hsv(260.82deg, 19.22%, 100%), margin: 15pt)
#set align(left + top)
= T35\*. Монотонность несобственного интеграла
*О монотонности несобственного интеграла*

Пусть $f, g in R_"loc" [a, b]$, причем

$ integral_a^b f d(x) in RR quad "и" quad integral_a^b g d(x) in RR. $

Если $f <= g$ на $[a, b]$, то

$ integral_a^b f d(x) <= integral_a^b g d(x). $

*Док-во:*

Для доказательства достаточно перейти к пределу при $omega -> b - 0$ в неравенстве, справедливом для интеграла Римана (теорема 95):

$ integral_a^omega f d(x) <= integral_a^omega g d(x). $