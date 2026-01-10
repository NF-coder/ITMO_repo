* Задание №6 * \
Дано векторное поле $accent(a, ->)(M)$.\
a. Проверьте, является ли векторное поле соленоидальным или потенциальным.\
b. Если поле потенциально, найдите его потенциал.
$
  accent(a, ->) = (e^z + 2)accent(i, ->) - (e^z + 3)accent(j, ->) + (e^z x - e^z y + 1)accent(k, ->)
$
Решение пункта a:
#align(center)[
  _Проверим, является ли поле потенциальным_
]
$
  "rot" accent(a, ->) = mat(
    delim: "|",
    accent(i, ->), accent(j, ->), accent(k, ->);
    partial/(partial x), partial/(partial y), partial/(partial z);
    a_x, a_y, a_z
  ) = mat(
    delim: "|",
    accent(i, ->), accent(j, ->), accent(k, ->);
    partial/(partial x), partial/(partial y), partial/(partial z);
    e^z + 2, -e^z - 3, e^z x - e^z y + 1
  ) =\
  = accent(i, ->) dot partial/(partial y) dot (e^z x - e^z y + 1) + accent(j, ->) dot partial/(partial z) dot (e^z + 2) + accent(k, ->) dot (-e^z - 3) dot partial/(partial x) - accent(k, ->) dot partial/(partial y) dot (e^z + 2) -\
$
$
  - (-e^z - 3) dot (partial/(partial z)) dot accent(i, ->) - accent(j, ->) dot partial/(partial x) dot (e^z x - e^z y + 1) 
  = accent(i, ->) dot (-e^z +e^z) + accent(j, ->) dot (e^z - e^z) + accent(k, ->) dot 0 = 0
$
#align(center)[
  _Проверим, является ли поле соленоидальным_
]
$
  "div" accent(a, ->)(M) = (partial (e^z + 2))/(partial x) + (partial (-e^z - 3))/(partial y) + (partial (e^z x - e^z y + 1))/(partial z) = e^z x - e^z y
$
Ответ: является потенциальным, но не является соленоидальным.

Решение пункта b:
$
  accent(a, ->)(M) = "grad" U(M)\
  U(M) = integral_(M_0)^M d U + C = integral_(M_0)^M a_x d x + a_y d y + a_z d z + C\
  d U = (e^z + 2) d x + (-e^z - 3) d y + (e^z x - e^z y + 1) d z\
  U(x,y,z) = integral_((0,0,0))^((x,y,z)) (e^overline(z) + 2) d overline(x) + (-e^overline(z) - 3) d overline(y) + (e^overline(z) overline(x) - e^overline(z) overline(y) + 1) d overline(z)
$
#align(center)[
  _В качестве пути интегрирования выберем ломаную, где_
  $
    O = O(0, 0, 0) quad A = A(x, 0, 0) quad B = B(x, y, 0) quad M = M (x, y, z)
  $
  _Пользуясь свойством аддитивности криволинейного интеграла, представим его в виде суммы интегралов, найденных на каждом отрезке данной ломаной_
  $
    cases(
      overline(y) = 0,
      overline(z) = 0
    ) => cases(
      d overline(y) = 0,
      d overline(z) = 0
    )
  $
  _Переменная $overline(x)$ меняется от 0 до x. Интеграл по отрезку $O A$ равен_
  $
    integral_0^x e^0 + 2 space d overline(x) = lr((3overline(x))|)_(0)^(x) = 3x
  $
  $
    cases(
      overline(x) = "const",
      overline(z) = 0
    ) => cases(
      d overline(x) = 0,
      d overline(z) = 0
    )
  $
  _Переменная $overline(y)$ меняется от 0 до y. Интеграл по отрезку $A B$ равен_
  $
    integral_0^y -e^0 - 3 space d overline(y) = lr((-4overline(y))|)_(0)^(y) = -4y
  $
  $
    cases(
      overline(x) = "const",
      overline(y) = "const"
    ) => cases(
      d overline(x) = 0,
      d overline(y) = 0
    )
  $
  _Переменная $overline(z)$ меняется от 0 до z. Интеграл по отрезку $B M$ равен_
  $
    integral_0^z e^overline(z) overline(x) - e^overline(z) overline(y) + 1 space d overline(z) = lr((e^overline(z) overline(x) - e^overline(z) overline(y) + overline(z))|)_(0)^(z) = e^z x - e^z y + z - x + y
  $
  _Окончательно получим:_
  $
    U(x,y,z) = 3x - 4y + e^z x - e^z y + z - x + y + C = 2x - 3y + z + e^z x - e^z y + C
  $
]

Ответ: $2x - 3y + z + e^z x - e^z y + C$