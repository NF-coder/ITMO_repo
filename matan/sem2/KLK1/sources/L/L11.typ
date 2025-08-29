#set page(width: 20cm, height: 16.3cm, fill: color.hsv(300deg, 13.73%, 100%), margin: 15pt)
#set align(left + top)
= Л11\*. Критерий сходимости несобственного интеграла в терминах остатка

Пусть $f in R_"loc" [a, b]$, $c in (a, b)$. Тогда сходимость несобственного интеграла от $f$ по $[a, b)$ равносильна тому, что

$ lim_(c -> b-0) integral_c^b f d(x) = 0. $

*Док-во:*

Докажем _необходимость_. Пусть несобственный интеграл от $f$ по $[a, b)$ сходится. Тогда, по теореме об аддитивности по промежутку (теорема 94),

$ integral_a^b f d(x) = integral_a^c f d(x) + integral_c^b f d(x). $

Пусть теперь $c -> b-0$, тогда

$ lim_(c -> b-0) integral_a^c f d(x) = integral_a^b f d(x), $

откуда и следует требуемое.

Докажем _достаточность_. Пусть остаток интеграла стремится к нулю. Значит, при некотором $c in (a, b)$

$ integral_c^b f d(x) in RR. $

Но тогда, при $omega > c$ выполнено

$ integral_a^omega f d(x) = integral_a^c f d(x) + integral_c^omega f d(x) $

и при $omega -> b-0$ приходим к требуемому.