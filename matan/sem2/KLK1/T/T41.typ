#set page(width: 20cm, height: 15.2cm, fill: color.hsv(260.82deg, 19.22%, 100%), margin: 15pt)
#set align(left + top)
= T41\*. Критерий Коши сходимости несобственного интеграла
*Критерий Коши сходимости несобственного интеграла*

Пусть $f in R_"loc" [a, b]$. Для того чтобы интеграл  
$ integral_a^b f d(x) $  
сходился необходимо и достаточно, чтобы  
$ forall epsilon > 0 exists Delta in (a, b) : forall delta_1, delta_2 in (Delta, b) abs( integral_(delta_1)^(delta_2) f d(x) ) < epsilon. $

*Док-во:*

Обозначим  
$ F(omega) = integral_a^omega f d(x). $

Согласно определению, сходимость интеграла равносильна существованию предела функции $F(omega)$ при $omega -> b - 0$. Согласно критерию Коши существования предела функции (теорема 23), это выполнено тогда и только тогда, когда  
$ forall epsilon > 0 exists Delta in (a, b) : forall delta_1, delta_2 in (Delta, b)  space space abs( F(delta_2) - F(delta_1) ) < epsilon. $

Последнее же неравенство, в силу свойств интеграла, переписывается как  
$ abs( F(delta_2) - F(delta_1) ) < epsilon <=> abs( integral_(delta_1)^(delta_2) f d(x) ) < epsilon, $  

откуда и следует требуемое.