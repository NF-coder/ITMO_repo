include ./general.fth

: diff ( xt F: x eps -- f' )
  \ DS: (xt F) | FP: x eps  

  >r                               \ DS: | FP: x eps | R: (xt F)

  fsafe-add r@ fcorrupting-execute \ DS: | FP: x eps f(x+eps) | R: (xt F)

  frot frot
  fsafe-sub r@ fcorrupting-execute \ DS: | FP: f(x+eps) x eps f(x-eps) | R: (xt F)
  frot fdrop frot                  \ DS: | FP: eps f(x-eps) f(x+eps)  | R: (xt F)
  
  fswap f-                         \ DS: | FP: eps (f(x+eps)-f(x-eps)) | R: (xt F)

  fswap ftwice f/                  \ DS: | FP: (f(x+eps)-f(x-eps))\(2*eps) | R: (xt F)

  rdrop ;                          \ DS: | FP: (f(x+eps)-f(x-eps))\(2*eps) | R:


: fix-eps-diff ( F: eps -- diff-fn )
  create f,               \ сохраняем eps
  does> ( xt F: x -- f' )
    f@                    \ FP: x eps
    diff ;                \ вызываем diff