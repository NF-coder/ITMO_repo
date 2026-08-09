#set page(width: 20cm, height: 5.7cm, fill: color.hsl(253.71deg, 71.43%, 90.39%), margin: 15pt)
#set align(left + top)
= +T12\*. Критерий Коши равномерной сходимости функционального ряда
Ряд с общим членом $f_k: X -> RR$ сходится равномерно на $D subset X$ тогда и только тогда, когда  

$ forall epsilon > 0 exists n_0 in NN : forall n > n_0 quad forall p in NN quad forall x in D quad abs(sum_(k=n+1)^(n+p) f_k (x)) < epsilon $

*Доказательство.* Доказательство следует из предыдущей теоремы, так как равномерная сходимость ряда — суть равномерная сходимость последовательности его частичных сумм.