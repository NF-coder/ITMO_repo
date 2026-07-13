include ./general.fth

struct
  float% field x
  float% field fx
end-struct state%

: sign-change? ( f1 f2 -- flag )
  f* 0e f< ;

: count-roots { W: fn F: a F: b F: h -- n }
  \ инициализация состояния
  state% state
  a state x f!  \ state.x = a
  a fn fcorrupting-execute state fx f! drop  \ state.fx = f(a)

  0  \ n
  begin
    state x f@ b f<                 \ пока x < b
  while
    state x f@ h f+                 \ FP: x_next
    fdup fn fcorrupting-execute     \ FP: x_next f(x_next)
    
    \ проверка смены знака
    fdup state fx f@ sign-change? if
      1+
    then

    state fx f!
    state x f!
  repeat

  swap drop
  swap drop
;