#set text(
  lang: "ru",
  size: 11pt,
  font: "New Computer Modern",
)
#set page(
  paper: "a4",
  margin: (top: 1.7cm, bottom: 1.7cm, x: 2cm),
  numbering: "1",
)
#set par(justify: true, leading: 0.7em)
#set heading(numbering: "1.")
#set figure(numbering: "1")
#show heading.where(level: 1): set text(oklch(30%, 0.095, 260deg))
#show heading.where(level: 2): set text(oklch(40%, 0.095, 260deg))
#show heading.where(level: 3): set text(oklch(50%, 0.095, 260deg))
#show heading.where(level: 4): set text(oklch(60%, 0.095, 260deg))

#show link: it => underline(text(fill: blue)[#it])

#let fig(path, caption) = figure(
  image(path, width: 100%),
  caption: caption,
)

#align(center)[
  #text(size: 11pt)[
    Федеральное государственное автономное образовательное учреждение высшего образования \
    «Национальный исследовательский университет ИТМО» \
    Дисциплина «Встроенные системы»
  ]
]

#v(5cm)
#align(center)[
  #text(size: 17pt, weight: "bold")[Лабораторная работа №1] \
  Вариант №1
]

#v(5cm)
#align(right)[
  Выполнил: Решетников С. Е. \
  Проверила: Быковский С. В.
]

#align(center + bottom)[Санкт-Петербург, 2026]

#pagebreak()
= Цель работы
Разработать калькулятор \
Требования:
+ В качестве операндов использовать два числа, каждое из которых от 0 до 9
+ Поддержка операций +, -, \*, /
+ Выбор операции осуществляется посредством клавиши \*
+ Результат вычисления появляется на семисегментном индикаторе после нажатия на \#

= Схема процессов
#figure(
  image("assets/image.png"),
  caption: [Схема процессов (также доступна по #link("//www.plantuml.com/plantuml/png/pLP1Inj16BtlhnXJa0XQg4SF8jXR2pr8Vy2OZ1gwPiFkHB2dPDMsu25OA9GUBAMsvpNDrZKcvY_C_AE-RsVSPjSqmL1e3xlEE3jltlk-zuPi19BxihdlEWiDd-_kSoQ5zvf9loaSfu6bcgnvTQRErKYtrArkC_L9tQX8TLMY8Xtg8ztIfywcLvU-vxh2Nrb_9WwtFUvNrvZwJ7lmQOo_VHKnDRGlzPCs0o9cMB1u-Xqh1nLUlmCeBoqvTKyAvjTsz-GQaRZ4PWAyqHs0XWp38IY4m8-nbAI8bQRlYxe435C9g-nn_sMZogMeEfDvvjJrC8ZKjIKTBJDQ8cx4ak6LCCiXqfsKlA6EnN8jsCmEky_-8jNvWs5pGOPk0meGMCM_1oobC8IYsBaZkRB-cpgmFaBsCGYtr00yte101xYcjA2etwea8uhdEbTbbHXYhjWXNXzqEvMrmzr0B3CT4b2VWLG8x1Rr61EmwTD1s2pgrO8tBbF6bo0KcZxtI00udkgJkMeE47fq9qyyodUZl2laSnv8glgzSfyHc3wprGNngp5ZFB2kketz0oebperdYH_HoRRkASPn8IDiPPtbZYta14te5Dn17ShHOAL7fObjj31elUsbFZAj97CGAZ2w6CLaj6FhoGFkFtbS2xQ4HAMi0ZmdEAb7PmALbMPS0YLdciJlfWx679I0gAWGbZknpYUL20ACHqucOVee9_PRzY5HC_GFkDiKHGvFQq73vOVOybwVffNhPPZPXTHBvoFgBLesszzvFm3WrbOiiWcPNWT0c8p6mEbZZdWcOD9FRHV3Wg69xe109-3R5EHlqdoeIUqefJSSht5iJB8stl35HRQmxNgLLoyQmkSaUKkueYB_NCfp7H83qq9xySRJASzRQTN507byG9Y-PdQdI17897NpLWjI5Z1TDLFdVq_rwknKNs1880HnTNVh_Timh_xLC1TjDbdn5BtZ_iZiFZtqSt2THk0BWc5ltYvse8TPbybYHk46tlHBxXS0")[ссылке])]
)

= Руководство пользователя
+ #box(width:100%)[Введите первое число на клавиатуре. Оно также будет появляться на дисплее по мере ввода
#figure(
  image("assets/image-1.png",height: 20%),
  caption: [На клавиатуре было введено число 12 - первый операнд]
)
]
+ #box(width:100%)[Для завершения ввода первого операнда нажмите "\#"]
+ #box(width:100%)[Далее выберете операцию - сложение, вычитание, умножение, деление. Выбор осуществляется по нажатию "\*", номер соответствующей операции будет на дисплее (0 - сложение, 1 - вычитание, 2 - умножение, 3 - деление)
#figure(
  image("assets/image-2.png",height: 20%),
  caption: [После тройного нажатия "\*" была выбрана операция деления]
)]
+ #box(width:100%)[Введите второй операнд. Он также будет появляться на дисплее по мере ввода
#figure(
  image("assets/image-3.png",height: 20%),
  caption: [На клавиатуре было введено число 2 - второй операнд]
)]
+ #box[Для завершения ввода второго операнда нажмите "\#"]
+ #box(width:100%)[На дисплее высветится результат вычислений
#figure(
  image("assets/image-4.png",height: 20%),
  caption: [Результат - 12/2=6]
)]

= Репозиторий
Код доступен по ссылке: #link("https://github.com/NF-coder/ITMO_repo/tree/main/%D0%92%D1%81%D1%82%D1%80%D0%BE%D0%B9%D0%BA%D0%B8/sem5/lab1")