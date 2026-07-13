
#let unimportant-mark(body) = box(
  rect(
    inset: 4pt,
    fill: oklch(85%, 0.14, 270deg),
    stroke: 0.5pt + luma(100),
    radius: 2pt,
    width: 100%
  )[ #body ]
)