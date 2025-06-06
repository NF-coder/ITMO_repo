#set page(width: 20cm, height: auto, fill: color.hsl(253.71deg, 71.43%, 90.39%), margin: 15pt)
#set align(left + top)
= +T22\*. Теорема о почленном дифференцировании функционального ряда
Пусть $f_k: [a, b] -> RR$, причем $f_k in C^1[a, b]$. Если  

1. Существует $x_0 in [a, b]$, что ряд с общим членом $f_k(x_0)$ сходится.  

2. Ряд с общим членом $f_k'$ сходится на $[a, b]$ равномерно к сумме $tilde(S)$,  

то ряд с общим членом $f_k$ сходится на $[a, b]$ равномерно к сумме $S$, причем $S' = tilde(S)$ на $[a, b]$. В частности, $S in C^1[a, b]$.  

*Доказательство.* Для доказательства достаточно применить предыдущую теорему к последовательности частичных сумм рассматриваемого ряда.