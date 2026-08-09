include ../utils/ext-math/general.fth


: simple_iter_cond { W: fn W: df F: a F: lambda -- }
  a fn df execute              \ FP: f'(a)

  lambda f*                    \ FP: lambda*f'(a)
  1e f+                        \ FP: 1 + lambda*f'(a)
  fabs 1e f>= if
    ." Условие сходимости нарушено |1 + lambda*f'(x)| >= 1" cr
  then
;

: fmax_fn_value { W: fn F: a F: b F: eps -- max }
  0e { F: max }

  begin
    a b f<=
  while
    a fn fcorrupting-execute fabs        \ |f(x)|
    max fmax to max          \ max = max(max, |f(x)|)
    a eps f+ to a            \ x += eps
  repeat
  max
;

\ Метод простой итерации
\ phi(x) = x + lambda*f(x)
\ где lambda = -1 / min(1/|f'(x)|)
: simple_iteration { W: fn W: df F: eps F: a F: b -- x }  
  \ max(|f'(x)|)
  df a b 1e-2 fmax_fn_value  \ FP: max_df

  \ lambda = -1 / max(|f'|)
  1e fswap f/ fnegate
  f.s bye

  { F: lambda -- }

  \ Проверка условия сходимости
  a fn df lambda simple_iter_cond

  a { F: x }

  begin
    x fn execute fabs eps f>   \ |f(x)| > eps
  while
    x fn execute              \ f(x)
    lambda f*                 
    x f+ to x                
  repeat

  x
;
