#set page(width: 20cm, height: 5cm, fill: color.hsl(197.14deg, 71.43%, 90.39%), margin: 15pt)
#set align(left + top)
= О14. Колебание функции на множестве
\
*Понятие колебания*.
Пусть $f: EE -> RR$. Колебанием функции $f$ на множестве $EE$ назовем величину
#let cache1 = $x,y in EE$
$
  omega (f, EE) = 
  sup_cache1 ( f (x) - f (y) )
$