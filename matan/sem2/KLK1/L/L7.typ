#set page(width: 20cm, height: 6.6cm, fill: color.hsv(300deg, 13.73%, 100%), margin: 15pt)
#set align(left + top)
= Л7\*. Соотношение верхних и нижних сумм Дарбу (об ограниченности сумм Дарбу)
\
*Об ограниченности сумм Дарбу*
Пусть $tau_1$ и $tau_2$ -- разбиения отрезка [a, b], тогда
$s_tau_1 (f) lt.eq S_tau_2 (f)$.\
*Док-во*\
Разбиение $tau = tau_1 union tau_2$ является разбиением отрезка [a, b], причем $tau_1 subset tau, tau_2 subset tau$. Пользуясь монотонностью сумм Дарбу, получим
$
  s_tau_1 (f) lt.eq s_tau (f) lt.eq S_tau (f) lt.eq S_tau_2 (f)
$
что и доказывает утверждение