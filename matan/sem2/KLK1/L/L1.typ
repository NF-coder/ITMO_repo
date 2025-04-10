#set page(width: 20cm, height: 8.6cm, fill: color.hsv(300deg, 13.73%, 100%), margin: 15pt)
#set align(left + top)
= Л1. Длина вписанной ломаной
\
*О длине вписанной ломаной*
Длина $abs(s_tau)$ ломаной $s_tau$ , вписанной в путь $gamma$, равна
$
  abs(s_tau) = 
  sum_(i=1)^n
  sqrt((x(t_i) - x(t_(i-1)))^2 + (y(t_i) - y(t_(i-1)))^2)
$
*Док-во.*
Длина отрезка, соединяющего точки $gamma (t_k)$ и $gamma (t_(k-1))$, вычисляется по теореме Пифагора и равна, очевидно,
$
  sqrt((x(t_k) - x(t_(k-1)))^2 + (y(t_k) - y(t_(k-1)))^2)
$

Тогда длина $abs(s_tau)$ ломаной $s_tau$ равна
$
  abs(s_tau) = 
  sum_(i=1)^n
  sqrt((x(t_i) - x(t_(i-1)))^2 + (y(t_i) - y(t_(i-1)))^2)
$