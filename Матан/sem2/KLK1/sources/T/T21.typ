#set page(width: 20cm, height: 14.5cm, fill: color.hsv(260.82deg, 19.22%, 100%), margin: 15pt)
#set align(left + top)
= T21. Формула Ньютона-Лейбница для непрерывных функций
*Формула Ньютона-Лейбница для непрерывных функций*

Пусть $f in C[a, b]$ и $F$ — ее первообразная. Тогда:

$ integral_a^b f space d (x) = F(b) - F(a). $

*Док-во.*

Согласно следствию 29 о существовании первообразной непрерывной функции, любая первообразная непрерывной функции имеет вид:

$ F(x) = integral_a^x f space d(t) + C. $

Подставим $x = a$:
$ F(a) = integral_a^a f space d (x) + C => C = F(a). $

Таким образом:
$ F(x) = integral_a^x f space d(t) + F(a). $

Подставив $x = b$, получаем:
$ F(b) = integral_a^b f space d (x) + F(a) => integral_a^b f space d (x) = F(b) - F(a). $