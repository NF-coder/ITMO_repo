#set page(width: 20cm, height: 22cm, fill: color.hsl(253.71deg, 71.43%, 90.39%), margin: 15pt)
#set align(left + top)
= +T6. Радикальный признак Коши
Пусть $a_k > 0$ и  

$ lim_(k -> infinity) root(k, a_k) = l in [0, +infinity] $

Тогда:  
1. Если $l > 1$, то ряд с общим членом $a_k$ расходится.  
2. Если $l < 1$, то ряд с общим членом $a_k$ сходится.  

*Доказательство.*  
1. Докажем первый пункт. В силу того, что верхний предел — это частичный предел (лемма 29), найдется подпоследовательность $a_(k_n)$ такая, что  

$ lim_(n -> infinity) root(n, a_(k_n)) = l $

Так как $l > 1$, то, начиная с некоторого номера $n_0$, выполняется  

$ root(n, a_(k_n)) > 1 => a_(k_n) > 1 $

Отсюда следует, что $a_(k_n)$ не стремится к нулю, а значит не выполнено необходимое условие сходимости ряда (теорема 128), и ряд с общим членом $a_k$ расходится.  

2. Докажем второй пункт. Положим $ε = (1 - l)/2$. По свойству верхнего предела,  

$ exists k_0 : forall k > k_0 root(k, a_k) < l + (1 - l)/2 = (l + 1)/2 < 1 $

Действительно, иначе мы могли бы из последовательности $root(k,a_k)$ выделить подпоследовательность, все члены которой больше, чем $(l + 1)/2$, а значит ее верхний предел был бы не меньше, чем $(l + 1)/2 > l$, что противоречит условию. Из полученного неравенства приходим к тому, что при $k > k_0$ выполняется  

$ a_k < ((l + 1)/2)^k $

Так как ряд  

$ sum_(k=k_0+1)^infinity ((l+1)/2)^k $

сходится как геометрическая прогрессия со знаменателем меньше единицы (пример 90), то по признаку сравнения (теорема 130) сходится и ряд  

$ R_(k_0) = sum_(k=k_0+1)^infinity a_k $

а значит (теорема 82) сходится и исходный ряд.