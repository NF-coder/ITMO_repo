#set page(width: 20cm, height: 22cm, fill: color.hsv(260.82deg, 19.22%, 100%), margin: 15pt)
#set align(left + top)
= T3\*. Линейность неопределённого интеграла
\
*О линейности неопределенного интеграл*
Пусть на ⟨a, b⟩ существуют первообразные функций $f$ и $g$. Тогда:
#set align(center)
1. На ⟨a, b⟩ существует первообразная функции $f + g$, причем
$
  integral (f + g) space d(x) = integral f space d(x) +  integral g space d(x)
$
2. На ⟨a, b⟩ существует первообразная функции $alpha f, alpha in RR$, причем при $alpha eq.not 0$
$
  integral alpha f space d(x) = alpha integral f space d(x)
$
3. На ⟨a, b⟩ существует первообразная функции $alpha f + beta g, alpha, beta in RR$, причем при $alpha^2 + beta^2 eq.not 0$
$
  integral ( alpha f + beta g) space d(x) = alpha integral f space d(x) + beta integral g space d(x)
$
#set align(left + top)
*Док-во*
1. Докажем первый пункт. Понятно, что по свойству производной суммы, F + G — первообразная $f + g$. Значит, достаточно проверить равенство
$
  {F + G + C, C in RR} = {F + C_1, C_1 in RR} + {G + C_2, C_2 in RR}
$
Пусть $H in {F + G + C, C in RR}$, тогда
$
  H = F + G + C = (F + 0) + (G + C)
$
а значит $H in {F + C_1, C_1 in R} + {G + C_2, C_2 in RR} " при " C_1 = 0, C_2 = C$.\
#set align(center)
Наоборот, пусть $H in {F + C_1, C_1 in RR} + {G + C_2, C_2 in RR}$, то есть
$
  H = F + C_1 + G + C_2 = F + G + (C_1 + C_2)
$
#set align(left + top)
Тогда и $H in {F + G + C, C in R}$ при $C = C_1 + C_2$. Тем самым, равенство множеств
установлено.
2. Докажем второй пункт. Понятно, что по свойству производной, $alpha F$ — первообразная для $alpha f$ . Значит, достаточно показать, что при $alpha eq.not 0$ верно равенство
$
  {alpha F + C, C in RR} = {alpha F + alpha C_1, C_1 in RR}
$
Если $H in {alpha F + C, C in RR}$, то
$
  H = alpha F + C = alpha F + alpha space C/alpha
$
откуда $H in {alpha F + alpha C_1, C_1 in RR}" при "C_1 = C/alpha$. Обратное включение доказывается похожим образом и остается в качестве упражнения.
3. Доказательство третьего пункта немедленно следует из утверждений 1-ого и 2-ого пунктов.