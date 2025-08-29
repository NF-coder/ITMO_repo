#set page(width: 20cm, height: 26.6cm, fill: color.hsv(260.82deg, 19.22%, 100%), margin: 15pt)
#set align(left + top)
= T29. Вычисление длины пути
*29.1 О гладкости длины участка пути*

Пусть $gamma: [a, b] -> RR^2$ — гладкий путь. Тогда $L_gamma in C^1[a, b]$, причем

$ L_gamma'(t) = sqrt(x'(t)^2 + y'(t)^2). $

*Док-во:*

Пусть $Delta t > 0$, причем $t_0, t_0 + Delta t in [a, b]$. Согласно последнему неравенству в доказательстве предыдущей теоремы, сохраняя те же обозначения, на отрезке $[t_0, t_0 + Delta t]$ выполнено

$ sqrt(m_x^2 + m_y^2) Delta t <= l_gamma(t_0 + Delta t) - l_gamma(t_0) <= sqrt(M_x^2 + M_y^2) Delta t. $

Поделив неравенство на $Delta t > 0$, получим

$ sqrt(m_x^2 + m_y^2) <= (l_gamma(t_0 + Delta t) - l_gamma(t_0)) / (Delta t) <= sqrt(M_x^2 + M_y^2). $

Так как $M_x = max_(t in [t_0, t_0 + Delta t]) abs(x'(t))$, и функция $x'(t)$ непрерывна, то

$ lim_(Delta t -> 0+0) M_x = x'(t_0). $

Аналогично,

$ lim_(Delta t -> 0+0) m_x = x'(t_0), quad lim_(Delta t -> 0+0) M_y = y'(t_0), quad lim_(Delta t -> 0+0) m_y = y'(t_0). $

Значит,

$ sqrt(x'(t_0)^2 + y'(t_0)^2) <= lim_(Delta t -> 0+0) (l_gamma(t_0 + Delta t) - l_gamma(t_0)) / (Delta t) <= sqrt(x'(t_0)^2 + y'(t_0)^2) $

и

$ l_(gamma+) ' (t_0) = sqrt(x'(t_0)^2 + y'(t_0)^2). $

Аналогично рассматривается случай $Delta t < 0$. Значит, в силу произвольности $t_0$,

$ l_gamma ' (t)  = sqrt(x'(t)^2 + y'(t)^2). $

*29.2 О вычислении длины пути*

Пусть $gamma: [a, b] -> RR^2$ — гладкий путь, тогда

$ l_gamma = integral_a^b sqrt(x'(t)^2 + y'(t)^2) d (t). $

*Док-во.*

Так как $l'_gamma in C[a, b]$ и $l_gamma(a) = 0$, то, по формуле Ньютона–Лейбница (теорема 100),

$ l_gamma(t) = l_gamma(t) - l_gamma(a) = integral_a^t l'_gamma d (t). $

Так как $l_gamma = l_gamma(b)$, то

$ l_gamma = l_gamma(b) = integral_a^b l'_gamma d (t) = integral_a^b sqrt(x'^2(t) + y'^2(t)) d (t). $