#set page(width: 20cm, height: 7cm, fill: color.hsl(253.71deg, 71.43%, 90.39%), margin: 15pt)
#set align(left + top)
= +T2\*.  Необходимое условие сходимости числового ряда
Пусть ряд с общим членом $a_k$ сходится. Тогда  

$ a_k -->_(k -> infinity) 0 $

*Доказательство.* Пусть $S_n = sum_(k=1)^n a_k$. Так как ряд сходится, то, так как $S_(n-1)$ — подпоследовательность $S_n$, то (теорема 27)  

$ lim_(n -> infinity) S_n = lim_(n -> infinity) S_(n-1) = S in RR $

Но тогда  

$ a_n = S_n - S_(n-1) => lim_(n -> infinity) a_n = S - S = 0 $