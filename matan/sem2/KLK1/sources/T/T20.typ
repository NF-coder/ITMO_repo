#set page(width: 20cm, height: 14cm, fill: color.hsv(260.82deg, 19.22%, 100%), margin: 15pt)
#set align(left + top)
= T20. Теорема Барроу (о дифференцируемости интеграла с переменным верхним пределом)
*О дифференцируемости интеграла с переменным верхним пределом*

Функция $Phi$ дифференцируема в точках непрерывности функции $f: [a, b] -> RR$, причем в этих точках  
$ Phi'(x_0) = f(x_0). $

*Док-во:*

Пусть $f$ непрерывна в точке $x_0$ и $x_0 + Delta x in [a, b]$. Рассмотрим:

$
  abs((Phi(x_0 + Delta x) - Phi(x_0)) / (Delta x) - f(x_0)) = 
  abs( (integral_(x_0)^(x_0 + Delta x) f space d (t) - f(x_0) Delta x ) / (Delta x) ) = 
  abs( (integral_(x_0)^(x_0 + Delta x) (f(t) - f(x_0)) space d (t) ) / (Delta x) ).
$

Пусть $epsilon > 0$. Тогда, в силу непрерывности $f$ в точке $x_0$:

$ exists delta > 0 : forall t in [a, b] : abs(t - x_0) < delta => abs(f(t) - f(x_0)) < epsilon. $

При $abs(Delta x) < delta$:

$
  abs( (integral_(x_0)^(x_0 + Delta x) (f(t) - f(x_0)) space d (t) ) / (Delta x) ) <=
  abs( (integral_(x_0)^(x_0 + Delta x) abs(f(t) - f(x_0)) space d (t) ) / (Delta x) ) < epsilon dot
  abs((integral^(x_0 + Delta x)_(x_0) space d(t))/(Delta x)) = 
  epsilon
$

Таким образом:

$ lim_(Delta x -> 0) (Phi(x_0 + Delta x) - Phi(x_0)) / (Delta x) = f(x_0). $