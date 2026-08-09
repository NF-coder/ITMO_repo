#set page(width: 20cm, height: auto, fill: color.hsl(288.46deg, 100%, 89.8%), margin: 15pt)
#set align(left + top)
= Л9\*. Лемма Римана


Пусть $f in R_("loc" (a, b))$ и  

$ integral_a^b |f| d x < +infinity $

Тогда  

$ integral_a^b f(x) e^(lambda x) d x -->_(|lambda| -> +infinity) 0 ", " quad lambda in RR $

*Доказательство.*
Для начала заметим, что если $f(x) = c$ — некоторая константа и $ (a, b)$ — ограниченный промежуток, то  

$ integral_a^b c e^(i lambda x) d x = c ( integral_a^b cos lambda x d x + i integral_a^b sin lambda x d x ) =  
c ( (sin lambda b - sin lambda a)/lambda - i (cos lambda b - cos lambda a)/lambda ) -->_(|lambda| -> +infinity) 0 $

и утверждение теоремы выполнено. Сведем общий случай к данному.  

Для начала покажем, что $forall epsilon > 0$ найдется отрезок $ [delta_1, delta_2] subset [a, b]$, что  

$ abs( integral_a^b f(x) e^(i lambda x) d x - integral_(delta_1)^(delta_2) f(x) e^(i lambda x) d x |) < epsilon quad forall lambda in RR $

Согласно условию (об абсолютной сходимости интеграла), можно найти числа $delta_1$ и $delta_2$, $delta_1 < delta_2$ такие что  

$ integral_a^delta_1 |f(x)| d x < epsilon/2 "," quad integral_delta_2^b |f(x)| d x < epsilon/2 $

Далее, для найденных $delta_1 $ и $delta_2 $

$ abs( integral_a^b f(x) e^(i lambda x) d x - integral_(delta_1)^(delta_2) f(x) e^(i lambda x) d x ) =  
abs( integral_a^delta_1 f(x) e^(i lambda x) d x + integral_delta_2^b f(x) e^(i lambda x) d x ) <= $

$ integral_a^delta_1 |f(x)| |e^(i lambda x)| d x + integral_delta_2^b |f(x)| |e^(i lambda x)| d x =  
integral_a^delta_1 |f(x)| d x + integral_delta_2^b |f(x)| d x < epsilon/2 + epsilon/2 = epsilon $

Так как $f in R[delta_1, delta_2]$, то существует разбиение $tau$ отрезка $[delta_1, delta_2]$ на отрезки $delta_i$, $i in {1, dots, n}$, что  

$ 0 <= integral_(delta_1)^(delta_2) f d x - sum_(i=1)^n m_i Delta x_i < epsilon $

где  

$ s_tau(f) = sum_(i=1)^n m_i Delta x_i $

— нижняя сумма Дарбу. Пусть $g(x) = m_i$ при $x in delta_i$ (на общих концах отрезков значения $g$ можно брать любыми), тогда  

$ 0 <= abs( integral_(delta_1)^(delta_2) f(x) e^(i lambda x) d x - integral_(delta_1)^(delta_2) g(x) e^(i lambda x) d x ) =  
abs( integral_(delta_1)^(delta_2) (f(x)-g(x)) e^(i lambda x) d x ) <= $
$ integral_(delta_1)^(delta_2) abs(f(x)-g(x)) |e^(i lambda x)| d x = integral_(delta_1)^(delta_2) (f-g) d x $

так как $f(x) >= g(x)$. Последний интеграл может быть переписан так:  

$ integral_(delta_1)^(delta_2) (f(x)-g(x)) d x = integral_(delta_1)^(delta_2) f(x) d x - integral_(delta_1)^(delta_2) g(x) d x =  
integral_(delta_1)^(delta_2) f(x) d x - s_tau (f) < epsilon $

Итого,  

$ 0 <= abs( integral_(delta_1)^(delta_2) f(x) e^(i lambda x) d x - integral_(delta_1)^(delta_2) g(x) e^(i lambda x) d x ) < epsilon $

Осталось заметить, что  

$ lim_(|lambda| -> +infinity) integral_(delta_1)^(delta_2) g(x) e^(i lambda x) d x =  
lim_(|lambda| -> +infinity) sum_(i=1)^n integral_(x_(i-1))^(x_i) m_i e^(i lambda x) d x = 0 $

где последнее равенство верно в силу того, что слагаемых конечное число, и каждое слагаемое стремится к нулю по доказанному в самом начале. В силу произвольности epsilon, лемма Римана полностью доказана.