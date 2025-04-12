#set page(width: 20cm, height: 29cm, fill: color.hsv(260.82deg, 19.22%, 100%), margin: 15pt)
#set align(left + top)
= T8. Критерий существования интеграла Римана (Дарбу)
\
*Критерий Дарбу*

$ f in R[a, b] <=> lim_(lambda(tau) -> 0) (s_tau ( f) - s_tau  (f)) = 0, $
или, что то же самое,
$ forall epsilon > 0 exists delta > 0 : forall tau : lambda(tau) < delta s_tau (f) - s_tau (f) < epsilon. $

*Док-во.*

Докажем _необходимость_. Пусть функция $f$ интегрируема на отрезке $[a, b]$ и $epsilon > 0$. Тогда

$ exists delta > 0 : forall (tau, xi) : lambda(tau) < delta |sigma_tau (f, xi) - I| < epsilon/(3), $

откуда

$ I - epsilon/(3) < sigma_tau (f, xi) < I + epsilon/(3). $

Переходя в правой части неравенства к супремуму, а в левой части к инфимуму по $xi$, получаем (лемма 70 (Связь сумм Дарбу и интегральных сумм))

$ I - epsilon/3 <= s_tau (f), quad s_tau (f) <= I + epsilon/3. $

Складывая неравенства

$ -s_tau (f) <= epsilon/3 - I, quad s_tau (f) <= I + epsilon/3, $

приходим к тому, что

$ s_tau (f) - s_tau (f) <= (2epsilon)/3 < epsilon. $

Докажем _достаточность_. Так как $lim_(lambda(tau) -> 0) (s_tau (f) - s_tau (f)) = 0$, то все верхние и нижние суммы Дарбу конечны. В силу леммы 72 (Соотношение верхних и нижних сумм Дарбу (об ограниченности сумм Дарбу)),

$ sup_tau s_tau (f) = I_* < +infinity, quad inf_tau s_tau (f) = I^* < +infinity, $

причем $I_* <= I^*$. Пользуясь сказанным и тем, что для любого $tau$

$ s_tau (f) <= I_* <= I^* <= s_tau (f), $

получим

$ 0 <= I^* - I_* <= s_tau (f) - s_tau (f), $

откуда, так как правая часть принимает сколь угодно малые значения (следствие 9), $I_* = I^*$. Пусть $I = I_* = I^*$. Из неравенств

$ s_tau (f) <= I <= s_tau (f), quad s_tau (f) <= sigma_tau(f, xi) <= s_tau (f), $

получаем

$ |sigma_tau(f, xi) - I| <= s_tau (f) - s_tau (f). $

Осталось воспользоваться утверждением критерия Дарбу и заметить, что мы приходим к тому, что
$
  integral_a^b f space d(x) = I
$
что и доказывает утверждение.