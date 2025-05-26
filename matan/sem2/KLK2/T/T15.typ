#set page(width: 20cm, height: 24.5cm, fill: color.hsl(253.71deg, 71.43%, 90.39%), margin: 15pt)
#set align(left + top)
= T15\*. О перестановке предельных переходов


Пусть $f, f_k: D -> RR$, причем:  

1. Последовательность $f_k$ равномерно сходится на $D$ к функции $f$.  

2. Для каждого $k in NN$ существует предел  

$ lim_(x -> x_0) f_k(x) = a_k in RR $

где $x_0$ — предельная для $D$.  

Тогда пределы  

$ lim_(k -> infinity) a_k quad text(и) quad lim_(x -> x_0) f(x) $

существуют (в $RR$) и совпадают, то есть  

$ lim_(x -> x_0) lim_(k -> infinity) f_k(x) = lim_(k -> infinity) lim_(x -> x_0) f_k(x) $

*Доказательство.* Пусть $epsilon > 0$. Согласно критерию Коши 139,  

$ exists k_0 : forall k > k_0 forall p in NN forall x in D |f_(k+p)(x) - f_k(x)| < epsilon $

Перейдя к пределу при $x -> x_0$, получим  

$ |a_(k+p) - a_k| <= epsilon $

что влечет фундаментальность $a_k$, как следствие, сходимость последовательности $a_k$.  
Пусть ее предел равен $A$. Осталось показать, что  

$ lim_(x -> x_0) f(x) = A $

Пусть $epsilon > 0$, тогда, в силу равномерной сходимости на $D$,  

$ exists k_0 : forall k > k_0 forall x in D |f_k(x) - f(x)| < epsilon/3 $

В силу сходимости последовательности $a_k$ к числу $A$,

$ exists k_1 : forall k > k_1 |a_k - A| < epsilon/3 $

Пусть $m = 1 + max(k_0, k_1)$, тогда одновременно, причем $forall x in D$

$ |a_m - A| < epsilon quad text(и) quad |f_m(x) - f(x)| < epsilon/3 $

Согласно определению предела функции,

$ exists U_δ(x_0) : forall x in U_δ(x_0) ∩ D |f_m(x) - a_m| < epsilon/3 $

Значит, при $x in U_δ(x_0) ∩ D$, имеем

$ |f(x) - A| <= |f(x) - f_m(x)| + |f_m(x) - a_m| + |a_m - A| < epsilon $

что и завершает доказательство. 