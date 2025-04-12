#set page(width: 20cm, height: 42.5cm, fill: color.hsv(260.82deg, 19.22%, 100%), margin: 15pt)
#set align(left + top)
= T13. Арифметические свойства интегрируемых функций
\
*Арифметические свойства интегрируемых функций*

Пусть $f, g in R[a, b]$. Тогда:

1. Линейная комбинация $f$ и $g$ интегрируема, то есть  
$ alpha f + beta g in R[a, b], quad alpha, beta in RR. $

2. Произведение $f$ и $g$ интегрируемо, то есть  
$ f g in R[a, b]. $

3. Модуль функции интегрируем, то есть  
$ |f| in R[a, b]. $

4. Если $|f| > C$ на $[a, b], C > 0$, то  
$ 1/f in R[a, b]. $

*Док-во:*

1. Так как  
$ |alpha f(x) + beta g(x) - alpha f(y) - beta g(y)| <= |alpha| dot |f(x) - f(y)| + |beta| dot |g(x) - g(y)| <= $  
$ <= |alpha|omega(f, E) + |beta|omega(g, E), $  
то, переходя к супремуму в левой части, получим следующее неравенство:  
$ omega(alpha f + beta g, E) <= |alpha|omega(f, E) + |beta|omega(g, E), $  
верное для произвольного множества $E$.

Пусть $epsilon > 0$. Так как $f in R[a, b]$, то по следствию из критерия Дарбу (26) интегрируемости функции,  
$ exists delta_1 : forall tau : lambda(tau) < delta_1 sum_(i=1)^n omega(f, Delta_i) Delta x_i < epsilon/(2(|alpha| + 1)). $

Аналогично, так как $g in R[a, b]$, то по следствию из критерия Дарбу (26) интегрируемости функции,  
$ exists delta_2 : forall tau : lambda(tau) < delta_2 sum_(i=1)^n omega(g, Delta_i) Delta x_i < epsilon/(2(|beta| + 1)). $

Пусть $delta = min(delta_1, delta_2)$, тогда для любого $tau$ такого, что $lambda(tau) < delta$, выполняется  
$ sum_(i=1)^n omega(alpha f + beta g, Delta_i) Delta x_i <= $  
$ |alpha|sum_(i=1)^n omega(f, Delta_i) Delta x_i + |beta| sum_(i=1)^n omega(g, Delta_i) Delta x_i <= $  
$ <= (|alpha|epsilon)/(2(|alpha| + 1)) + (|beta|epsilon)/(2(|beta| + 1)) < epsilon/(2) + epsilon/(2) = epsilon. $

Значит, по следствию из критерия Дарбу (26) интегрируемости функции, $alpha f + beta g in R[a, b]$.

2. Так как $f, g in R[a, b]$, то по необходимому условию (86) они ограничены на $[a, b]$, то есть  
$ exists C : |f(x)| < C, |g(x)| < C quad forall x in [a, b]. $

Кроме того, так как  
$ |f(x)g(x) - f(y)g(y)| = |f(x)g(x) - f(x)g(y) + f(x)g(y) - f(y)g(y)| <= $  
$ <= |f(x)| dot |g(x) - g(y)| + |g(y)| dot |f(x) - f(y)| <= C(omega(f, E) + omega(g, E)), $  
то, переходя к супремуму в левой части, получим следующее неравенство:  
$ omega(f g, E) <= C(omega(f, E) + omega(g, E)), $  
верное для произвольного множества $E$. Дальнейшие обоснования проводятся тем же образом, что и в пункте 1, и остаются в качестве упражнения.

3. Так как  
$ | dot |f(x)| - |f(y)| dot | <= |f(x) - f(y)| <= omega(f, E), $  
то, переходя к супремуму в левой части, получим следующее неравенство:  
$ omega(|f|, E) <= omega(f, E), $  
верное для любого множества $E$. Дальнейшие обоснования проводятся тем же образом, что и в пункте 1, и остаются в качестве упражнения.

4. Так как  
$ abs(1/(f(x)) - 1/(f(y))) = abs((f(x) - f(y))/(f(x)f(y))) <= (|f(x) - f(y)|)/(C^2) <= omega(f, E)/(C^2), $  
то, переходя к супремуму в левой части, получим следующее неравенство:  
$ omega(1/f, E) <= omega(f, E)/(C^2), $  
верное для любого множества $E$. Дальнейшие обоснования проводятся тем же образом, что и в пункте 1, и остаются в качестве упражнения.