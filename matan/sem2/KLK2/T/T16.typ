#set page(width: 20cm, height: 10.5cm, fill: color.hsl(253.71deg, 71.43%, 90.39%), margin: 15pt)
#set align(left + top)
= T16\*. О почленном переходе к пределу в функциональном ряде

Пусть $f_k: D -> RR$, причем:  

1. Ряд с общим членом $f_k$ равномерно сходится на $D$ к сумме $S$.  

2. Для каждого $k in NN$ существует предел  

$ lim_(x -> x_0) f_k (x) = a_k in RR $

где $x_0$ — предельная для $D$.  

Тогда ряд с общим членом $a_k$ сходится к сумме $A$, причем  

$ lim_(x -> x_0) S(x) = A $

то есть  

$ lim_(x -> x_0) S(x) = lim_(x -> x_0) sum_(k=1)^infinity f_k (x) = sum_(k=1)^infinity lim_(x -> x_0) f_k (x) $

*Доказательство.* Для доказательства достаточно применить предыдущую теорему к последовательности частичных сумм рассматриваемого ряда.