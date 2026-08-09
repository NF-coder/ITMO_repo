#import "../marks.typ": unimportant-mark

#set page(width: 20cm, height: auto, fill: color.hsl(197.14deg, 71.43%, 90.39%), margin: 15pt)
#set align(left + top)

= (GPT) Формула Ньютона—Лейбница. Интеграл $integral_gamma z^n dif z$ при целых $n$. 

*Теорема (Формула Ньютона–Лейбница)*  
Если $F$ — первообразная функции $f$ в области $D$
(т.е. $F'(z) = f(z)$),
то для любой кривой $gamma subset D$
с началом в точке $z_1$ и концом в точке $z_2$ выполняется
$
  integral_gamma f(z) d z = F(z_2) - F(z_1)
$
В частности, если кривая $gamma$ замкнута,
то $integral_gamma f(z) d z = 0$

Док-во:\
Пусть $gamma: [a, b] -> D$, $gamma(a) = z_1$, $gamma(b) = z_2$. Тогда
$
  integral_gamma f(z) d z
  = integral_a^b f(gamma(t)) · gamma'(t) d t
  = integral_a^b F'(gamma(t)) · gamma'(t) d t\
  "Но" F'(gamma(t)) · gamma'(t) = d/d t F(gamma(t))
$
Следовательно,
$
  integral_gamma f(z) d z
  = integral_a^b d/d t F(gamma(t)) d t
  = F(gamma(b)) - F(gamma(a))
  = F(z_2) - F(z_1)
$

*Интеграл $integral_gamma z^n d z$:*
- при $n eq.not -1$ функция $z^n$ имеет первообразную
  $z^(n + 1) / (n + 1)$, поэтому интеграл зависит только от концов кривой;
- при $n = -1 quad integral_gamma d z / z = 2 pi i dot "Ind"_gamma(0)$,
  где $"Ind"_gamma(0)$ — индекс обхода (число оборотов) контура $gamma$ вокруг нуля.