#set page(width: 20cm, height: 19.4cm, fill: color.hsv(260.82deg, 19.22%, 100%), margin: 15pt)
#set align(left + top)
= T28\*. Достаточное условие спрямляемости пути
*Достаточное условие спрямляемости пути*

Пусть $gamma$ — гладкий путь, тогда он спрямляем.

*Док-во:*

Пусть $tau$ — разбиение отрезка $[a,b]$. Длина ломаной, вписанной в путь $gamma$, равна

$ abs(s_tau) = sum_(i=1)^n sqrt((x(t_i) - x(t_(i-1)))^2 + (y(t_i) - y(t_(i-1)))^2). $

По теореме Лагранжа (теорема 56), найдутся точки $xi_i, tau_i in [t_(i-1), t_i], i in {1, 2, dots, n}$, что

$ x(t_i) - x(t_(i-1)) = x'(xi_i)Delta t_i, quad y(t_i) - y(t_(i-1)) = y'(eta_i)Delta t_i, quad Delta t_i = t_i - t_(i-1), $

откуда

$ abs(s_tau) = sum_(i=1)^n sqrt(x'(xi_i)^2 + y'(eta_i)^2)Delta t_i. $

Пусть

$ M_x = max_(t in [a,b]) abs(x'(t)), quad M_y = max_(t in [a,b]) abs(y'(t)), $

$ m_x = min_(t in [a,b]) abs(x'(t)), quad m_y = min_(t in [a,b]) abs(y'(t)), $

тогда

$ sum_(i=1)^n sqrt(m_x^2 + m_y^2)Delta t_i <= abs(s_tau) <= sum_(i=1)^n sqrt(M_x^2 + M_y^2)Delta t_i, $

откуда

$ sqrt(m_x^2 + m_y^2)(b-a) <= abs(s_tau) <= sqrt(M_x^2 + M_y^2)(b-a). $

Переходя к супремуму по $tau$, имеем

$ sqrt(m_x^2 + m_y^2)(b-a) <= l_gamma <= sqrt(M_x^2 + M_y^2)(b-a). $

и правое неравенство дает возможность заключить, что путь спрямляем.