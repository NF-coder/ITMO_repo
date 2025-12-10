* Задание №2 * \
Показать, что данное выражение является полным дифференциалом функции $u(x, y)$. Найти функцию $u(x, y)$.
$
  (y-sin(x)) d x + (x-2y cos(y^2)) d y
$

Решение:
$
  #text[
    #align(center)[
      _Проверим условие Грина:_
    ]
  ]
  quad (partial P) / (partial y) = (partial Q)/(partial x)\
  1 = 1 => #text[_условие выполняется_] => #text[_выражение является полным дифференциалом_]\

  integral (y - sin(x)) d x = x y + cos(x) \
  u(x,y) = (y - sin(x)) d x = x y + cos(x) + phi(y)\
  u_y^' (x, y) = x +  phi^' (y) = x-2y cos(y^2) => \
  phi(y) = integral (-2y cos(y^2)) d y = -2 integral (y cos(y^2)) d y =
  mat(delim: "[", t = y^2; d t = 2y space d t) = - integral cos(t) d t = - sin(y^2) + C
$

Ответ: $u(x, y) = x y + cos(x) - sin(y^2) + C$