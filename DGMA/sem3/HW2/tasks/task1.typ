* Задание №1 * \
Вычислить площади фигур, ограниченных кривыми:
$
  (x^2/4 + y^2/9)^2 = x^2/4 - y^2/9
$
$
  D: (x^2/4 + y^2/9)^2 = x^2/4 - y^2/9
  quad quad
  S = integral.double_D d x d y
$
Проведём замену:
$
  cases(
    u=x/2,
    v=y/3
  ) space => space cases(
    x=2u,
    y=3v
  )\
  J = mat(
    delim: "|",
    x'_u, x'_v;
    y'_u, y'_v;
  ) = mat(
    delim: "|",
    2, 0;
    0, 3;
  ) = 6 \
  D_2: (u^2 + v^2)^2 = u^2 - v^2
  quad quad
  S = 6 dot integral.double_D_2 d u d v
$
Перейдём в полярные кординаты:
$
  cases(
    u = r cos(phi),
    v = r sin(phi)
  )\
  ((r cos(phi))^2 + (r sin(phi))^2)^2 = (r cos(phi))^2 - (r sin(phi))^2\
  r^4(cos(phi)^2 + sin(phi)^2)^2 = r^2(cos(phi)^2 - sin(phi)^2)\

  r^2 = cos(2 phi) => r = plus.minus sqrt(cos(2 phi)) 
  space #text[_но т.к _] r > 0, #text[_то_] space r = sqrt(cos(2 phi))\
  #text[_при этом _] space 2 phi in [-pi/2, pi/2] + 2pi k => phi in [-pi/4, pi/4] + pi k\
  #text[_т.е. кривую можно разбить на 2 идентичные области_]\
$
#v(3pt)
$
  S = 6 dot 2 dot integral_(-pi/4)^(pi/4) integral_0^(sqrt(cos(2 phi))) r space d r d phi = 12 dot integral_(-pi/4)^(pi/4) 1/2 cos(2 phi) d phi = mat(delim: "[", t=2phi; d t = 2 d phi) =\ 
  = 6 dot integral_(-pi/2)^(pi/2) 1/2 cos(t) d t  = 3 dot (-sin(-pi/2) + sin(pi/2)) = 6
$
Ответ: 6