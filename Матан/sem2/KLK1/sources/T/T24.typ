#set page(width: 20cm, height: 9.2cm, fill: color.hsv(260.82deg, 19.22%, 100%), margin: 15pt)
#set align(left + top)
= T24\*. Замена переменной в интеграле Римана
*Формула замены переменной*

Пусть $f in C[a, b]$, $x = phi(t): [alpha, beta] -> [a, b]$, 
$phi$ дифференцируема и $phi' in R[alpha, beta]$.

Тогда:

$ integral_(phi(alpha))^(phi(beta)) f space d(x) = integral_alpha^beta f(phi) phi' d(t). $

*Док-во:*

Ясно, что интеграл от правой функции определен, ведь $f circle.small phi in C[alpha, beta]$, 
а значит $f(phi) in R[alpha, beta]$ и, по свойствам интегрируемых функций, 
$f(phi) phi' in R[alpha, beta]$. Кроме того, если $F$ — первообразная $f$ на $[a, b]$, то $F(phi)$ -- первообразная $f(phi) phi'$ на $[alpha, beta]$. Тогда, по усиленной формуле Ньютона-Лейбница (101),

$ integral_alpha^beta f(phi) phi' space d(t) = F(phi(beta)) - F(phi(alpha)) = 
integral_(phi(alpha))^(phi(beta)) f space d(x). $