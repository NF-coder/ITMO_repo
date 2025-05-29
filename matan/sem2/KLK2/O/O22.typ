#set page(width: 20cm, height: auto, fill: color.hsl(197.14deg, 71.43%, 90.39%), margin: 15pt)
#set align(left + top)
= О22. Ядро Дирихле

Преобразуем частичную сумму ряда Фурье в комплексной форме к более удобному виду:

$ T_n (x) = sum_(k=-n)^n c_k (f) e^(i k x) 
= sum_(k=-n)^n (1/(2 pi) integral_(-pi)^pi f(t) e^(-i k t) d t) e^(i k x) 
= 1/(2 pi) integral_(-pi)^pi f(t) sum_(k=-n)^n e^(i k (x-t)) d t $

Отдельно рассмотрим сумму (при $e^(i p) != 1$ $<=>$ $p != 2 pi k$, $k in ZZ$):

$ D_n (p) = sum_(k=-n)^n e^(i k p) 
= sum_(k=-n)^n (e^(i p))^k 
= (e^(-i p n) (1 - e^(i p (2n+1))))/(1 - e^(i p)) 
= (e^(-i p n) - e^(i p (n+1)))/(1 - e^(i p)) $

Разделим числитель и знаменатель на $e^(i p/2)$, получим:

$ D_n (p) = (e^(-i p (n+1/2)) - e^(i p (n+1/2)))/(e^(-i p/2) - e^(i p/2)) 
= (sin((n + 1/2) p))/(sin(p/2)) $

При $e^(i p) = 1$, очевидно, $D_n (p) = 2n + 1$. Итого,

$ D_n (p) = cases(
  (sin((n + 1/2) p))/(sin(p/2)) quad quad p != 2 pi k k in ZZ,
  2n + 1  quad quad "иначе"
) $

Введем следующее определение.

Функция $D_n (p)$ называется ядром Дирихле.