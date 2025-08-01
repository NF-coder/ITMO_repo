#set page(fill: color.hsl(16.74deg, 100%, 91.57%), margin: 15pt, height: auto)
#show link: underline
#set text(
  font: "New Computer Modern",
  size: 11pt
)

== Весна '25. Предварительная волна. Вариант 1
\

*1.1 Приведите пример линейной формы в пространстве полиномов*
$
  f(p) = p(a) quad a in RR
$

*1.2 Как найти матрицу билинейной формы в некотором базисе*
$
  {e_i}_1^n " - базис. Тогда матрица билин. формы имеет вид " beta_"ij" = b(e_i, e_j)
$

*1.3 В чйм заключается смысл немого суммирования*\
Если в выражении встречается один и тот же индекс в верхнем и нижнем положении, то по нему подразумевается суммирование от 1 до n (где n — размерность пространства).

*1.4 Как выглядит закон преобразования тензора типа (1, 1)*\
$
  T_j^i — "компоненты тензора типа (1,1) в старом базисе",\
  overline(T_j^i) — "компоненты этого же тензора в новом базисе",\
  P=(P_k^i) — "матрица перехода от старого базиса к новому",\
  Q=P^(-1) — "матрица перехода от нового базиса к старому",\

  overline(T_j^i) = P^i_k T_l^k Q_j^l
$


*1.5 Напишите закон преобразования матрицы оператора при смене базиса*\
Пусть $ phi in "Hom"_K (V,W)$, а в пространствах заданы базисы:\
$ 
  V: quad {e_i}_"i=1"^n {e'_j}_"j=1"^n\
  W: quad {g_k}_"k=1"^m {g'_l}_"l=1"^m
$
Причем известно, что $T = {t_"ij"}$ — матрица перехода из базиса {e} в базис {e'}, а матрица $S = {s_"kl"}$ — матрица перехода из базиса {g} в базис {g'}.\
Матрица оператора при замене базисов преобразуется как $A'_phi = S^"-1"A Tau$

*2.1 Как связаны размерности ядра и образа оператора*\
$
  dim_KK ker phi + dim_KK "Im" phi = dim_KK V
$

*2.2 Найти собственные значения линейного оператора, матрица которого $mat(1,2; 2,1)$*\
$
  det( mat(1-lambda,2; 2,1-lambda) ) = (1-lambda)^2-2^2 = 0\
  (1-lambda-2)(1-lambda+2)=0\
  (-lambda-1)(3-lambda)=0\
  lambda=-1 quad lambda=3
$

*2.3 Cформулируйте спектральную теорему для диаганолизируемого оператора*\
Если линейный оператор A на конечномерном векторном пространстве диагонализируем, то существует такой базис пространства, в котором матрица оператора A является диагональной, и её диагональные элементы — это собственные значения оператора.

*2.4 Определите алегбраические и геометрические кратности собственных чисел оператора, если в жордановом базисе его матрица имеет вид $mat(1,1,0;0,1,1;0,0,1)$*\
$
  "собственное число 1, алгебраическая кратность 3, геометрическая 1"
$

*2.5 Запишите матрицу полинома p(x) от диагональной матрицы A*\
$
  p(A^D_phi) = mat(
    p(lambda_1), 0, dots, 0;
    0, p(lambda_2), dots, 0;
    dots, dots, dots, dots;
    0, 0, dots, p(lambda_i))
$

*3.1 Каким образом из евклидова пространства можно получиль нормированное*\
Евклидово пространство — частный случай нормированного пространства. Чтобы получить нормированное пространство из евклидова, достаточно использовать норму $||x|| = sqrt("⟨x, x⟩")$\

*3.2 Вычислите скалярное произведение векторов $x=(1,2)^T " и " y=(0,3)^T$ в базисе, матрица Грама которого $G=mat(1,1;2,1)$*\
$
  mat(1,2) mat(1,1;2,1) mat(0;3) = mat(5,3) mat(0;3) = 9
$

*3.3 Как найти коэффициенты Фурье вектора в ортонормированном базисе*\
В ортонормированном базисе координаты вектора находятся с помощью скалярного произведения. Если базис ${e_1,e_2 dots,e_n}$ ортонормированный, то для любого вектора v коэффициенты высчитываются как: $ c_i = <v,e_i> $

*3.4 Что такое сигнатура квадратичной формы*\
Сигнатура квадратичной формы - это набор из двух чисел (p, q), где p - число положительных собственных значений, q - число отрицательных собственных значений.

*3.5 Сформулируйте свойства унитарного оператора в комплексном евклидовом пространстве*\
1. изометрия: $⟨psi_x, psi_y⟩ = ⟨x, y⟩$
2. сохранение нормы: $||psi_x|| = ||x||$
3. свойство сопряженного: $psi^† = psi^(-1)$

#pagebreak()

== Весна '25. Предварительная волна. Вариант 2
\

*1.1 Напишите определение линейной формы*\
Линейной формой на пространстве V называется такая
функция $f ": " VV -> KK$, что $forall v_1,v_2 ∈ VV$ ,$forall lambda in KK$ выполняется:\
1. Аддитивность: $f(v_1 + v_2) = f(v_1) + f(v_2)$
2. Однородность: $f(lambda v) = lambda f(v)$

*1.2 Пусть билинейная форма задана своей матрицей $mat(1,4;3,2)$ в некотором базисе. Представьте её в виде суммы симметричной и антисимметричной компонент*\

$
  b_S (x, y) = 1/2 (mat(1,4;3,2) + mat(1,3;4,2))\
  b_S (x, y) = 1/2 mat(2,7;7,4)\
  b_S (x, y) = mat(1,3.5;3.5,2)\
  \
  b_"AS" (x, y) = 1/2 (mat(1,4;3,2) - mat(1,3;4,2))\
  b_"AS" (x, y) = 1/2 mat(0,1;-1,0)\
  b_"AS" (x, y) = mat(0,0.5;-0.5,0)\
  \
  b (x,y) = b_S + b_"AS" = mat(1,3.5;3.5,2) + mat(0,0.5;-0.5,0) = mat(1,4;3,2)
$

*1.3 Что является тензором линейной формы*\
Линейная форма $phi in VV^*$ является ПЛФ валентности (1, 0)\
Тензором полилинейной валентности (1, 0) является $T_0^1(VV)$\
Таким образом тензором линейной формы является ковариантный тензор ранга 1 — элемент сопряжённого пространства $VV^*$.

*1.4 Как может быть найден определитель квадратной матрицы с помощью символа Леви-Чевита*\
Пусть матрица A имеет размерность nxn, тогда
$ 
  det A = epsilon_(i_1, i_2, dots i_n) a_1^(i_1) a_2^(i_2) dots a_n^(i_n)
$

*1.5 Матрица линейного оператора $phi$ в базисе $e_1, e_2$ некоторого линейного пространства является матрица $mat(-3,1;2,-1)$. Найдите матрицу линейного оператора базисе $e'_1 = e_2 , e'_2 = e_1 + e_2$*\
$
  mat(0,1; 1,1)^(-1) mat(-3,1;2,-1) mat(0,1; 1,1)\
  mat(-1,1;1,0) mat(-3,1;2,-1) mat(0,1; 1,1) \
  mat(-2,3; 1,-2)
$

*2.1 Что такое ядро линейного оператора?*\
Ядро линейного оператора $A: VV -> WW$ — это множество всех векторов из пространства $VV$, которые оператор $A$ переводит в нулевой вектор пространства $WW$
$ ker A={v in VV | A v=0_WW } $

*2.2 Сформулируйте определение собственного вектора и собственного значения оператора A*\
Ненулевой вектор $x in VV$ называется собственным вектором оператора $phi$, если $phi x = lambda x$. Число $lambda in KK$ называется при этом собственным значением  оператора $phi$, отвечающим собственному вектору $x$.

*2.3 Сформулируйте критерии диагонализируемости оператора А*\
1. Оператор A диагонализируем тогда и только тогда, когда для каждого его собственного значения $lambda$ алгебраическая и геометрическая кратности равны
2. Характеристический многочлен раскладывается на линейные сомножители, то есть все его корни лежат в поле $KK$

*2.4 Определите алегбраические и геометрические кратности собственных чисел оператора, если в жордановом базисе его матрица имеет вид $mat(0,1,0; 0,0,0; 0,0,1)$*\
$
  "собственное число 0, алгебраическая кратность 2, геометрическая 1"\
  "собственное число 1, алгебраическая кратность 1, геометрическая 1"
$

*2.5 Запишите матрицу полинома p(x) от диагональной матрицы A*\
$
  p(A^D_phi) = mat(
    p(lambda_1), 0, dots, 0;
    0, p(lambda_2), dots, 0;
    dots, dots, dots, dots;
    0, 0, dots, p(lambda_i))
$

*3.1 Какое пространство называется комплексным евклидовым пространством?*\
Линейное пространство X над $CC$ называется комплексным евклидовым пространством, если на нем заданаметрическая форма $g(x, y) = ⟨x, y⟩$ со следующими свойствами:
1. $⟨x, alpha y_1 + beta y_2⟩ = alpha ⟨x, y_1⟩ + beta ⟨x, y_2⟩$ - линейность по второму аргументу
2. $⟨x, y⟩ = overline(⟨y, x⟩)$ - эрмитовость
3. $⟨x, x⟩ gt.eq 0, ⟨x, x⟩ = 0 <=> x = 0$

*3.2 Приведите пример скалярного произведения в пространстве квадратных матриц*\
$ ⟨A, B⟩=tr(A^T B) $

*3.3 Как найти ортогональный проектор на подпространство, если задан ортонормированный базис*\
$
  P_L (x) = sum_(i=1)^k ⟨x, e_i⟩ e_i
$
где $e_i$ — ортонормированный базис подпространства L

*3.4 Запишите нормальный вид квадратичной формы в $RR$, если её сигнатура $(r_+, r_-)=(2,3)$*\
$
  Q(x) = x_1^2 + x_2^2 - x_3^2 - x_4^2 - x_5^2
$

*3.5 Каким свойством обладает матрица эрмитова оператора в ортонормированном базисе*\
Если оператор T является эрмитовым, то в любом ортонормированном базисе его матрица A удовлетворяет:
$ A=A^* $
где $A^*$ — эрмитово сопряжённая

#pagebreak()

== Весна '25. Предварительная волна. Вариант 3
\

*1.1 Приведите пример линейной формы в пространстве геометрических векторов*\
$
  f(v) = ⟨a, v⟩ quad a - "фиксированный вектор"
$

*1.2 Как найти антисимметричную компоненту билинейной формы*\
$
  b^"AS" (x, y) = 1/2 (b(x, y) - b(y, x))\
  B^"AS" = 1/2 (B - B^T)\
$

*1.3 Какой валентностью обладает полилинейная форма валентности (p,q) после операции свёртки*\
$
  (p-1, q-1)
$

*1.4 Дайте определение символа Леви-Чевита*\
$
  epsilon_(i j k) = cases(
    +1 "если (i,j,k) - чётная перестановка",
    -1 "если (i,j,k) - нечётная перестановка",
    0 "иначе (есть повторяющиеся индексы)"
)
$

*1.5 Напишите определение матрицы линейного оператора $AA$ в базисе ${e_1, e_2, dots, e_n}$*\
Матрицей линейного оператора $AA$ в этом базисе называется квадратная матрица A=($a_(i j)$) размера n×n, элементы которой определяются следующим образом:
$
  A(e_j)=sum_(i=1)^n a_(i j) e_i " для " j=1,2,dots,n
$

*2.1 Что такое ядро линейного оператора*\
Ядро линейного оператора $A: VV -> WW$ — это множество всех векторов из пространства $VV$, которые оператор $A$ переводит в нулевой вектор пространства $WW$
$ ker A={v in VV | A v=0_WW } $

*2.2 Найти собственные значения линейного оператора, матрица которого $mat(1,2; 2,1)$*\
$
  det( mat(1-lambda,2; 2,1-lambda) ) = (1-lambda)^2-2^2 = 0\
  (1-lambda-2)(1-lambda+2)=0\
  (-lambda-1)(3-lambda)=0\
  lambda=-1 quad lambda=3
$

*2.3 Сформулируйте критерии диагонализируемости оператора А*\
1. Оператор A диагонализируем тогда и только тогда, когда для каждого его собственного значения $lambda$ алгебраическая и геометрическая кратности равны
2. Характеристический многочлен раскладывается на линейные сомножители, то есть все его корни лежат в поле $KK$

*2.4 Сформулируйте основную теорему о структуре нильпотентного оператора*\
Пусть N — нильпотентный оператор на $VV$. Тогда существует разложениепространства $VV$ в прямую сумму циклических подпространств этого оператора $VV = ⊕UU_i$. Количество слагаемых в таком разложении равно $dim ker N$ .

*2.5 Запишите матрицу полинома p(x) от диагональной матрицы A*\
$
  p(A^D_phi) = mat(
    p(lambda_1), 0, dots, 0;
    0, p(lambda_2), dots, 0;
    dots, dots, dots, dots;
    0, 0, dots, p(lambda_i))
$

*3.1 Сформулируйте определение метрического тензора*\
Пусть g - метрическая форма. Тогда совокупность чисел $g_(i j) = g(e_i, e_j)$ называется метрическим тензором.

*3.2 Пусть $x_1$ и $x_2$ - ортогональные векторы. При каких $alpha$ и $beta$ выполняетсяравентво $alpha x_1 = beta x_2$* \
При $alpha = beta = 0$

*3.3 Какое подпространство называют ортогональным дополнением*\
Ортогональным дополнением пространства L называется множество
$M = {x in X : x perp L}$

*3.4 Какому необходимому и достаточному условию должны удавоетворять главные миноры отрицательно определённой квадратичной формы*\
$
  (-1)^k D_k > 0 quad "для всех " k = 1,2,dots,n
$
где $D_k$ — определитель $k×k$-го верхнего левого блока (ведущего главного минора)

*3.5 Сформулируйте определение унитарного оператора*\
Пусть $psi$ — опертор в евклидовом пространстве $X_EE (K)$ является унитарным, если сооблюдается хотя-бы одно (а как следствие и все остальные) из свойств:
1. изометрия: $⟨psi_x, psi_y⟩ = ⟨x, y⟩$
2. сохранение нормы: $||psi_x|| = ||x||$
3. свойство сопряженного: $psi^† = psi^(-1)$

#pagebreak()

== Весна '25. Предварительная волна. Вариант 4
\

*1.1 Напишите определение линейной формы*\
Линейной формой на пространстве V называется такая
функция $f ": " VV -> KK$, что $forall v_1,v_2 ∈ VV$ ,$forall lambda in KK$ выполняется:\
1. Аддитивность: $f(v_1 + v_2) = f(v_1) + f(v_2)$
2. Однородность: $f(lambda v) = lambda f(v)$

*1.2 Пусть билинейная форма задана своей матрицей $mat(2,-2;-1,1)$ в некотором базисе. Представьте её в виде суммы симметричной и антисимметричной формы*\
$
  b_S = 1/2 (mat(2,-2;-1,1) + mat(2,-1;-2,1))\
  b_S = 1/2 mat(4,-3;-3,2)\
  b_S = mat(2,-1.5;-1.5,1)\
  \
  b_"AS" = 1/2 (mat(2,-2;-1,1) - mat(2,-1;-2,1))\
  b_"AS" = 1/2 mat(0,-1;1,0)
  b_"AS" = mat(0,-0.5;0.5,0)
  \
  b = b_S + b_"AS" = mat(2,-1.5;-1.5,1) + mat(0,-0.5;0.5,0)
$

*1.3 В чйм заключается смысл немого суммирования*\
Если в выражении встречается один и тот же индекс в верхнем и нижнем положении, то по нему подразумевается суммирование от 1 до n (где n — размерность пространства).

*1.4 Как выглядит закон преобразования тензора типа (2, 0)*\
$
  T^(i j) — "компоненты тензора T в старом базисе",\
  overline(T^(p q)) — "компоненты этого же тензора в новом базисе",\
  P=(P_k^i) — "матрица перехода от старого базиса к новому",\

  overline(T^(p q)) = P^i_p P^j_p Q^(i j)
$

*1.5 Матрицей линейного оператора $phi$ в базисе $e_1, e_2$ некоторого линейного пространства является матрица $mat(1,4;-3,0)$. Найдите матрицу линейного оператора базисе $e'_1 = 2e_1 , e'_2 = e_2$*\
$
  mat(2,0; 0,1)^(-1) mat(1,4;-3,0) mat(2,0; 0,1)\
  mat(0.5,0;0,1) mat(1,4;-3,0) mat(2,0; 0,1) \
  mat(1,2; -6,0)
$\

*2.1 Какую размерность имеет образ оператора $phi$, определённого в $RR^4$, если размерность ядра равна 2*\
2

*2.2 Сформулируйте определение собственного вектора и собственного значения оператора A*\
Ненулевой вектор $x in VV$ называется собственным вектором оператора $phi$, если $phi x = lambda x$. Число $lambda in KK$ называется при этом собственным значением  оператора $phi$, отвечающим собственному вектору $x$.

*2.3 Сформулируйте спектральную теорему для диаганолизируемого оператора *\
Если линейный оператор A на конечномерном векторном пространстве диагонализируем, то существует такой базис пространства, в котором матрица оператора A является диагональной, и её диагональные элементы — это собственные значения оператора.

*2.4 Определите алгебраические и геометрические кратности собственных чисел оператора если в жордановом базисе его матрица имеет вид $mat(0,1,0; 0,0,0; 0,0,1)$*\
$
  "собственное число 0, алгебраическая кратность 2, геометрическая 1"\
  "собственное число 1, алгебраическая кратность 1, геометрическая 1"
$

*2.5 Найдите $e^A$ если $A = mat(1,1,0,0; 0,1,0,0; 0,0,1,1; 0,0,0,1)$ *\
$
  e^A = mat(e,e,0,0; 0,e,0,0; 0,0,e,e; 0,0,0,e)
$

*3.1 Сформулируйте определение метрического тензора*\
Пусть g - метрическая форма. Тогда совокупность чисел $g_(i j) = g(e_i, e_j)$ называется метрическим тензором.

*3.2 Приведите пример скалярного произведения в пространстве квадратных матриц*\
$ ⟨A, B⟩=tr(A^T B) $

*3.3 Какое подпространство называют ортогональным дополнением*\
Ортогональным дополнением пространства L называется множество
$M = {x in X : x perp L}$

*3.4 Запишите квадратичную форму по её матрице $mat(6,0,-1; 0,1,-4; -1,-4,0)$*\
$
  q(x) = 6 x_1 x_1 -2 x_1 x_3 + x_2 x_2 - 8 x_2 x_3 = 6 x_1^2 + x_2^2 - 2 x_1 x_3 - 8 x_2 x_3
$

*3.5 Сформулируйте свойства спектра ортогонального оператора в вещественном евклидовом пространстве*\
1. Модуль всех собственных значений равен 1
2. Ортогональный оператор диагонализируем над $RR$

#pagebreak()

== Весна '25. Предварительная волна. Вариант 5
\

*1.1 Что из себя представляют элементы сопряжённого пространства*\
Элементы сопряжённого пространства $V^*$ — это линейные формы (или ковекторы), то есть все линейные отображения вида
$phi: V -> FF$
где $V$ — ваше исходное векторное пространство над полем $FF$

*1.2 Дайте определение квадратичной формы на линейном пространстве V*\
Квадратичной формой на линейном пространстве V называется отображение q(v), построенное из билинейной формы b(x, y) следующим образом:
$
  q: VV -> KK, q(v) = b(v, v), forall v in VV
$

*1.3 Сколько различных тензоров можно образовать с помощью свёртки тензора типа (2,2)*\
4

*1.4 Какими свойствами обладает символ Кронакера*\
1. Симметричность
2. В случае ДПСК справедливо свойство: $delta_(i j) a^j = a_i$

*1.5 Матрицей линейного оператора $phi$ в базисе $e_1, e_2$ некоторого линейного пространства является матрица $mat(1,4;-3,0)$. Найдите матрицу линейного оператора базисе $e'_1 = 2e_1 , e'_2 = e_2$*\
$
  mat(2,0; 0,1)^(-1) mat(1,4;-3,0) mat(2,0; 0,1)\
  mat(0.5,0;0,1) mat(1,4;-3,0) mat(2,0; 0,1) \
  mat(1,2; -6,0)
$\

*2.1 Что такое ядро линейного оператора*\
Ядро линейного оператора $A: VV -> WW$ — это множество всех векторов из пространства $VV$, которые оператор $A$ переводит в нулевой вектор пространства $WW$
$ ker A={v in VV | A v=0_WW } $

*2.2 Найти собственные значения линейного оператора, матрица которого $mat(1,2; 2,1)$*\
$
  det( mat(1-lambda,2; 2,1-lambda) ) = (1-lambda)^2-2^2 = 0\
  (1-lambda-2)(1-lambda+2)=0\
  (-lambda-1)(3-lambda)=0\
  lambda=-1 quad lambda=3
$

*2.3 Линейный оператор $f$ линейного пространства $L^2$ в базисе $e_1, e_2$ задан матрицей $mat(4,-2;1,1)$. Выясниите, является ли он диагонализируем*\
$
  det(A - lambda I) = det(mat(4-lambda, -2; 1,1-lambda)) = 0\
  det(A- lambda I) = (4-lambda)(1-lambda) + 2 = 0\
  4 - lambda - 4 lambda + lambda^2 + 2 = 0\
  6 - 5 lambda + lambda^2 = 0 \ 
  lambda_1 = 2 "(алг. крат. 1)" quad lambda_2 = 3 "(алг. крат. 1)"\
  \
  A-2I = mat(2,-2; 1,-1) => "одна строка линейно зависима" => dim ker = 2-1 => "геом. крат. 1"\
  A-3I = mat(1,-2; 1,-2) => "одна строка линейно зависима" => dim ker = 2-1 => "геом. крат. 1"
$
Да, является

*2.4? Опишите 2 подхода к формированию жорданова базиса*\
Подход через цепочки обобщённых собственных векторов
1. Находим собственные значения $lambda$ из характеристического уравнения.
2. Для каждого $lambda$ строим последовательность ядер: $ker(A - lambda I),ker(A - lambda I)^2,dots$
3. Выбираем векторы из разности ядер: $ker(A - lambda I)^k \/ ker(A - lambda I)^(k-1)$
4. Для каждого такого вектора строим цепочку: $v,(A - lambda I)v,dots,(A-lambda I)^(k-1)v$
5. Объединяя все цепочки, получаем Жорданов базис

Подход через разложение на инвариантные подпространства
1. Разбиваем пространство в сумму обобщённых собственных подпространств $V=⨁V_lambda$
2. В каждом $V_lambda$ находим циклические векторы — такие, чьи образы под действием A порождают инвариантное подпространство
3. Строим базисы:$ {v,A v,A^2 v,dots}$
4. Полученные базисы соответствуют Жордановым блокам

*2.5 Что такое операторный полином?*\
Операторный полином — это полином, в котором переменная заменена на линейный оператор.

*3.1 Приведите произвольный пример нормы в пространстве квадратных матриц *\
$ ||A||=sqrt(sum_(i=1)^n sum_(j=1)^n a_(i j)^2) $

*3.2 Приведите пример скалярного произведения в пространстве полиномов степени не выше 3 *\
$
  (f,g) = integral_0^1 f(x) g(x) d x 
$

*3.3 Как найти ортогональный проектор на подпространство, если задан ортонормированный базис*\
$
  P_L (x) = sum_(i=1)^k ⟨x, e_i⟩ e_i
$
где $e_i$ — ортонормированный базис подпространства L

*3.4 Какому необходимому и достаточному условию должны удавоетворять главные миноры отрицательно определённой квадратичной формы*\
$
  (-1)^k D_k > 0 quad "для всех " k = 1,2,dots,n
$
где $D_k$ — определитель $k×k$-го верхнего левого блока (ведущего главного минора)

*3.5 Сформулируйте свойства унитарного оператора в комплексном евклидовом пространстве*\
1. изометрия: $⟨psi_x, psi_y⟩ = ⟨x, y⟩$
2. сохранение нормы: $||psi_x|| = ||x||$
3. свойство сопряженного: $psi^† = psi^(-1)$