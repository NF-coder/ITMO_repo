#set page(
  margin: 1.5cm,
  numbering: "1"
)
#set par(justify: true)
#set text(
  lang: "ru",
  size: 12pt,
  font: "New Computer Modern",
)


#show math.cases: math.display

#show link: it => underline(text(fill: dark_blue)[#it])

#include "titlePage.typ"


#pagebreak()


// БЛОК С ЗАДАНИЯМИ

#include "task1/main.typ"

#line(length: 100%)

#include "task2/main.typ"

#line(length: 100%)

#include "task3/main.typ"

#line(length: 100%)

#include "task4/main.typ"

#line(length: 100%)

#include "task5/main.typ"

#line(length: 100%)

#include "task6/main.typ"