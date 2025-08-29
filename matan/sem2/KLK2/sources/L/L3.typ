#set page(width: 20cm, height: auto, fill: color.hsl(288.46deg, 100%, 89.8%), margin: 15pt)
#set align(left + top)
= +Л3\*. Линейность суммирования для числового ряда
Пусть сходятся ряды с общими членами $a_k$ и $b_k$. Тогда при любых $alpha, beta in RR$ сходится ряд с общим членом $alpha a_k + beta b_k$, причем  

$ sum_(k=1)^infinity (alpha a_k + beta b_k) = alpha sum_(k=1)^infinity a_k + beta sum_(k=1)^infinity b_k $

*Доказательство.* Обозначим  

$ S^A = sum_(k=1)^infinity a_k quad S_n^A = sum_(k=1)^n a_k quad S^B = sum_(k=1)^infinity b_k quad S_n^B = sum_(k=1)^n b_k $

Тогда  

$ S_n = sum_(k=1)^n (alpha a_k + beta b_k) = alpha S_n^A + beta S_n^B -->_(n -> infinity) alpha S^A + beta S^B $

что и доказывает утверждение.