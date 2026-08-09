: fcorrupting-execute ( x, xt F -- res )
  execute              \ FP: x f(x)
  fswap fdrop          \ FP: f(x)
;

: f2dup ( a b -- a b a b)
  fover fover
;

: fsafe-add ( a b -- a b res )
  f2dup
  f+
;

: fsafe-sub ( a b -- a b res )
  f2dup
  f-
;

: ftwice ( a -- 2a )
  2e f*
;