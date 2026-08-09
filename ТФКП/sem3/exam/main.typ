#import "marks.typ": unimportant-mark

#let underline_link(target, body) = {
  link(target)[
    #underline[#body]
  ]
}

#set text(
  font: "New Computer Modern",
  size: 11pt,
  lang: "RU"
)

#set page(width: 20cm, height: auto, margin: 30pt)

#set align(center)
#pad(top: 15pt)[]
= Билеты к экзамену по ТФКП
Сем 3

#pad(top: 15pt)[]

#set align(left + bottom)
Подготовили:\
Решетников Сергей Р3208 
#underline_link("https://t.me/ReshNF")[\@ReshNF]
#link("https://github.com/NF-coder/ITMO_repo", "⭐")\
Лютый Никита K3240
#underline_link("https://t.me/smaf1_1")[\@smaf1_1]
#link("https://github.com/SmaF1-dev", "⭐")\
[Добавляйте себя]

Условные обозначения:\
#box(width: 8pt)[#unimportant-mark[]] - потенциально лишняя информация

#include "tasks/01.typ"
#include "tasks/02.typ"
#include "tasks/03.typ"
#include "tasks/04.typ"
#include "tasks/05.typ"
#include "tasks/06.typ"
#include "tasks/07.typ"
#include "tasks/08.typ"
#include "tasks/09.typ"
#include "tasks/10.typ"
#include "tasks/11.typ"
#include "tasks/12.typ"
#include "tasks/13.typ"
#include "tasks/14.typ"
#include "tasks/15.typ"
#include "tasks/16.typ"
#include "tasks/17.typ"
#include "tasks/18.typ"
#include "tasks/19.typ"
#include "tasks/20.typ"
#include "tasks/21.typ"
#include "tasks/22.typ"
#include "tasks/23.typ"