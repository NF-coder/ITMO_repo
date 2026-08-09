* Задание №3 * \
Вычислить момент инерции относительно оси Oz однородной дуги первого
витка винтовой линии $x = 2 cos(t)$, $y = 2 sin(t)$, $z = t$.

Решение:
$
  I = integral r^2 d m\
  #text[_В нашем случае_] quad I = integral_0^(2pi) f(x(t),y(t),z(t)) sqrt((x^' (t))^2 + (y^' (t))^2 + (z^' (t))^2) d t\
$
$
  f(x, y, z) = x^2+y^2=(2cos(t))^2+(2sin(t))^2=4(cos^2(t)+sin^2(t))=4\
  I = integral_0^(2pi) 4 dot sqrt((2sin(t))^2 + (-2cos(t))^2 + 1^2) d t = integral_0^(2pi) 4 sqrt(4 + 1) space d t = 4 sqrt(5) integral_0^(2pi) d t = 8 pi sqrt(5) 
$
Ответ: $8 pi sqrt(5)$