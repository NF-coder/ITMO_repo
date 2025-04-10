#set page(width: 20cm, height: 7.1cm, fill: color.hsl(197.14deg, 71.43%, 90.39%), margin: 15pt)
#set align(left + top)
= О18. Площадь
\
*Понятие площади.*
).
Функция множеств (функционал) $S: UU -> RR$, заданная на некотором множестве «квадрируемых» подмножеств плоскости, называется площадью, если:
1. $S (A) gt.eq 0, A in UU$\
2. Если $A,B in UU, A inter B = emptyset$, то $A union B in UU$ и\
$
  S(A union B) = S(A) + S(B)
$
3. Площадь прямоугольника со сторонами a, b равна ab
4. Если $A in UU$, $U$ — движение, то $U (A) in UU$ и\
$
  S(U (A)) = S(A)
$