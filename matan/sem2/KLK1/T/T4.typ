#set page(width: 20cm, height: 7cm, fill: color.hsv(260.82deg, 19.22%, 100%), margin: 15pt)
#set align(left + top)
= T4\*.Замена переменной в неопределённом интеграле
\
*Формула замены переменной*
Пусть $f$ имеет первообразную на $⟨a, b⟩, phi: ⟨alpha, beta⟩ → ⟨a, b⟩, phi$ дифференцируема на $⟨alpha, beta⟩$. Тогда 
$
  integral f space d(x) = integral f(phi)phi' space d(t)
$
*Док-во*
Пусть F — первообразная для функции $f$ на ⟨a, b⟩. Тогда, согласно теореме о производной композиции, F($phi$) — первообразная для функции $f(phi)phi'$
на $⟨alpha, beta⟩$, откуда
$
  integral f space d(x) = F + C = F(phi) + C = integral f(phi)phi' space d(t)
$