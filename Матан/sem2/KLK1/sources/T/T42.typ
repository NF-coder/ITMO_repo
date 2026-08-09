#set page(width: 20cm, height: 10.2cm, fill: color.hsv(260.82deg, 19.22%, 100%), margin: 15pt)
#set align(left + top)
= T42\*. Признак абсолютной сходимости для несобственного интеграла
*О сходимости абсолютно сходящегося интеграла*

Пусть $f in R_"loc" [a, b]$. Если интеграл от $f$ по $[a, b]$ сходится абсолютно, то он сходится.

*Док-во:*

Пусть $epsilon > 0$. Так как интеграл от $f$ по $[a, b]$ сходится абсолютно, то, согласно критерию Коши (теорема 124),

$ exists Delta : forall delta_1, delta_2 in (Delta, b) abs( integral_(delta_1)^(delta_2) abs(f) d(x) ) < epsilon. $

Но, согласно свойствам интеграла,

$ abs( integral_(delta_1)^(delta_2) f d(x) ) <= abs( integral_(delta_1)^(delta_2) abs(f) d(x) ) < epsilon, $

а значит, по критерию Коши (теорема 124), интеграл от $f$ по $[a, b]$ сходится.