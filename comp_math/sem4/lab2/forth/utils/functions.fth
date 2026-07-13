include ./ext-math/general.fth

\ f(x) = 4.45x^3 + 7.81x^2 - 9.62x - 8.17
\ TODO: оптимизировать перемножение x - его можно делать последовательно
: f1 ( F: x -- x f )
  fdup                       \ saving x
  fdup fdup f* f* 4.45e f*   \ 4.45*x^3
  fover fdup f* 7.81e f* f+  \ +7.81*x^2
  fover 9.62e f* f-          \ -9.62*x
  8.17e f- ;                 \ -8.17

\ f(x) = x**2
: f0 ( F: x -- x f )
  fdup fdup f* ;