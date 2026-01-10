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

#include "tasks/task1.1.typ"

#line(length: 100%)

#include "tasks/task1.2.typ"

#line(length: 100%)

#include "tasks/task2.typ"