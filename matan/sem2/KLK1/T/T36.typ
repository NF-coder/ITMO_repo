#set page(width: 20cm, height: 11.2cm, fill: color.hsv(260.82deg, 19.22%, 100%), margin: 15pt)
#set align(left + top)
= T36\*. Интегрирование по частям в несобственном интеграле
*Формула интегрирования по частям*

Пусть $u, v$ дифференцируемы на $[a, b]$ и $u', v' in R_"loc" (a, b)$. Тогда

$ integral_a^b u v' d(x) = u v|_a^b - integral_a^b v u' d(x), quad u v|_a^b = lim_(omega->b-0) u(omega)v(omega) - u(a)v(a), $

или

$ integral_a^b u d(v) = u v|_a^b - integral_a^b v d(u), $

причем равенство справедливо тогда и только тогда, когда существует (в $RR$) хотя бы два предела из трех.

*Док-во:*

Для доказательства достаточно перейти к пределу при $omega -> b-0$ в верном для интеграла Римана (теорема 102) равенстве:

$ integral_a^omega u v' d(x) = u v|_a^omega - integral_a^omega v u' d(x). $