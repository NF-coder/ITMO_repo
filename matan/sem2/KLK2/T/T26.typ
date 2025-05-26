#set page(width: 20cm, height: auto, fill: color.hsl(253.71deg, 71.43%, 90.39%), margin: 15pt)
#set align(left + top)
= T26\*. Вторая теорема Абеля
 
Пусть дан ряд с общим членом $a_k R^k$ и пусть $R$ — его радиус сходимости. Если сходится ряд с общим членом $a_k R^k$, то исходный ряд сходится равномерно на $[0, R]$.

*Доказательство.* Так как ряд с общим членом $a_k R^k$ сходится, то, согласно критерию Коши 127, для любого $epsilon > 0$

$ exists n_0 : forall n > n_0 forall p in NN quad abs(sum_(k=n+1)^(n+p) a_k R^k) < epsilon $

Пусть $n > n_0$, $m > n$. Обозначим

$ A_m = sum_(k=n+1)^m a_k R^k, quad A_n = 0 $

и заметим, что

$ |A_m| < epsilon, quad m in NN $

Тогда

$ sum_(k=n+1)^(n+p) a_k x^k = sum_(k=n+1)^(n+p) a_k R^k (x/R)^k = sum_(k=n+1)^(n+p) (A_k - A_(k-1)) (x/R)^k = $

$ = sum_(k=n+1)^(n+p) A_k (x/R)^k - sum_(k=n+1)^(n+p) A_(k-1) (x/R)^k = sum_(k=n+1)^(n+p-1) A_k ((x/R)^k - (x/R)^(k+1)) + A_(n+p) (x/R)^(n+p) $

Так как $x in [0, R]$, то

$ (x/R)^k - (x/R)^(k+1) >= 0, quad (x/R)^k <= 1, quad k in NN $

Тогда

$ abs(sum_(k=n+1)^(n+p) a_k x^k) <= sum_(k=n+1)^(n+p-1) |A_k| ((x/R)^k - (x/R)^(k+1)) + |A_(n+p)| (x/R)^(n+p) < $

$ < epsilon (sum_(k=n+1)^(n+p-1) ((x/R)^k - (x/R)^(k+1)) + (x/R)^(n+p)) = epsilon (x/R)^(n+1) <= epsilon $

откуда, согласно критерию Коши равномерной сходимости 140, и следует утверждение.