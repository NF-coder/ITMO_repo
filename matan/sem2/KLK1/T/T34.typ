#set page(width: 20cm, height: 10.6cm, fill: color.hsv(260.82deg, 19.22%, 100%), margin: 15pt)
#set align(left + top)
= T34\*. Аддитивность по промежутку несобственного интеграла
*Об аддитивности по промежутку*

Пусть $f in R_"loc" [a, b]$. Тогда для любого $c in (a, b)$ справедливо равенство

$ integral_a^b f d(x) = integral_a^c f d(x) + integral_c^b f d(x), $

причем интегралы

$ integral_a^b f d(x) quad "и" quad integral_c^b f d(x) $
сходятся или нет одновременно.

*Док-во*

Для доказательства достаточно перейти к пределу при $omega -> b - 0$ в равенстве, справедливом для интеграла Римана (теорема 94):

$ integral_a^omega f d(x) = integral_a^c f d(x) + integral_c^omega f d(x). $