#set page(width: 20cm, height: 6.1cm, fill: color.hsl(197.14deg, 71.43%, 90.39%), margin: 15pt)
#set align(left + top)
= +О14. Равномерная сходимость функциональной последовательности

Говорят, что последовательность $f_k: X -> RR$ сходится к функции $f$ на множестве $D subset X$ равномерно, если

$ forall epsilon > 0 exists k_0 in NN : forall k > k_0 forall x in D |f_k (x) - f(x)| < ε $
Обозначают это так:
$ f_k ==>_(k -> infinity)^D f "." $