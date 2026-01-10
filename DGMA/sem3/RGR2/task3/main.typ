* Задание №3 * \
С помощью криволинейного интеграла первого рода найдите массу $M$ дуги плоской материальной кривой, заданной уравнениями:

a. $y = 1 - x^2 + arccos(x),quad rho (x, y) = 1, quad x_1 = 1/2,quad x_2 = 7/8 $\
b. $cases(
  x = 2/3 e^(3/2 t) - 1,
  y = e^t + 1
), quad rho(x, y) = 1/12, quad t_1 = ln(8), quad t_2 = ln(80)$

Решение пункта a:
$
  M = integral_(1/2)^(7/8) 1 sqrt(1 + ((1 - x^2 + arccos(x))^')^2) d x = 
  integral_(1/2)^(7/8) sqrt(1 + (- 2x - 1/sqrt(1-x^2))^2) d x =\
  integral_(1/2)^(7/8) sqrt(1 + 4x^2 + (4x)/sqrt(1-x^2) + 1/(1-x^2)) d x = ???
$

Решение пункта b:
$
  M = integral_ln(8)^ln(80) 1/12 sqrt(((2/3 e^(3/2 t) - 1)^')^2 + ((e^t + 1)^')^2) d t = 1/12 dot integral_ln(8)^ln(80) sqrt((e^(3/2 t))^2 + (e^t)^2) d t =\
  = 1/12 integral_ln(8)^ln(80) sqrt(e^(3t) +e^(2t)) d t = 1/12 integral_ln(8)^ln(80) e^t sqrt(e^t + 1) d t =
  mat(
    delim: "[",
    r = 1 + e^t;
    d t = e^t d r
  ) =\
  = 1/12 integral_9^81 sqrt(r) d r = lr((r^1.5)/1.5|)_(9)^(81) = 1/18 dot (81^1.5 - 9^1.5) = (81 dot 9 - 9 dot 3)/18 = (81-3)/2 = 39
$
Ответ: a. ???; b. 39