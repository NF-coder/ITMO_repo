#set page(width: 20cm, height: 7.5cm, fill: color.hsl(253.71deg, 71.43%, 90.39%), margin: 15pt)
#set align(left + top)
= +T9. О сходимости абсолютно сходящегося ряда
Если ряд с общим членом $a_k$ сходится абсолютно, то он сходится.

*Доказательство.* Воспользуемся критерием Коши (теорема 127). Пусть $epsilon > 0$, тогда  

$ exists n_0 : forall n > n_0, forall p in NN sum_(k=n+1)^(n+p) |a_k| < epsilon $

В то же время,  

$ abs(sum_(k=n+1)^(n+p) a_k) <= sum_(k=n+1)^(n+p) abs(a_k) < epsilon $

откуда, согласно тому же критерию Коши (теорема 127) получаем, что ряд с общим членом $a_k$ сходится.