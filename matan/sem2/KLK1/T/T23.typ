#set page(width: 20cm, height: 10.6cm, fill: color.hsv(260.82deg, 19.22%, 100%), margin: 15pt)
#set align(left + top)
= T23\*. Интегрирование по частям в интеграле Римана
*Формула интегрирования по частям*
Пусть $u, v$ дифференцируемы на $[a, b]$, причем $u', v' in R[a, b]$. Тогда:

$ integral_a^b u v' space d(x) = u v|_a^b - integral_a^b v u' space d(x) $
или
$ integral_a^b u space d(v) = u v|_a^b - integral_a^b v space d(u) $

*Док-во.*

Согласно свойствам интегрируемых функций, $u v' in R[a,b]$ и $u'v in R[a,b]$. Кроме того, $(u v)' = u'v + u v' in R[a,b]$, а значит, по усиленной формуле Ньютона-Лейбница (101),

$ integral_a^b u'v space d(x) + integral_a^b u v' space d(x) = integral_a^b (u'v + u v') space d(x) = integral_a^b (u v)' space d(x) = u v|_a^b, $

откуда и следует утверждение. 