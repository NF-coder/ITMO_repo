include utils/functions.fth
include utils/ext-math/diff.fth
include utils/ext-math/cnt_roots.fth

include compute/chord.fth
include compute/newton.fth
include compute/simple_iter.fth

1e-2 fconstant eps
1e-4 fconstant diff_eps
1e-1 fconstant cnt_roots_diff

-2e fconstant a_root_check
10e fconstant b_root_check


cr cr \ redefine skip

diff_eps fix-eps-diff diff_1

3e ' f1 diff_1

." Корней на интервале:" cr 
' f1 a_root_check b_root_check cnt_roots_diff count-roots
.s

cr

\ Метод хорд

." Метод хорд:" cr
fdrop

' f1 eps 0e 2e chord
f.s

\ Метод Ньютона

cr ." Метод Ньютона:" cr
fdrop

' f1 ' diff_1 eps 11e-1 newton
f.s


\ Метод простой итерации
fdrop
cr ." Метод простой итерации:" cr

' f1 ' diff_1 eps 0e 2e simple_iteration
f.s

bye