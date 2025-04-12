#set page(width: 20cm, height: 14.5cm, fill: color.hsv(300deg, 13.73%, 100%), margin: 15pt)
#set align(left + top)
= Л6\*. Монотонность сумм Дарбу
\
*О монотонности сумм Дарбу*
Пусть $tau_2 subset tau_1$, тогда
$
  S_tau_2 (f ) ≥ S_tau_1 (f), space space s_tau_1 (f) gt.eq s_tau_2 (f)
$
*Док-во*
Докажем первое неравенство. Достаточно рассмотреть случай, когда измельчение $tau_1$ получается из $tau_2$ добавлением одной точки  $hat(x) in Delta_k = (x_(k−1), x_k).$

$
 S_(tau_2)(f) = sum_(i=1)^n M_i Delta x_i = sum_(i=1, i != k)^n M_i Delta x_i + M_k Delta x_k
$

Пусть

$ M'_k = sup_(x in [x_(k-1), hat(x)]) f(x), quad M''_k = sup_(x in [hat(x), x_k]) f(x), $

тогда

$ M_k >= M'_k, quad M_k >= M''_k $

и

$ M_k Delta x_k = M_k (hat(x) - x_(k-1)) + M_k (x_k - hat(x)) >= M'_k (hat(x) - x_(k-1)) + M''_k (x_k - hat(x)), $

откуда

$ S_(r_2)(f) >= sum_(i=1, i != k)^n M_i Delta x_i + M'_k (hat(x) - x_(k-1)) + M''_k (x_k - hat(x)) = S_(r_1)(f). $
Второе неравенство доказывается аналогично.