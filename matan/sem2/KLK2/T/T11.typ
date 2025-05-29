#set page(width: 20cm, height: 16.6cm, fill: color.hsl(253.71deg, 71.43%, 90.39%), margin: 15pt)
#set align(left + top)
= +T11\*. Критерий Коши равномерной сходимости функциональной последовательности

Для того чтобы функциональная последовательность $f_k: X -> RR$ сходилась равномерно на $D subset X$ необходимо и достаточно, чтобы

$ forall epsilon > 0 exists k_0 in NN : forall k > k_0 forall p in NN forall x in D |f_(k+p)(x) - f_k (x)| < epsilon $

*Доказательство.* Докажем необходимость. Пусть $epsilon > 0$. В силу равномерной сходимости $f_k$ к некоторой функции $f$,

$ exists k_0 in NN : forall k > k_0 |f_k - f| < epsilon/2 $

Пусть $p in NN$, тогда $k + p > k_0$ и, по неравенству треугольника,

$ |f_(k+p) - f_k| <= |f_(k+p) - f| + |f - f_k| < epsilon/2 + epsilon/2 = epsilon $

Докажем достаточность. Условие

$ forall epsilon > 0 exists k_0 in NN : forall k > k_0 forall p in NN forall x in D |f_(k+p)(x) - f_k (x)| < epsilon $

гарантирует, что при каждом $x in D$ числовая последовательность фундаментальна, значит (теорема 16) сходится. Положим

$ f(x) = lim_(k -> infinity) f_k (x), quad x in D $

Пусть $epsilon > 0$. По условию найдем $k_0$, что при $k > k_0$ и $p in NN$

$ forall x in D |f_(k+p) (x) - f_k (x)| < epsilon $

Переходя к пределу при $p -> infinity$, получим

$ forall x in D |f(x) - f_k (x)| <= epsilon $

откуда и следует требуемое.