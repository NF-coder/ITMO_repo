#set page(width: 20cm, height: 28cm, fill: color.hsv(260.82deg, 19.22%, 100%), margin: 15pt)
#set align(left + top)
= T18. Первая теорема о среднем
*Первая теорема о среднем*

Пусть $f, g in R[a, b]$, $g$ не меняет знак на $[a, b]$,  
$m = inf_(x in [a, b]) f(x)$, $M = sup_(x in [a, b]) f(x)$.  

Тогда:  
$ exists mu in [m, M]: integral_a^b f g space d(x) = mu integral_a^b g space d(x)$

Кроме того, если $f in C[a, b]$, то  
$ exists xi in [a, b]: integral_a^b f g space d(x) = f(xi) integral_a^b g space d(x).$

*Док-во.*

Пусть $g(x) >= 0$ при $x in [a, b]$, тогда  
$ m g(x) <= f(x)g(x) <= M g(x), quad x in [a, b] $

и, по теореме о монотонности интеграла (95),  
$ m integral_a^b g space d(x) <= integral_a^b f g space d(x) <= M integral_a^b g space d(x). $

Если $integral_a^b g space d(x) = 0$, то, согласно неравенству выше,  
$ integral_a^b f g space d(x) = 0, $

а значит равенство  
$ integral_a^b f g space d(x) = mu integral_a^b g space d(x) $

верно при любом $mu$.  

Если же $integral_a^b g space d(x) != 0$, то, так как $g >= 0$, выполнено (теорема 95), что $integral_a^b g space d(x) > 0$. Тогда положим:

$ mu = (integral_a^b f g space d(x)) / (integral_a^b g space d(x)) $

и из неравенств следует, что $mu in [m, M]$.

Если $f$ непрерывна, то по теореме Больцано-Коши:  
$ exists xi in [a, b]: f(xi) = mu. $

Поделив неравенство на интеграл, получаем:
$ m <= (integral_a^b f g space d(x))/(integral_a^b g space d(x)) <= M. $

Положим:
$ mu = (integral_a^b f g space d(x))/(integral_a^b g space d(x)), $
что доказывает первое утверждение теоремы.

Если $f in C[a, b]$, то по второй теореме Больцано-Коши (30) 
для $mu in [m, M]$ существует $xi in [a, b]$ такой, что:
$ f(xi) = mu, $ что то доказывает вторую часть теоремы.