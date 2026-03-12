#let lineColor = rgb("#032251")
#show link: it => underline(text(fill: blue)[#it])

#box(height: 80%)[
  #align(center + horizon)[
  #text(size: 30pt)[
    *Software Requirements Specification*
  ]
  #line(length: 100%, stroke: 1pt + lineColor)
  #text(size: 15pt)[
    Для сайта #link("https://gorodrabot.ru/")[gorodrabot.ru]
  ]
]
]
