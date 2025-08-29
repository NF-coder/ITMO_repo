#set page(width: 20cm, height: auto, fill: color.hsl(253.71deg, 71.43%, 90.39%), margin: 15pt)
#set align(left + top)
= +T20\*. О почленном интегрировании функционального ряда

Пусть $f_k: [a, b] -> RR$, причем $f_k in C[a, b]$. Если ряд с общим членом $f_k$ сходится равномерно к функции $S$ на $[a, b]$, то $S in C[a, b]$, причем  

$ integral_(a)^x (sum_(k=1)^infinity f_k) d x = sum_(k=1)^infinity (integral_(a)^x f_k d x) quad x in [a, b] $

*Доказательство.* Для доказательства достаточно применить предыдущую теорему к частичным суммам рассматриваемого ряда.