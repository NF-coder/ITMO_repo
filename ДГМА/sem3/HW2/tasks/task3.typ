* Задание №3 * \
Вычислить координаты центра тяжести тела, ограниченного:
параболоидом $4x = y^2 + z^2$ и плоскостью $x = 2$

Найдём точки пересечения:
$
  8 = y^2 + z^2\
  y^2 + z^2 = 8 => #text[_окружность радиуса $sqrt(8)$ с центром (0;0)_]\
$
Т.к. тело однородное, то примем его плотность за 1
$
  V = integral_(-sqrt(8))^sqrt(8) integral_(-sqrt(8-z^2))^(sqrt(8-z^2)) integral^((y^2 + z^2)/4)_2 d x d y d z
$
Перейдём в ЦСК
$
  cases(
    x = h,
    y = r cos(theta),
    z = r sin(theta),
  ) \ J = mat(delim:"|", 1,0,0; 0,cos(theta),-r sin(theta); 0,sin(theta),r cos(theta) ) = 1 dot cos(theta) dot r cos(theta)  - (- r sin(theta)) dot sin(theta) dot 1 = r (cos(theta)^2 + sin(theta)^2) = r\

  (y^2 + z^2)/4 = (r^2 cos(theta)^2 + r^2 sin(theta)^2)/4 = r^2/4\

  V = integral_0^(sqrt(8)) integral_0^(2pi) integral_2^(r^2/4) r space d h d phi d r = integral_0^(sqrt(8)) integral_0^(2pi) r(r^2/4 - 2) d phi d r =  integral_0^(sqrt(8)) 2pi r(r^2/4 - 2) d r =\ 1/2 pi integral_0^(sqrt(8)) r^3 d r - 4pi integral_0^(sqrt(8))r d r =  1/2 pi (sqrt(8))^4 /4 - 4 pi (sqrt(8))^2/2 = \
  = pi 64/8 - pi 18 = -8 pi
$
Теперь найдём координаты центра масс:
$
  x = (integral_0^(sqrt(8)) integral_0^(2pi) integral_2^(r^2/4) r h space d h d phi d r) / V \
  integral_0^(sqrt(8)) integral_0^(2pi) integral_2^(r^2/4) r h space d h d phi d r = integral_0^(sqrt(8)) integral_0^(2pi) r  ((r^2/4)^2/2 - (2)^2/2) space d phi d r = integral_0^(sqrt(8)) pi r (r^4/16 - 4) space d r =\
  = integral_0^(sqrt(8)) pi r (r^4/16 - 4) space d r = pi/16 integral_0^(sqrt(8)) r^5 space d r - 4 pi integral_0^(sqrt(8)) r space d r = pi/16 (sqrt(8))^6/6 - 4pi 8/2 = (pi dot 8^2) / (2 dot 6) - 16 pi = \
  = (pi dot 16)/3 - 16 pi = -32/3 pi\
  x = -32/3 pi dot (-1/(8pi)) = 32/(3 dot 8) = 4/3\
$
#v(24pt)
$
  y = (integral_0^(sqrt(8)) integral_0^(2pi) integral_2^(r^2/4) r^2 cos(phi) space d h d phi d r) / V \
  integral_0^(sqrt(8)) integral_0^(2pi) integral_2^(r^2/4) r^2 cos(phi) space d h d phi d r = integral_0^(sqrt(8)) integral_0^(2pi) 2pi r^2 cos(phi) - 2 r^2 cos(phi) space d phi d r =\
  = 2 integral_0^(sqrt(8)) r^2 integral_0^(2pi) pi cos(phi) - cos(phi) space d phi d r = 2 integral_0^(sqrt(8)) 0 d r = 0 \
  y = 0
$
#v(24pt)
$
  z = (integral_0^(sqrt(8)) integral_0^(2pi) integral_2^(r^2/4)  r^2 sin(phi) space d h d phi d r) / V \
  integral_0^(sqrt(8)) integral_0^(2pi) integral_2^(r^2/4) r^2 sin(phi) space d h d phi d r = integral_0^(sqrt(8)) integral_0^(2pi) 2pi r^2 sin(phi) - 2 r^2 sin(phi) space d phi d r =\
  = 2 integral_0^(sqrt(8)) r^2 integral_0^(2pi) pi sin(phi) - sin(phi) space d phi d r = 2 integral_0^(sqrt(8)) 0 d r = 0 \
  z = 0
$
Ответ: $(4/3; 0; 0)$