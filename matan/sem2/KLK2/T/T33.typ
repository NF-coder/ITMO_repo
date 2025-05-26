#set page(width: 20cm, height: auto, fill: color.hsl(253.71deg, 71.43%, 90.39%), margin: 15pt)
#set align(left + top)
= T33\*. Единственность представления функции своим рядом Тейлора

Пусть при $|x - x_0| < R$ справедливо равенство  

$ f(x) = sum_(k=0)^infinity a_k (x - x_0)^k $

Тогда  

$ a_k = (f^((k))(x_0))/(k!), quad k in NN union {0} $

*Доказательство.* Согласно теореме о дифференцировании суммы степенного ряда (157),  

$ f^((m))(x) = sum_(k=m)^infinity k(k-1) dots (k-m+1) a_k (x-x_0)^(k-m) $

Подставив $x = x_0$, получаем, что  

$ f^((m))(x_0) = m dot (m-1) dot dots dot 1 dot a_m $

откуда  

$ a_m = (f^((m))(x_0))/(m!) $