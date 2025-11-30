* Задание №2 * \
Вычислить объёмы тел, ограниченных данными поверхностями:
$z = 0$, $z = 3 - x^2 - y^2$

Найдём точки пересечения:
$
  3 - x^2 - y^2 = 0\
  x^2 + y^2 = 3 => #text[_окружность радиуса $sqrt(3)$ с центром (0;0)_]\
$

$
  V = integral_(-sqrt(3))^(sqrt(3)) integral_(-sqrt(3-x^2))^sqrt(3-x^2) integral_0^(3 - x^2 - y^2) d z d y d x = integral_(-sqrt(3))^(sqrt(3)) integral_(-sqrt(3-x^2))^sqrt(3-x^2) (3 - x^2 - y^2) d y d x = \
  = integral_(-sqrt(3))^(sqrt(3)) ((3 - x^2)sqrt(3-x^2) - (3-x^2)^1.5/3) + ((3 - x^2)sqrt(3-x^2) - (3-x^2)^1.5/3) d x =\
  = 2 integral_(-sqrt(3))^(sqrt(3)) 2(3-x^2)^1.5/3 d x = 4/3 integral_(-sqrt(3))^(sqrt(3)) (3-x^2)^1.5 d x = mat(delim: "[", x=sqrt(3)sin(t); d x = sqrt(3) cos(t) d t) =\
  = 4/3 integral_(-pi/2)^(pi/2) (3-3sin(t)^2)^1.5 sqrt(3) cos(t) d t = 4/3 integral_(-pi/2)^(pi/2) 9 cos(t)^(2 dot 1.5 + 1) d t = 12 integral_(-pi/2)^(pi/2) cos(t)^4 d t = \
  = 12 integral_(-pi/2)^(pi/2) ((cos(2 t) + 1)/2)^2 d t = 3 integral_(-pi/2)^(pi/2) cos(2 t)^2 + 2cos(2 t) + 1 space d t = \
  = 3 (integral_(-pi/2)^(pi/2) (cos(4 t) + 1)/2 d t + 2 integral_(-pi/2)^(pi/2) cos(2 t) d t + integral_(-pi/2)^(pi/2) d t) =\
  = 3 (1/2integral_(-pi/2)^(pi/2) cos(4 t) d t + 1/2integral_(-pi/2)^(pi/2) d t +  (sin(pi) - sin(-pi)) + (pi/2 + pi/2)) =\
  = 3 (1/8(sin(2pi) - sin(-2pi)) + 1/2 (pi/2 + pi/2) + 0 + pi) = 3 dot 3/2 pi  = 9/2 pi
$
Ответ: $9/2 pi$