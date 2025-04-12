#set page(width: 20cm, height: 18cm, fill: color.hsv(260.82deg, 19.22%, 100%), margin: 15pt)
#set align(left + top)
= T25\*. Интеграл Римана от чётной и нечётной функций по симметричному промежутку
*25.1 Об интеграле от четной функции по симметричному промежутку*

Пусть $f in R[0, a]$ и является четной. Тогда:

$ integral_(-a)^a f space d (x) = 2 integral_0^a f space d (x). $

*Док-во:*

Так как $f(-x) = f(x)$, то, по теореме 90, $f in R[-a, a]$. Пользуясь аддитивностью интеграла по промежутку (теорема 94), получим:

$ integral_(-a)^a f space d (x) = integral_(-a)^0 f space d (x) + integral_0^a f space d (x). $

В первом интеграле можно сделать замену $t = -x$, $d (t) = -space d (x)$, откуда

$ integral_(-a)^0 f(x) space d (x) = -integral_a^0 f(-t) d (t) = integral_0^a f(t) d (t). $

Значит,

$ integral_(-a)^a f space d (x) = integral_0^a f d (t) + integral_0^a f space d (x) = 2 integral_0^a f space d (x). $

*25.2 Об интеграле от нечетной функции по симметричному промежутку*

Пусть $f in R[0, a]$ и является нечетной. Тогда:

$ integral_(-a)^a f space d (x) = 0. $

*Док-во:*

Доказательство данной теоремы аналогично доказательству предыдущей и остается в качестве упражнения.