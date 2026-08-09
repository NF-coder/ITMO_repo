#import "../marks.typ": unimportant-mark

#set page(width: 20cm, height: auto, fill: color.hsl(197.14deg, 71.43%, 90.39%), margin: 15pt)
#set align(left + top)

= (GPT) Интеграл функции комплексной переменной. Способы вычисления при заданной параметризации. Длина кривой, оценка сверху для интеграла по кривой.

*Опред. (Интеграл по кривой)*  
Пусть $gamma: [a, b] -> CC$ — кусочно-гладкая кривая, а функция $f$
непрерывна на $gamma$. Тогда
$
  integral_gamma f(z) d z = integral_a^b f(gamma(t)) · gamma'(t) d t
$
*Опред. (Длина кривой):*  
Длина кривой $gamma$ определяется формулой $L(gamma) = integral_a^b abs(gamma'(t)) d t$\
*Теорема (Оценка интеграла):*  
$
  abs(integral_gamma f(z) d z)
  <= max_(z in gamma) abs(f(z)) dot L(gamma)
$

Док-во:\
Имеем
$
  abs(integral_gamma f(z) d z) = abs(integral_a^b f(gamma(t)) dot gamma'(t) d t)\
  <= integral_a^b abs(f(gamma(t))) · abs(gamma'(t)) d t "(по неравенству треугольника)"\
  <= max_(t in [a, b]) abs(f(gamma(t))) dot integral_a^b abs(gamma'(t)) d t
$
Откуда
$
  abs(integral_gamma f(z) d z) <= max_(z in gamma) abs(f(z)) · L(gamma)
$
