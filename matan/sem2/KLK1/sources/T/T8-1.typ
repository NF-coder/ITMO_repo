#set page(width: 20cm, height: 7.5cm, fill: color.hsv(260.82deg, 19.22%, 100%), margin: 15pt)
#set align(left + top)
= T8.1\*. Следствие о пределах сумм Дарбу
\
Если $f in R[a, b]$, то
$
  lim_(lambda (tau) -> 0) s_tau (f) = 
  lim_(lambda (tau) -> 0) S_tau (f) =
  integral_a^b f space d(x)
$
*Док-во*\
Пользуясь предыдущим замечанием, имеем
$
  0 lt.eq S_tau (f) - integral_a^b f space d(x) lt.eq
  S_tau (f) - s_tau (f),

  space space space

  0 lt.eq integral_a^b f space d(x) - s_tau (f) lt.eq
  S_tau (f) - s_tau (f)
$
Остаётся применить критерий Дарбоу