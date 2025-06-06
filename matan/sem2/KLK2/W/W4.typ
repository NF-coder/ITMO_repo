#set page(width: 20cm, height: auto, fill: color.hsl(65.63deg, 100%, 93.73%), margin: 15pt)
#set align(left + top)
= +З4\*. Ряд Маклорена для бинома (доказательство при помощи дифференцирования)

Понятно, что если $alpha in NN union {0} $, то заявленное равенство верно при всех $x in RR $, ведь $(1 + x)^alpha $ в этом случае – это просто многочлен.  

Если же $alpha in.not NN $, то заявленное равенство не может выполняться при $x in.not [-1, 1] $, ведь при достаточно большом $n $ производная $f^(n)(x) $ будет бесконечна при $x = -1 $, что противоречит бесконечной дифференцируемости суммы степенного ряда внутри интервала сходимости. В случае, если рассматриваемый ряд сходится либо при $x = -1 $, либо при $x = 1 $, вопрос все так же решается с использованием теоремы 155. Отметим результаты, касающиеся сходимости:  

1. Если $ alpha >= 0$, то рассматриваемый ряд сходится абсолютно при $ x = plus.minus 1$.
2. Если $ alpha in (-1, 0)$, то рассматриваемый ряд сходится условно при $ x = -1$ и расходится при $x = 1 $.  
3. Если $ alpha <= -1$, то рассматриваемый ряд расходится при $ x = plus.minus 1$.  

Выводы о значении суммы ряда во всех этих случаях остаются читателю в качестве упражнения.