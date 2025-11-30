* Задание №4 * \
Вычислить (тройным интегралом) объёмы тел, ограниченных поверхностями:
$
  z = x + y quad
  z = x y quad
  x + y = 1 quad
  x = 0 quad
  y = 0
$
$
  V = integral_0^1 integral_0^(1-x) integral_(x y)^(x+y) d z d y d x = integral_0^1 integral_0^(1-x) (x+y) - x y space d y d x =\
  = integral_0^1 x(1-x) d x + integral_0^1 (1-x)^2/2 d x - integral_0^1 x (1-x)^2/2 d x =\
  = integral_0^1 x-x^2  space d x + 1/2 integral_0^1 1 - 2x + x^2 space d x - 1/2 integral_0^1 x - 2x^2 + x^3 space d x =\
  = 1/2 ( 2 integral_0^1x d x - 2integral_0^1 x^2 d x + integral_0^1 d x - 2 integral_0^1 x d x + integral_0^1 x^2 d x - integral_0^1 x d x + 2integral_0^1 x^2 d x - integral_0^1 x^3 d x) = \
  = 1/2 ( integral_0^1 d x - integral_0^1 x d x + integral_0^1 x^2 d x - integral_0^1 x^3 d x) = 1/2(1 - 1/2 + 1/3 - 1/4) = 1/2 dot (12 - 6 + 4 - 3)/12 =  7/24
$
Ответ: $7/24$