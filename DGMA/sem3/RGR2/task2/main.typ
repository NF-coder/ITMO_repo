* Задание №2 * \
Тело $T$ ограничено заданными поверхностями.
$
 x^2 + y^2 + z^2 = 9 quad x^2 + y^2 + z^2 = 2sqrt(3)z quad x = 0 quad z = 0\
 "при" x >= 0 quad 0 <= 2sqrt(3)z <= x^2 + y^2 + z^2
$
1. Сделайте схематический рисунок тела $T$
2. С помощью тройного интеграла найдите объем тела $T$, перейдя к цилиндрическим или сферическим координатам.
Решение пункта 1:
$
  x^2 + y^2 + z^2 = 2sqrt(3)z => x^2 + y^2 + z^2 - 2 dot sqrt(3)z =0 => x^2 + y^2 + (z-sqrt(3))^2 = 3 
$
#align(center)[
  $x^2 + y^2 + z^2 = 9$ - _сфера радиуса 3 с центром в (0;0;0). Назовём её $S_1$_\
  $x^2 + y^2 + z^2 = 2sqrt(3)z$ - _сфера радиуса $sqrt(3)$ с центром в (0;0;$sqrt(3)$). Назовём её $S_2$_\
  $z=0$ и $x>=0$ - _часть пространства, где $x$ положителен_\
  $0 <= 2sqrt(3)z <= x^2 + y^2 + z^2$ - _часть пространства, где $z>0$ и лежащая вне сферы $S_2$_\

  Итого берётся фигура, у которой $x$ и $z$ положительны, а все точки лежат снаружи $S_2$, но внутри $S_1$
]
#figure(
  image("plot.png", width: 70%),
  caption: [
    Рисунок области $T$ (она заключена между красной и синей сферой)
  ]
)

Решение пункта 2:
$
  V = integral.triple_T d V
$
#align(center)[
  _Перейдём в сферические кординаты_
  $
    cases(
      x = rho sin(phi) cos(theta),
      y = rho sin(phi) sin(theta),
      z = rho cos(phi) 
    )
  $
  $
    d V = abs(J) d rho d phi d theta
    J = rho^2 sin(phi) => d V = rho^2 sin(phi) space d rho d phi d theta$

  1. $z>=0 => rho cos(phi) >=0 => phi in [0, pi/2]$
  2. $x>=0 => rho sin(phi) cos(theta) >= 0 => theta in [-pi/2, pi/2]$
  3. $S_1 => rho = 3$
  4. $S_2 => rho = 2 sqrt(3) cos(phi)$
  $
    2 sqrt(3) cos(phi) <= 3 =>  cos(phi) <= sqrt(3)/2 => phi >= pi/6
  $
]

$
  V = integral_(-pi/2)^(pi/2) d theta integral_(pi/6)^(pi/2) d phi integral_(2 sqrt(3) cos(phi))^3 rho^2 sin(phi) d rho =
  integral_(-pi/2)^(pi/2) d theta integral_(pi/6)^(pi/2) d phi sin(phi) lr((rho^3/3)|)_(2 sqrt(3) cos(phi))^(3) =\
  = integral_(-pi/2)^(pi/2) d theta integral_(pi/6)^(pi/2) d phi sin(phi) (9-8sqrt(3)cos(phi)^3) = integral_(-pi/2)^(pi/2) d theta integral_(pi/6)^(pi/2) d phi sin(phi) (9-8sqrt(3)1/4(3 cos(phi) + cos(3phi))) =\
  = integral_(-pi/2)^(pi/2) d theta integral_(pi/6)^(pi/2) 9sin(phi) - 3sqrt(3) sin(2 phi) - 2sqrt(3)cos(3phi) sin(phi) d phi
$
$
  integral 2sqrt(3)cos(3phi) sin(phi) d phi = sqrt(3) integral sin(4phi) + sin(-2phi) d phi = sqrt(3) (-cos(4x)/4 + cos(2x)/2) + C
$
$
  V = integral_(-pi/2)^(pi/2) d theta lr((-9cos(phi) + (3sqrt(3)cos(2phi))/2 + (sqrt(3))/4 cos(4 phi) - sqrt(3)/2 cos(2 phi))|)_(pi/6)^(pi/2) =\
  = integral_(-pi/2)^(pi/2) d theta ((0 - (3sqrt(3))/2 + sqrt(3)/4 + sqrt(3)/2) - (- 9 sqrt(3)/2 + (3sqrt(3))/4 - sqrt(3)/8 - sqrt(3)/4)) =\
  = sqrt(3)/2 integral_(-pi/2)^(pi/2) ((-3 + 0.5 + 1) -(-9 + 1.5 - 0.25 - 0.5)) d theta =\
  = sqrt(3)/2 integral_(-pi/2)^(pi/2) (-1.5 +8.25) d theta =  sqrt(3)/2 dot 27/4 integral_(-pi/2)^(pi/2) d theta = (27 sqrt(3) pi)/8
$