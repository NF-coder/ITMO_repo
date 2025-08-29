#set page(width: 20cm, height: 6cm, fill: color.hsl(197.14deg, 71.43%, 90.39%), margin: 15pt)
#set align(left + top)
= +О23. Условия Дини

Говорят, что функция $f: U(x) -> RR$ удовлетворяет в точке $x in RR$ условиям Дини, если:

1. Существуют односторонние пределы $f(x +- 0)$ функции $f$ в точке $x$.

2. Интегралы

$ integral_(0)^delta abs((f(x - t) - f(x - 0))/t) d t, quad integral_(0)^delta abs((f(x + t) - f(x + 0))/t) d t $

сходятся при некотором $delta > 0$.