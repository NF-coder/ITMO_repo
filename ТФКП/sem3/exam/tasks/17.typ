#import "../marks.typ": unimportant-mark

#set page(width: 20cm, height: auto, fill: color.hsl(197.14deg, 71.43%, 90.39%), margin: 15pt)
#set align(left + top)

= (GPT) Ряды Лорана. Теорема Лорана—Вейерштрасса 
*Теорема (Лорана–Вейерштрасса)*  
Если $f$ голоморфна в кольце $r < abs(z - z_0) < R$, то она раскладывается в ряд Лорана:
$
  f(z) = sum_(n=-infinity dots infinity) a_n (z - z_0)^n
$
где коэффициенты
$
  a_n = 1 / (2 pi i) dot integral_abs(zeta - z_0) = rho f(zeta) / (zeta - z_0)^(n+1) d zeta, quad r < rho < R
$
Ряд сходится абсолютно и равномерно на компактах в кольце.

Док-во:\
Фиксируем $z$ в кольце. Выберем $rho_1, rho_2$ такие, что $r < rho_1 < abs(z - z_0) < rho_2 < R$.  
По интегральной формуле Коши для многосвязной области:
$
  f(z) = 1 / (2 pi i) dot integral_abs(zeta - z_0) = rho_2 f(zeta) / (zeta - z) d zeta
  - 1 / (2 pi i) dot integral_abs(zeta - z_0) = rho_1 f(zeta) / (zeta - z) d zeta
$

Для интеграла по внешней окружности $abs(zeta - z_0) = rho_2$, так как $abs(z - z_0)/rho_2 < 1$:
$
  1 / (zeta - z) = 1 / (zeta - z_0) dot 1 / (1 - (z - z_0)/(zeta - z_0))
  = sum_(n=0 dots infinity) (z - z_0)^n / (zeta - z_0)^(n+1)
$

Для интеграла по внутренней окружности $abs(zeta - z_0) = rho_1$, так как $rho_1 / abs(z - z_0) < 1$:
$
  1 / (zeta - z) = - 1 / (z - z_0) dot 1 / (1 - (zeta - z_0)/(z - z_0))
  = - sum_(n=0 dots infinity) (zeta - z_0)^n / (z - z_0)^(n+1)
  = - sum_(n=-infinity dots -1) (z - z_0)^n / (zeta - z_0)^(n+1)
$

Подставляя эти разложения в интегралы и меняя порядок интегрирования и суммирования (легально из-за равномерной сходимости), получаем ряд Лорана с коэффициентами, заданными интегралом по любой окружности $abs(zeta - z_0) = rho$, где $r < rho < R$.