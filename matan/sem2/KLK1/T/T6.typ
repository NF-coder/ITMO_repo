#set page(width: 20cm, height: 18.7cm, fill: color.hsv(260.82deg, 19.22%, 100%), margin: 15pt)
#set align(left + top)
= T6. Определение интеграла Римана через последовательности
\
*Определение интеграла через последовательности*
Пусть $f$ задана на [a, b]. Тогда I -- интеграл Римана от функции $f$ по отрезку [a, b] тогда и только тогда, когда для любой последовательности $(tau^n, xi^n)$ оснащенных разбиений отрезка [a, b] такой, что $λ(tau^n) -->_(n->infinity) 0$, выполняется, что
$
  sigma_(tau^n) (f, xi^n) -->_(n->infinity) I
$
*Док-во*. Докажем необходимость. Пусть I — интеграл Римана от функции $f$ по отрезку [a, b] согласно исходному определению и пусть $epsilon$ > 0. Тогда
$
  exists delta: forall (tau, xi): lambda (tau) < delta abs(sigma_tau (f, xi) - I) < epsilon
$
Пусть теперь $(tau^n, xi^n)$ — последовательность оснащенных разбиений отрезка [a, b] такая, что $lambda (tau^n) -->_(n->infinity) 0$. Тогда
$
  exists n_0 in NN: forall n > n_0 space space lambda (tau^n) < delta
$
Но тогда, при $n > n_0$ выполняется и
$
  abs(sigma_(tau^n) (f, xi^n) - I) < epsilon
$
откуда и следует утверждение.
Докажем достаточность. От противного, пусть выполнено утверждение теоремы, но I — не интеграл Римана, согласно исходному определению. Это значит, что
$
  exists epsilon_0 > 0: forall delta > 0 space exists (tau^delta, xi^delta): lambda (tau^delta) < delta " и " abs(sigma_(tau^delta)(f, xi^delta) - I) gt.eq epsilon_0
$
Пусть $delta_n = 1/n$. Тогда, по написанному,
$
  exists (tau^n, xi^n): lambda(tau, n) < delta^n = 1/n " и " abs(sigma_(tau^n)(f, xi^n) - I) gt.eq epsilon_0
$
Но так как $δ_n -->_(n->infinity)0$, то $lambda(tau^n) -->_(n->infinity) 0$, а значит построенная последовательность оснащенных разбиений удовлетворяет условию теоремы. В то же время
$
  abs(sigma_(tau^n)(f, xi^n) - I) gt.eq epsilon_0
$
что противоречит тому, что
$
  sigma_(tau^n) (f, xi^n) -->_(n->+infinity) I
$