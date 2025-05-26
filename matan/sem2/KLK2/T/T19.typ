#set page(width: 20cm, height: auto, fill: color.hsl(253.71deg, 71.43%, 90.39%), margin: 15pt)
#set align(left + top)
= T19\*. Интегрирование и предельный переход для функциональной последовательности

Пусть $f_k, f: [a, b] -> RR$, $f_k in C[a, b]$, и  

$ f_k ==>_([a,b]) f $

Тогда $f in C[a, b]$ и  

$ integral_(a)^x f_k d x ==>_([a,b]) integral_(a)^x f d x $

*Доказательство.* То, что $f in C[a, b]$ следует из теоремы о непрерывности предельной функции (145). Докажем теперь вторую часть теоремы. Пусть $epsilon > 0$. Тогда, в силу равномерной сходимости,

$ exists k_0 : forall k > k_0 forall x in [a, b] |f(x) - f_k(x)| < epsilon/(b-a) $

Пусть $k > k_0$, тогда

$ abs(integral_(a)^x f_k d x - integral_(a)^x f d x) <= integral_(a)^x abs(f_k - f) d x <= epsilon/(b-a)(x-a) <= epsilon $

причем последняя оценка справедлива при всех $x in [a, b]$. Это и доказывает равномерную сходимость.