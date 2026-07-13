#import "../marks.typ": unimportant-mark

#set page(width: 20cm, height: auto, fill: color.hsl(197.14deg, 71.43%, 90.39%), margin: 15pt)
#set align(left + top)

= Дифференцируемость и условия Коши-Римана.
*3.1 Дифференцируемость*\
*Опр. производной ф-ии:*\ 
Пусть: $f: CC inter E -> CC$ и $z_0$ внутренняя для $E$\
$
  "Тогда предел в точке это" f^' (z_0) = lim_(z->z_0) (f(z)-f(z_0))/(z-z_0) "если он существует в" CC
$
*Опр. дифференцируемости ф-ии ($CC$-дифференцируемость):*\ 
Пусть: $f: CC inter E -> CC$ и $z_0$ внутренняя для $E$\
$f$ называется дифф. в $z_0$, если $f(z+z_0) - f(z_0) = A Delta z + o (Delta z)$ ($A in CC$ и $o(Delta z)/(delta z) -->_(delta z -> 0) 0$)
#unimportant-mark[
  Лемма:\
  1. #box[
    Дифференцируемость $<=>$ наличие производной, причём $A=f^' (z_0)$\
    Док-во:
    - #box[($=>$)\
      $
        f(z+z_0) - f(z_0) = A Delta z + o(Delta z) | : Delta z\
        (f(z+z_0) - f(z_0))/(Delta z) = A + (o(Delta z))/(Delta z) ==>_(Delta z -> 0) f^' (z_0) = A
      $
    ]
    - #box[($arrow.l.double$)\
      $
        (f(z+z_0) - f(z_0))/(Delta z) - f^' (z_0) = alpha(Delta z) "где" alpha(Delta z) -->_(Delta z -> 0) 0\
        f(z+z_0) - f(z_0) = underbracket(f^' (z_0), A) Delta z + underbracket(alpha(Delta z) Delta z, o(Delta z))
      $
    ]
  ]
  2. Дифференцируемость влечёт непрерывость
]
Заметим: $f(z) = f(z) = vec(u(x,y), v(z,y))$\
*Опр. дифференцируемости ф-ии ($RR$-дифференцируемость):*\
Пусть: $u: RR^2 inter E -> RR^2$, $(x_0, y_0)$ - внутренняя для $E$\
$u$ называется дифференцируемой в $(x_0, y_0)$, если 
$ u(x_0+Delta x, y_0 + Delta y) - u(x_0, y_0) = A Delta x + B Delta y + o(sqrt((Delta x)^2 + (Delta y)^2)) "при" cases(Delta x -> 0, Delta y -> 0) $
*Опр. часных производных*\
Пусть: $u: RR^2 inter E -> RR^2$, $(x_0, y_0)$ - внутренняя для $E$\
Частной производной $u$ в $(x_0, y_0)$ называют
$
  (partial u)/(partial x) (x_0, y_0) = u^'_x (x_0, y_0) = lim_(Delta x -> 0) (u(x_0+Delta x, y_0) - u(x_0,y_0))/(Delta x)
$ аналогично для $u^'_y$\
#unimportant-mark[
  Лемма:\
  Если $u: RR^2 inter E -> RR^2$, $u$ дифф. в $(x_0, y_0)$, то $A = u^'_x (x_0, y_0)$ $B = u^'_y (x_0, y_0)$\
  Док-во: очев из $RR$-дифференцируемости
]
#unimportant-mark[
  Вывод условий Коши-Римана:\
  Заметим:\
  $
    CC: f(z_0 + Delta z) - f(z_0) = overbracket(A, A_1 + i A_2) dot overbracket(Delta z, Delta x + i Delta y) + o (Delta z)\
    A dot Delta z = (A_1 + i A_2) dot (Delta x + i Delta y) = (A_1 Delta x - A_2 Delta y) + i (A_2 Delta x + A_1 Delta y) 
  $
  $
    RR:  vec(
      u(x + Delta x,y + Delta y) - u(x,y),
      v(x + Delta x,y + Delta y) - v(z,y)
    ) = underbracket(
      vec(
        B_1 Delta x + B_2 Delta y,
        C_1 Delta x + C_2 Delta y
      ),
      mat(
        B_1, B_2;
        C_1, C_2
      ) dot mat(Delta x; Delta y)
    ) + vec(
      o_1(sqrt((Delta x)^2 + (Delta y)^2)),
      o_2(sqrt((Delta x)^2 + (Delta y)^2))
    )
  $

  Чтобы результаты умножения совпадали нужно:
  $
    mat(
      A_1, -A_2;
      A_2, A_1
    ) dot vec(
      Delta x,
      Delta y
    ) = mat(
      A_1 Delta x - A_2 Delta y;
      A_2 Delta x + A_1 Delta y
    )
  $
  Исходя из предыдущей леммы:
  $
    mat(
      u^'_x, u^'_y;
      v^'_x, v^'_y
    ) = mat(
      A_1, -A_2;
      A_2, A_1
    ) => cases(
      u^'_x (x_0, y_0) = v'_y (x_0, y_0),
      u^'_y (x_0, y_0) = - v'_x (x_0, y_0)
    )
  $
  Полученная система и является условиями Коши-Римана
]
*Теорема (условия Коши-Римана):*\
Пусть $f: CC inter E -> CC$, $cases(
  u(x,y)="Re"(f),
  v(x,y)="Im"(f)
), "где" z=x+i y $ и $z_0 = x_0 + i y_0$ - внутренняя для $E$\
Для того чтобы $f$ была дифференцируема ($CC$ - дифференцируема) в $z_0$ необходимо и достаточно, чтобы
1. Ф-ии $u$ и $v$ были дифференцируемы ($RR$ - дифференцируемы) в точке $(x_0, y_0)$
2. #box[
  Выполнены условния Коши-Римана:
  - $u^'_x (x_0, y_0) = v'_y (x_0, y_0)$
  - $u^'_y (x_0, y_0) = - v'_x (x_0, y_0)$
]
При этом $f^' (z_0) = u^'_x (x_0, y_0) + i v^'_x (x_0, y_0)$ (по сути есть 4 варианта этой ф-ии, получаемых из уз условий Коши-Римана)\
Док-во:
1. #box[
  ($=>$)\
  $f(z_0 + Delta z) - f(z_0) = (A_1 + i A_2) Delta z + o(Delta z)$
  #unimportant-mark[
    *Замечание о комплексном о-малом*\
    Док-ть: $o(Delta z) = o_1 (Delta z) + i o_2 (Delta z)$\
    Док-во:\
    По теореме о неравенстве треугольника $cases(delim:"[", abs(o_1(Delta z)), abs(o_2 (Delta z))) <= abs(o(Delta z)) <= abs(o_1(Delta z)) + abs(o_2 (Delta z))$\
    $abs((o_i (Delta z))/(Delta z)) = abs(o_i (Delta z))/abs(Delta z) <= abs(o(Delta z))/abs(Delta z) = abs((o(Delta z))/(Delta z)) -->_(Delta z -> 0) 0$\
    Отсюда следует верность исходного утверждения\
    Более того, $o_i (Delta z) = o_i (abs(Delta z))$
  ]
  Перепишем равенство в координатах:\
  $
    cases(
      u(x_0 + Delta x_0, y_0 + Delta y_0) - u(x_0, y_0) = A_1 Delta x - A_2 Delta y + overbracket(o_1 (sqrt((Delta x)^2 + (Delta y)^2)),  o_1 (abs(Delta z))),
      v(x_0 + Delta x_0, y_0 + Delta y_0) - v(x_0, y_0) = A_2 Delta x + A_1 Delta y + overbracket(o_2 (sqrt((Delta x)^2 + (Delta y)^2)),  o_1 (abs(Delta z)))
    ) =>\
    => u "и" v "диффференцируемы в" (x_0, y_0) "(т.к. получено определение) и " \
    A_1 = u^'_x (x_0, y_0) quad A_2 = v^'_x (x_0, y_0) quad A_2 = - u^'_y (x_0, y_0) quad A_1 = v^'_y (x_0, y_0)\
    "Кроме того" f^' (z_0) = A_1+ i A_2 = u^'_x (x_0, y_0) + i v^'_x (x_0, y_0)
  $
]
2. ($arrow.l.double$) - просто предыдущий пункт задом-наперёд