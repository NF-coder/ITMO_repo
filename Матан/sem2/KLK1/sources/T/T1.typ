#set page(width: 20cm, height: 10.4cm, fill: color.hsv(260.82deg, 19.22%, 100%), margin: 15pt)
#set align(left + top)
= T1. Теорема о множестве всех первообразных
\
*О множестве всех первообразны*
Пусть F — первообразная функции $f$ на ⟨a, b⟩. Для того чтобы $Phi$ также была
первообразной функции $f$ на ⟨a, b⟩, необходимо и достаточно, чтобы
$
  F (x) - Phi (x) equiv C, 
  space space space
  x in ⟨a, b⟩,
  space space space
  C in RR
$.
*Док-во.*
Докажем необходимость. Пусть $Psi = F - Phi$, где F и $Phi$ — первообразные для $f$ на ⟨a, b⟩. Тогда
$
  Psi'(x) = (F (x) - Phi (x))' = F '(x) - Phi'(x) = f (x) - f (x) = 0, space space forall x in ⟨a, b⟩
$.
Согласно теореме Лагранжа, для любых $x_1, x_2 in ⟨a, b⟩$ таких, что $x_1 < x_2$,
$
  Psi (x_2) - Psi (x_1) = Psi'(xi)(x_2 - x_1) = 0, space space xi in (x_1, x_2)
$.
Значит, $Psi (x) equiv C, C in RR, x in ⟨a, b⟩$.\
Докажем достаточность. Пусть на ⟨a, b⟩ выполнено условие $F - Phi equiv C, C in RR$. Тогда
на этом промежутке $Phi$ = F - C и, к тому же,
$
  Phi' = F' - C' = F' - 0 = F' = f
$.
Тем самым, $Phi$ является первообразной для функции $f$ на ⟨a, b⟩