#set page(width: 20cm, height: 10cm, fill: color.hsv(260.82deg, 19.22%, 100%), margin: 15pt)
#set align(left + top)
= T33\*. Линейность несобственного интеграла
*О линейности несобственного интеграла*

Пусть $f in R_("loc") [a, b]$. Если сходятся интегралы

$ integral_a^b f d(x) quad "и" quad integral_a^b g d(x), $

то

$ integral_a^b (alpha f + beta g) d(x) = alpha integral_a^b f d(x) + beta integral_a^b g d(x). $

*Док-во:*

Для доказательства достаточно перейти к пределу при $omega -> b - 0$ в равенстве, справедливом для интеграла Римана (теорема 93):

$ integral_a^omega (alpha f + beta g) d(x) = alpha integral_a^omega f d(x) + beta integral_a^omega g d(x). $