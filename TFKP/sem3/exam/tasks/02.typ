#import "../marks.typ": unimportant-mark

#set page(width: 20cm, height: auto, fill: color.hsl(197.14deg, 71.43%, 90.39%), margin: 15pt)
#set align(left + top)

= 2. Ряды с комплексными членами, свойства. Предел и непрерывность функции комплексной переменной. Сфера Римана.
*2.1 Сфера Римана*\
Сфера Римана - это сфера, находящаяся в положительном полупространстве относительно плоскости $D_(x y)$, "нанизанная" на ось $z$ и имеющая некий радиус $R$.\
#figure[
 #image("./assets/riman_sphere.jpg", width: 40%)
  #text("Сфера Римана")
]
Если из её верха (его называют северным полюсом) "стрелять" в $D_(x y)$, то каждый луч, исходящий из её северного полюса будет проходить через сферу в какой-либо точке. Таким образом можно определить биективное соответствие между каждой (кроме северного полюcа) точкой на сфере к каждой точкой плоскости. Ну а северный полюс задействуется, если "стрелять" параллельно плоскости $D_(x y)$.\
Таким образом сфера Римана является моелью множества комплексных чисел на компактом множестве.

*2.2 Последовательность комплексных чисел*\
*Опред.*: Это отображение $NN -> CC$\
*Опред. предела последоватьельности:* Число $A in CC$ называется пределом последовательности $z_n$, если $forall epsilon > 0  exists n_0: forall n > n_0 space abs(z_n - A) < epsilon$\
#unimportant-mark[
  Лемма:
  $ 
    z_n = x_n + i y_n, space A = A_1 + A_2\
    lim_(n->infinity)(z_n) = A <=> cases(
      lim_(n-> infinity)(x_n) = A_1,
      lim_(n-> infinity)(y_n) = A_2,
    )
  $
  Док-во:\
  #table(columns: (1fr, 3fr), stroke: none, inset: 2pt,
    [
      #box(image("./assets/t2_2.2_l1.png", width: 100%))
    ],
    [
      Докажем в сторону $=>$
      $
        cases(
          abs(x_n - A_1) <= abs(z_n - A),
          abs(y_n - A_2) <= abs(z_n - A)
        ) space "как катеты п/у теругольника"
      $
      Докажем в сторону $arrow.l.double$
      $
        abs(z_n - A) <= abs(x_n - A_1) + abs(y_n - A_2) "как гипотенуза п/у треугольника"
      $
    ]
  )
]
#unimportant-mark[
  Определение:\
  Говорят, что $z_n$ имеет предел равный $infinity$, если
  $forall epsilon>0 exists n_0: forall n > n_0 abs(z_n - n_0) > 1/epsilon$
]

Свойства последовательности ($lim_(n->infinity)(z_n)=A$):
1. #box[
  $A in overline(CC)$ - единственный\
  Док-во: от противного - если предела два, то есть два "кружочка" вокруг точек, которые начиная с некоторого $epsilon$ не будут пересекаться, но т.к. члены последовательности есть и там и там, то будет противоречие оперделению
]
2. #box[
  $A in CC => z_n space "- ограниченная"$ \
  Док-во:\
  По определению предела:
  $forall epsilon > 0 exists N in NN: forall n > N quad |z_n - A| < epsilon$\
  Возьмём $epsilon = 1$. Тогда для некоторого $N$ при $n > N$ $|z_n - A|< 1 => z_n <= abs(A) + 1$
  Для конечного числа первых членов $z_1, dots, z_N$ положим $M_0 = max(|z_1|, dots, |z_N|)$\
  Тогда $z_n <= max(M_0, 1 + abs(A))$ что и т.д.
]
Свойства последовательности ($lim_(n->infinity)(z_n)=A space "и" space lim_(n->infinity)(omega_n)=B$):
1. #box[
  $lim_(n->infinity)(z_n + omega_n) = A+B$
]
2. #box[
  $lim_(n->infinity)(z_n dot omega_n) = A dot B$
]
3. #box[
  $lim_(n->infinity)(z_n / omega_n) = A/B space (B != 0)$
]
Свойства общего плана:
1. Если $lim_(n->infinity)(z_n) = A => forall n_k space lim_(k->infinity)(z_n_k) = A$
2. Теор. Больцано-Вейштрасса: Если $z_n$ ограниченная, то $exists$ $n_k : lim_(k->infinity)(z_n_k) = A in overline(C)$
3. Критерий Коши: $z_n$ имеет предел в $CC$ $<=> forall epsilon>0 exists n_0: forall n > n_0 forall p in NN space abs(z_(n+p) - z_n) < epsilon$

*Опред. ряда:* $z_n$ - последовательность, ряд это $sum_1^infinity z_n = z_1 + z_2 + dots + z_n + dots$\
*Сумма ряда:* предел последовательности частичных сумм ($lim_(n->infinity)sum_(k=1)^n z_k$)\
Следствие (о сходимости ряда):
$
sum_(k=1)^n z_k in CC <=> cases(
  sum_(k=1)^infinity x_k in RR,
  sum_(k=1)^infinity y_k in RR
) space "где" z_n = x_n + i y_n
$
Свойства рядов:
1. Необходимый признак сходимости: Если $sum z_n$ сходится, то $lim_(n->infinity) z_n = 0$
2. Линейность: Если $sum z_n = S$, $sum w_n = T$, то $sum (alpha z_n + beta w_n) = alpha S + beta T$ для $alpha, beta in CC$
3. Критерий Коши для рядов: $sum z_n$ сходится $<=> forall epsilon > 0 exists N: forall n > N forall p in NN |sum_(k=n+1)^(n+p) z_k| < epsilon$
4. #box[
  Абсолютная сходимость: Ряд $sum z_n$ абсолютно сходится, если $sum |z_n| < infinity$\
  - Абсолютная сходимость $=>$ обычная сходимость
  - $sum |z_n|$ сходится $=>$ $sum |x_n|$ и $sum |y_n|$ сходятся
  Признаки абсолютной сходимости:
  - Признак сравнения: если $|z_n| lt.eq a_n$ и $sum a_n$ сходится, то $sum z_n$ абсолютно сходится
  - Признак Даламбера: если $lim_(n->infinity) |z_(n+1)/z_n| = q < 1$, то ряд абсолютно сходится
  - Признак Коши: если $lim_(n->infinity) root(n,|z_n|) = q < 1$, то ряд абсолютно сходится
]
5. Условная сходимость: Ряд сходится, но не абсолютно (пример: $sum i^n/n$)
*Предел и непрерывность функции комплексной переменной*\
Опр.: $f: CC inter E -> CC$\
$f(x,y) = u(x,y) + i v(x,y) quad (u,v: CC -> RR)$\
*Опр. предела ф-ии:* $f: CC inter E -> CC$ и $z_0$ - предельная для $E$ (точка, любая окрестность которой содержит бесконечно много точек данного множества)\
$ lim_(z->z_0)(f(z))=A in CC <=> forall epsilon > 0 exists delta(epsilon): forall z in EE space <abs(z-z_0)<delta quad abs(f(z) - A) < epsilon $
$
  lim_(z->infinity)(f(z))=A in CC forall epsilon > 0 exists delta(epsilon):forall z in EE abs(z) < 1/delta quad abs(f(z) - A) < epsilon
$
Аналогично для $lim_(z->z_0)(f(z))=infinity$ и $lim_(z->infinity)(f(z))=z_0$\
Лемма:
Пусть $f: CC inter E -> CC$, $z_0$ - предельная для $EE$\
$
  lim_(z->z_0)(f(z))=A in CC <=> cases(
    lim_(x->x_0 space y->y_0) (u(x,y)) = A_1,
    lim_(x->x_0 space y->y_0) (v(x,y)) = A_2
  ) ", где" z_0=x_0 + i y_0 space f = u + i v space A = A_1 + A_2
$
Док-во аналогично док-ву для последовательностей (для $A=infinity$ верно только справа-налево! [можно придумать так, чтобы слева была бесконечность, а справа нет пределов вовсе])\
*Св-ва ф-ий имеющих предел* ($f: CC inter E -> CC$, $z_0$ - предельная для $EE$):
1. #box[Опред. по Гейне\
  $
    lim_(z->z_0)(f(z))=A " где" z_0,A in overline(CC) <==>
    forall z_n: 1) z_n -> z_0 ;space 2) z_n != z_0 ;space  3) z_n in E quad f(z_n) -->_(n->infinity) A
  $
]
2. $A in overline(CC)$ - единственный
3. Если $A in CC$, то $f$ ограничена в некотором круге $abs(z-z_0) <= R$
4. #box[
  Арифметические свойства\
  $lim_(z->z_0)(g(z))=B$ и соотаетствующая операция определена в $overline(CC)$, то
  - $lim_(z->z_0)(f(z) + g(z))=A+B$
  - $lim_(z->z_0)(f(z) dot g(z))=A dot B$
  - $lim_(z->z_0)(f(z) / g(z))=A/B space (g !=0 "в окресности" z_0)$
]
*Опр. непрерывности ф-ии*\
$f "непрерывна в" z_0 "если" forall epsilon > 0 exists delta(epsilon): forall z in E abs(z-z_0) < delta quad abs(f(z) - f(z_0)) < epsilon
$
#unimportant-mark[
  2 ситуации:
  - $z_0$ - предельная для $E$, тогда определение равносильно $lim_(z->z_0) f(z) = f(z_0)$
  - $z_0$ - изолированная, тогда $f(z)$ всегда непрерывна в $z_0$
]
*Опр. непрерывности на множестве:* говорят что $f$ непрерывна на $D$ если $f$ непрерывна во всех точках $D$\
*Св-ва непрерывной ф-ии* $f(x,y) = u(x,y) + i v(x,y) quad (u,v: CC -> RR)$:\
1. #box[
  $f$ непрерывна в $z_0 = x_0 + i y_0 <=> cases(
    R e(f) "неперывна в " (x_0, y_0),
    I m(f) "неперывна в " (x_0, y_0)
  )$\
  Док-во по идее схоже с док-вом для последовательностей
]
2. #box[
  $f,g: E inter CC -> CC$ и непрерывны в $z_0$:
  - $f+g$ непрерывно в $z_0$ 
  - $f dot g$ непрерывно в $z_0$
  - $f/g$ непрерывно в $z_0$ если $g(z_0) != 0$
]
3. #box[
  $f$ непрерывна в $z_0$, $g$ непрерывна в $w_0=f(z_0)$. Тогда $g(f)$ непрерывна в $z_0$
]
4. #box[
  $f in C(K)$ где $K$ - некий отрезок:\
  - $f$ ограничено на $K$
  - $f$ равномерно непрерывно на $K$
]