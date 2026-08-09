#set page(width: 20cm, height: 6.15cm, fill: color.hsl(197.14deg, 71.43%, 90.39%), margin: 15pt)
#set align(left + top)
= О9.  Интеграл Римана
\
*Понятие интеграла Римана.*
Пусть функция $f$ задана на отрезке [a, b]. Говорят, что число $I$ является интегралом Римана от функции $f$ по отрезку [a, b], если
$
  forall epsilon gt 0 space exists delta: 
  forall (tau, xi): lambda (tau) < delta space space
  abs(sigma_tau (f, xi) - I) lt epsilon
$

Обозначают это число так:
$
  I = integral_a^b f space d (x)
$