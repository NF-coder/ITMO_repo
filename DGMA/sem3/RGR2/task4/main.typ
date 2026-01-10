* Задание №4 * \
С помощью криволинейного интеграла первого рода найдите массу $M$ дуги пространственной материальной кривой, заданной уравнениями:
$
  cases(
    x = t,
    y = 3 sin(t),
    z = 2 cos(t)
  ) quad rho(x,y,z) = (x y sqrt(6))/sqrt(48+3z^2 + 2y^2)
  quad t_1 = pi/3 space t_2 = (2pi)/3
$
Решение:
$
  M = integral_(pi/3)^((2pi)/3) f(x(t), y(t), z(t)) sqrt(((t)^')^2 + ((3 sin(t))^')^2 + ((2 cos(t))^')^2) d t =\
  = integral_(pi/3)^((2pi)/3) (t dot 3 sin(t) dot sqrt(6))/sqrt(48+3(2 cos(t))^2 + 2(3 sin(t))^2) sqrt((1)^2 + (3 cos(t))^2 + (- 2 sin(t))^2) d t =\
  = integral_(pi/3)^((2pi)/3) (t dot 3 sin(t) dot sqrt(6))/sqrt(48 + 12 + 6(sin(t))^2) sqrt(5 + 5 (cos(t))^2) d t = integral_(pi/3)^((2pi)/3) (t dot 3 sin(t) dot sqrt(6))/sqrt(60 + 6(sin(t))^2) sqrt(5 + 5 (cos(t))^2) d t =\
  = 3 sqrt(5) integral_(pi/3)^((2pi)/3) (t sin(t))/sqrt(10 + (sin(t))^2) sqrt(1 + cos(t)^2) d t =
  mat(
    delim: "[",
    r = 1+cos(t)^2;
    d t =  -2 sin(t) cos(t) d r
  ) = ???
$

Ответ: ???