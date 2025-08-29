#set page(width: 20cm, height: 8.8cm, fill: color.hsl(253.71deg, 71.43%, 90.39%), margin: 15pt)
#set align(left + top)
= +T1\*.  Критерий Коши сходимости числового ряда


Ряд $sum_(k=1)^infinity a_k$ сходится тогда и только тогда, когда

$ forall epsilon > 0 exists n_0 = n_0(epsilon) in NN : forall n > n_0, forall p in NN quad abs(sum_(k=n+1)^(n+p) a_k) < epsilon $

*Доказательство.* Согласно определению, сходимость ряда — это сходимость последовательности его частичных сумм

$ S_n = sum_(k=1)^n a_k $

По критерию Коши (теорема 16) эта последовательность сходится тогда и только тогда, когда

$ forall ε > 0 exists n_0 = n_0(ε) : forall n > n_0, forall p in NN |S_(n+p) - S_n| < ε $

Последнее неравенство равносильно тому, что $|sum_(k=n+1)^(n+p) a_k| < ε$