#set page(width: 20cm, height: 5.8cm, fill: color.hsv(260.82deg, 19.22%, 100%), margin: 15pt)
#set align(left + top)
= T8.2\*. Критерий существования интеграла Римана в терминах колебаний (Дарбу)
$
  f in R[a, b] <=> lim_(lambda (tau) -> 0)
  sum_(i=1)^n omega(f. Delta_i) Delta x_i = 0
$
или, что то же самое,
$
  forall epsilon > 0 space
  exists delta > 0:
  forall tau: space lambda (tau) < delta
  sum_(i=1)^n omega(f, Delta_i) Delta x_i < epsilon
$