#set page(width: 20cm, height: auto, fill: color.hsl(288.46deg, 100%, 89.8%), margin: 15pt)
#set align(left + top)
= +Л4\*. Монотонность суммирования для числового ряда

Пусть $a_k <= b_k$ и ряды с общими членами $a_k$ и $b_k$ имеют суммы в $RR$. Тогда  

$ sum_(k=1)^infinity a_k <= sum_(k=1)^infinity b_k $

*Доказательство.* Обозначим  

$ S^A = sum_(k=1)^infinity a_k quad S_n^A = sum_(k=1)^n a_k quad S^B = sum_(k=1)^infinity b_k quad S_n^B = sum_(k=1)^n b_k $

Тогда, согласно условию,  

$ S_n^A <= S_n^B => lim_(n -> infinity) S_n^A <= lim_(n -> infinity) S_n^B => S^A <= S^B $