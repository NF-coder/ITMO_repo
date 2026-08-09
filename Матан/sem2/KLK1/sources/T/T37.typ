#set page(width: 20cm, height: 22.3cm, fill: color.hsv(260.82deg, 19.22%, 100%), margin: 15pt)
#set align(left + top)
= T37\*. Замена переменной в несобственном интеграле
*Формула замены переменной*

Пусть $f in C[A, B)$, $x = phi(t): [alpha, beta] -> [A, B)$, $phi$ дифференцируема и $phi' in R_"loc" [alpha, beta]$. Пусть, кроме того, существует $phi(beta - 0) in RR$. Тогда

$ integral_(phi(alpha))^(phi(beta-0)) f d(x) = integral_alpha^beta f(phi) phi' d(t), $

причем если существует один интеграл (в $overline(RR)$), то существует и другой.

*Док-во:*

Обозначим

$ Phi(gamma) = integral_alpha^gamma f(phi)phi' d(t), quad F(C) = integral_(phi(alpha))^C f d(x). $

Согласно формуле замены переменной в интеграле Римана (теорема 103), $Phi(gamma) = F(phi(gamma))$, $gamma in (alpha, beta)$.

1. Пусть существует

$ integral_(phi(alpha))^(phi(beta-0)) f d(x) = I in RR. $

Докажем, что второй интеграл тоже существует и равен $I$. Пусть $gamma_n in [alpha, beta)$, причем $gamma_n ->_(n->infinity) beta$. Тогда $phi(gamma_n) in [A, B)$ и $phi(gamma_n) ->_(n->infinity) phi(beta - 0)$. Значит,

$ lim_(n->infinity) Phi(gamma_n) = lim_(n->infinity) F(phi(gamma_n)) = I. $

В силу произвольности последовательности $gamma_n$, приходим к требуемому.

2. Пусть теперь существует

$ integral_alpha^beta f(phi)phi' d(t) = I in RR. $

Докажем, что второй интеграл тоже существует. Тогда, по уже доказанному в первом пункте, он равен $I$. Если $phi(beta - 0) in [A, B)$, то интеграл существует в собственном смысле, и доказывать нечего. Пусть теперь $phi(beta - 0) = B$. Пусть $C_n in [A, B)$, $C_n ->_(n->infinity) B$. Не нарушая общности можно считать, что $C_n in [phi(alpha), B)$. По теореме Больцано-Коши, найдутся точки $gamma_n in [alpha, beta)$, что $phi(gamma_n) = C_n$. Покажем, что $gamma_n ->_(n->infinity) beta$.

Если некоторая подпоследовательность $gamma_(n_k) ->_(k->infinity) tau in [alpha, beta)$, то, по непрерывности $phi$, $phi(gamma_(n_k)) ->_(k->infinity) phi(tau) < B$, что неверно. Значит, $gamma_n ->_(n->infinity) beta$ и

$ lim_(n->infinity) F(C_n) = lim_(n->infinity) Phi(gamma_n) = I. $