#set page(width: 20cm, height: 10.5cm, fill: color.hsv(260.82deg, 19.22%, 100%), margin: 15pt)
#set align(left + top)
= T5. Теорема о разложении дроби на простейшие
\
*О разложении дроби на простейшие*
Пусть
$
  (P_n (x))/(Q_m (x))
$
– рациональная дробь, причем
$
  Q_m (x) = (x - a_1)^(k_1) dot dots dot (x - a^p)^(k_p) dot (x_2 + p_1 x + q_1)^(l_1) dot dots dot (x^2 + p_m x + q_m)^(l_m)
$
где при $i in {1, 2, dots, p}, j in {1, 2, dots, m}$
$
  a_i in RR, space k_i in NN, space l_j in NN, space p^2_j - 4q_j < 0
$
Тогда существует единственное разложение вида
$
  (P_n (x))/(Q_m (x)) = R_(n-m) (x) + sum_(i=1)^p sum_(j=1)^(k_i) (A_(i j))/((x-a_i)^(k_i - j + 1)) + sum_(i=1)^m sum_(j=1)^(l_i)(B_(i j) + C_(i j))/((x^2 + p_i x + q_i)^(l_i - j + 1))
$

где все коэффициенты в числителе дробей справа – вещественные числа.