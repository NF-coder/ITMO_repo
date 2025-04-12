#set page(width: 20cm, height: 7cm, fill: color.hsv(300deg, 13.73%, 100%), margin: 15pt)
#set align(left + top)
= Л8\*\*. Длины эквивалентных путей
\
*О длинах эквивалентных путей*
Длины эквивалентных путей равны\
*Док-во*\
Пусть путь $gamma: [a, b] -> RR^n$ эквивалентен пути $tilde(gamma): [alpha, beta] -> RR^n$,  
$u: [a, b] -> [alpha, beta]$ — возрастающая биекция. Пусть $tau = {t_i}_(i=0)^k$ — дробление $[a, b]$, тогда  
$tilde(t_k) = u(t_k)$ — дробление $[alpha, beta]$. Значит,

$ s_(tilde(gamma)) = sum_(k=1)^n abs(tilde(gamma)(tilde(t_k)) - tilde(gamma)(tilde(t_(k-1)))) = sum_(k=1)^n abs(gamma(t_k) - gamma(t_(k-1))) = s_gamma <= l_gamma, $

и, тем самым, $l_tilde(gamma) <= l_gamma $. Меняя $gamma$ и $l_tilde(gamma)$ местами, проводя аналогичные приведенным выше выкладки, придем к неравенству $l_gamma <= l_tilde(gamma) $, откуда $l_gamma = l_tilde(gamma) $