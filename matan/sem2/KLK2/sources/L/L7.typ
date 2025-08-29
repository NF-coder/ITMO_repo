#set page(width: 20cm, height: auto, fill: color.hsl(288.46deg, 100%, 89.8%), margin: 15pt)
#set align(left + top)
= Л7. Об ортогональности системы тригонометрических функций

Пусть $k, m in NN$. Тогда справедливы следующие соотношения:  

$ integral_(-pi)^pi sin k x cos m x d x = integral_(-pi)^pi 1 dot cos k x d x = integral_(-pi)^pi 1 dot sin k x d x = 0 $

$ integral_(-pi)^pi sin k x sin m x d x = integral_(-pi)^pi cos k x cos m x d x = 0, quad k != m $

$ integral_(-pi)^pi sin^2 k x d x = integral_(-pi)^pi cos^2 k x d x = pi, quad integral_(-pi)^pi 1^2 d x = 2pi $

*Доказательство.* Доказательство проводится прямым вычислением и остается в качестве упражнения.