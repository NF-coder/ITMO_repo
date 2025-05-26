#set page(width: 20cm, height: auto, fill: color.hsl(288.46deg, 100%, 89.8%), margin: 15pt)
#set align(left + top)
= +Л6. О радиусах сходимости степенного ряда, ряда из производных и первообразных

Радиусы сходимости рядов
$ sum_(k=1)^infinity k a_k x^(k-1) quad sum_(k=1)^infinity a_k x^k quad sum_(k=0)^infinity a_k x^(k+1)/(k+1) $
совпадают.  

*Доказательство.* Докажем, например, что радиусы сходимости первого и второго рядов совпадают. Так как $1 <= root(k,k) -> 1$, то по $epsilon > 0$ найдется $k_0$, что $forall k > k_0$ выполняется  

$ root(k,|a_k|) <= root(k,k |a_k|) < (1 + epsilon) root(k,|a_k|) $

Переходя к верхнему пределу, получим  

$ overline(lim_(k -> infinity)) root(k, |a_k|) <= overline(lim_(k -> infinity)) root(k, k |a_k|) <= (1 + epsilon) overline(lim_(k -> infinity)) root(k, |a_k|) $

В силу произвольности $epsilon$

$ overline(lim_(k -> infinity)) root(k, |a_k|) = overline(lim_(k -> infinity)) root(k, k |a_k|) $

а значит, по теореме Коши–Адамара (152), радиусы сходимости одинаковы. Аналогично доказывается, что радиус сходимости третьего ряда такой же.