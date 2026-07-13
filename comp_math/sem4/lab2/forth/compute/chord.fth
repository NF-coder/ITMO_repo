include ../utils/ext-math/general.fth

: chord_step { W: fn F: a F: b -- x_next}
  \ x_next = b - f(b)*(b-a)/(f(b)-f(a))
  b a f-                    \ FP: (b-a)

  b fn fcorrupting-execute  \ FP: (b-a) f(b)
  a fn fcorrupting-execute  \ FP: (b-a) f(b) f(a)
  f-                        \ FP: (b-a) (f(b)-f(a))

  f/                        \ FP: ((b-a)/(f(b)-f(a)))
  b fn fcorrupting-execute  \ FP: ((b-a)/(f(b)-f(a))) f(b)
  f*                        \ FP: f(b)*((b-a)/(f(b)-f(a)))
  b fswap f-                \ FP: x_next
;


: chord { W: fn F: eps F: a F: b -- x }
  begin
    \ проверка |f(x_next)| < eps
    b fn fcorrupting-execute fabs eps f>
  while
    fn a b chord_step

    \ сдвигаем интервал: a = b, b = x_next
    b to a
    to b
  repeat

  b
;
