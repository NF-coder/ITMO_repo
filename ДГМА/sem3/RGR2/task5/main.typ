* Задание №5 * \
Дано векторное поле $accent(a, ->)$ и плоскость $sigma$, пересекающая координатные плоскости по замкнутой ломаной $K L M K$, где $K$, $L$, $M$ – точки пересечения плоскости $sigma$ координатными осями $O_x, O_y, O_z$ соответственно.

a. Найдите поток $Q$ векторного поля $accent(a, ->)$ через часть $S$ плоскости $sigma$, вырезанной координатными плоскостями, в сторону нормали $accent(n, ->)$, направленной от начала координат $O(0, 0, 0)$.\
b. С помощью теоремы Остроградского-Гаусса найдите поток $Q$ векторного поля $accent(a, ->)$ через полную поверхность тетраэдра $O L M K$ в сторону внешней нормали.\
c. Найдите циркуляцию $C$ векторного поля $accent(a, ->)$ по контуру $K L M K$, образованному пересечением плоскости $sigma$ с координатными плоскостями.

$
  accent(a, ->) = (y + z - 2x)accent(i, ->) + (x - z)accent(j, ->) quad sigma: x - 2y - 2z = 2;
$

Решение пункта a:

$
  Q = integral.double_S accent(a, ->) accent(n, ->) space d S = integral.double_S  a_x cos(alpha) + a_y cos(beta) + a_z cos(gamma) space d S\
  sigma: x = 2 + 2y + 2z\
  (partial x)/(partial y) = 2 quad (partial x)/(partial z) = 2\
  d S = sqrt(1 + ((partial x)/(partial y))^2 + ((partial x)/(partial z))^2) space d y d z = sqrt(1 + 4 + 4) space d x d y = sqrt(9) space d y d z = 3 space d y d z\
$
$
  cos(alpha) = (-1) / (-sqrt(1 + ((partial x)/(partial y))^2 + ((partial x)/(partial z))^2)) = 1/3 
  quad cos(beta) = (-(partial x)/(partial y)) / (sqrt(1 + ((partial x)/(partial y))^2 + ((partial x)/(partial z))^2)) = (-2)/3 = -2/3\
  quad cos(gamma) = (-(partial x)/(partial z)) / (sqrt(1 + ((partial x)/(partial y))^2 + ((partial x)/(partial z))^2)) = (-2)/3 = -2/3
$
$
  a_x = (y + z - 2x) quad a_y = (x - z) quad a_z = 0 \

  a_x cos(alpha) + a_y cos(beta) + a_z cos(gamma) = (y + z - 2x) dot 1/3 - (x - z) dot 2/3 - 0 dot 2/3 =\ 
  = (y + z - 2x - 2x + 2z)/3 = (y + 3z - 4x)/3\

  Q = integral.double_(D_(y z)) (y + 3z - 4(2+2y+2z))/3  dot 3 space d y d z = integral.double_(D_(y z)) y+3z-8-8y-8z space d y d z =\
  = - integral.double_(D_(y z)) 5z+8+7y space d y d z
$
#align(center)[
  _Рассмотрим подробнее область $D_(y z)$_\
  _Найдём точку пересечения с $O_y$_: 
  $0 - 2y - 2 dot 0 = 2 => y = -1$

  _Найдём точку пересечения с $O_z$_: 
  $0 - 2 dot 0 - 2 z = 2 => z = -1$
]

$
  Q = - integral.double_(D_(y z)) 5z+8+7y space d y d z  = - integral^0_(-1) d z integral^0_(-1-z) 5z+8+7y space d y = - integral^0_(-1) d z lr((5z y + 8y + 7y^2/2)|)^(0)_(-1-z) =\
  = integral^0_(-1) 5z (-1-z) + 8 (-1-z) + 7 (-1-z)^2/2 space d z = integral^0_(-1) -5z - 5z^2 - 8 - 8z + 7 (1+2z+z^2)/2 space d z = \
  = integral^0_(-1) -13z - 5z^2 -8 + 7/2 + 7z  + 7/2 z^2  space d z =\
  = integral^0_(-1) -1.5z^2 - 6z  -4.5 space d z = lr((0.5 z^3 + 3z^2 + 4.5z)|)^(0)_(-1) = -0.5 + 3 -4.5 = -2
$

Ответ: $-2$

Решение пункта b:
#align(center)[
  _Возьмём $a_x, space a_y, space a_z$ из пункта a_
]
$
  Q = integral.triple_T "div" accent(a, ->) space d v\
  "div" accent(a, ->) = (partial (y+z-2x)) / (partial x) + (partial (x-z)) / (partial y) + (partial 0) / (partial z) = -2\
  Q = integral.triple_T "div" accent(a, ->) space d v = -2 integral.triple_T d v = -2 V_T\
$
#align(center)[
  _Рассмотрим подробнее фигуру $T$_\
  _Найдём точку пересечения с $O_x$_: 
  $x - 2 dot 0 - 2 dot 0 = 2 => x = 2$ => (2,0,0)

  _Найдём точку пересечения с $O_y$_: 
  $0 - 2y - 2 dot 0 = 2 => y = -1$ => (0,-1,0)

  _Найдём точку пересечения с $O_z$_: 
  $0 - 2 dot 0 - 2 z = 2 => z = -1$ => (0,0,-1)

  _Найдём $V_T$:_\
  $
    V_T = 1/3 dot 2 dot ((1*1)/2) = 1/3 
  $ 
]
$
  Q = -2 V_T = -2 dot 1/3 = -2/3
$

Ответ: $-2/3$

Решение пункта c:

$
  C = integral.double_S "rot" accent(a, ->) dot accent(n, ->) space d S = integral.double_S ("rot" accent(a, ->))_x space d y d z + ("rot" accent(a, ->))_y space d x d z + ("rot" accent(a, ->))_z space d x d y =\
  = integral.double_(D_(y z)) "rot" accent(a_x, ->) space d y d z - integral.double_(D_(x z)) "rot" accent(a_y, ->) space d x d z - integral.double_(D_(x y)) "rot" accent(a_z, ->) space d x d y\

  "rot" accent(a, ->) = mat(
    delim: "|",
    accent(i, ->), accent(j, ->), accent(k, ->);
    partial/(partial x), partial/(partial y), partial/(partial z);
    a_x, a_y, a_z
  ) = mat(
    delim: "|",
    accent(i, ->), accent(j, ->), accent(k, ->);
    partial/(partial x), partial/(partial y), partial/(partial z);
    y+z-2x, x-z, 0
  ) = \
  = partial/(partial y) dot accent(i, ->) dot 0 + partial/(partial x) dot (x-z) dot accent(k, ->) + accent(j, ->) dot partial/(partial z) dot (y+z-2x) - accent(k, ->) dot partial/(partial y) dot (y+z-2x) - partial/(partial z) dot (x-z) dot accent(i, ->) - partial/(partial x) dot accent(j, ->) dot 0  =\
  = accent(i, ->) dot partial/(partial z) dot (z-x) + accent(j, ->) dot partial/(partial z) dot (y+z-2x) + accent(k, ->) dot (partial/(partial x) dot (x-z) - partial/(partial y) dot (y+z-2x)) =\
  = accent(i, ->) dot 1 + accent(j, ->) dot 1 + accent(k, ->) dot (1-1) = accent(i, ->) + accent(j, ->)
$
$
  C = integral.double_(D_(y z)) d y d z - integral.double_(D_(x z)) d x d z = S_(triangle O L M) - S_(triangle O K M) = (1 dot 1)/2 - (2 dot 1)/2 = -0.5
$
Ответ: $-0.5$