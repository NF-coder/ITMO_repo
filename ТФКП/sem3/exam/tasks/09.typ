#import "../marks.typ": unimportant-mark

#set page(width: 20cm, height: auto, fill: color.hsl(197.14deg, 71.43%, 90.39%), margin: 15pt)
#set align(left + top)

= (GPT) Теорема Коши (интеграл по границе треугольника)
*Теорема (Коши для треугольника)*  
Если $f$ голоморфна внутри и на границе треугольника $T$, то
$
  integral_(partial T) f(z) d z = 0
$

Док-во:\
Обозначим $I = integral_(partial T) f(z) d z$.  
Разделим треугольник $T$ на 4 меньших треугольника, соединяя середины сторон.  
Интеграл по границе $T$ равен сумме интегралов по границам меньших треугольников
(внутренние ребра проходят дважды в противоположных направлениях, их вклады сокращаются).  

Выберем из четырёх треугольников тот, для которого модуль интеграла по его границе максимален; обозначим его $T_1$. Тогда
$
  abs(I) <= 4 dot abs(integral_(partial T_1) f(z) d z)
$

Повторяя процесс, получаем последовательность вложенных треугольников $T_n$ таких, что
$
  abs(I) <= 4^n dot abs(integral_(partial T_n) f(z) d z) space "и диаметр" T_n -> 0
$


Пусть $z_0$ — единственная общая точка всех $T_n$.  
Поскольку $f$ голоморфна в $z_0$, имеем\
$f(z) = f(z_0) + f'(z_0) dot (z - z_0) + epsilon(z) dot (z - z_0)$, где $epsilon(z) -> 0$ при $z -> z_0$

Интеграл от линейной функции $f(z_0) + f'(z_0) dot (z - z_0)$ по замкнутому контуру равен 0, поэтому
$
  integral_(partial T_n) f(z) d z = integral_(partial T_n) epsilon(z) dot (z - z_0) d z\
  "Оценим:" abs(integral_(partial T_n) f(z) d z) <= max_(z in partial T_n) abs(epsilon(z)) dot "длина"(partial T_n) dot "диаметр"(T_n)
$
Пусть $L$ — периметр исходного треугольника, тогда
$
  "длина"(partial T_n) = L / 2^n, quad "диаметр"(T_n) <= L / 2^n\
  abs(integral_(partial T_n) f(z) d z) <= max_(z in partial T_n) abs(epsilon(z)) dot L^2 / 4^n\
  abs(I) <= 4^n dot max_(z in partial T_n) abs(epsilon(z)) dot L^2 / 4^n = L^2 dot max_(z in partial T_n) abs(epsilon(z))
$

Поскольку $max_(z in partial T_n) abs(epsilon(z)) -> 0$ при $n -> infinity$, получаем $|I| = 0$
