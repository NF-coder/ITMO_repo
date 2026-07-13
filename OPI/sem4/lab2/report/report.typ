#set text(
  lang: "ru",
  size: 14pt,
  font: "New Computer Modern",
)
#set page(
  margin: 1.5cm,
  numbering: ("1")
)
#set par(justify: true)
#show raw: it => block(
  fill: luma(95%),
  inset: 8pt,
  radius: 4pt,
)[
  #set text(size: 6pt)
  #it
]
#show heading.where(level: 1): set text(oklch(30%, 0.095, 260deg))
#show heading.where(level: 2): set text(oklch(40%, 0.095, 260deg))
#show heading.where(level: 3): set text(oklch(50%, 0.095, 260deg))
#show heading.where(level: 4): set text(oklch(60%, 0.095, 260deg))
#set heading(numbering: "1.")

#include "parts/titlePage.typ"
#pagebreak()
#include "parts/taskPage.typ"
#pagebreak()
#include "parts/conclusionPage.typ"