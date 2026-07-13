include ../utils/ext-math/general.fth


: newton_step { W: fn W: df F: eps F: a -- x }
  a fn fcorrupting-execute
  a fn df execute
  f/
  a fswap f- 
;


: newton { W: fn W: df F: eps F: a -- x }
  begin
    \ проверка |f(x)| < eps
    a fn fcorrupting-execute fabs eps f>   
  while
    fn df eps a newton_step
    to a
  repeat
  a
;