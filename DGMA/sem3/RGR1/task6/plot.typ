#import "@preview/elembic:1.1.0" as e
#import "@preview/tiptoe:0.3.1"
#import "@preview/lilaq:0.5.0" as lq

// see: https://lilaq.org/docs/examples/schoolbook-style
#show: lq.set-tick(inset: 1.5pt, outset: 1.5pt, pad: 0.4em)
#show: lq.set-spine(tip: tiptoe.stealth)
#show: e.show_(
  lq.label.with(kind: "y"),
  it => place(bottom + right, dy: -100% - .2em, dx: 1.6em, rotate(90deg, it))
)
#show: e.show_(
  lq.label.with(kind: "x"),
  it => place(left + top, dx: 100% + .0em, dy: -2em, it)
)

//#show: lq.theme.misty // see: https://lilaq.org/themes

#lq.diagram(
    xlabel: $x$, 
    ylabel: $y$,

    width: 150pt,
    height: 150pt,

    xaxis: (position: 0),
    yaxis: (position: 0),
  
    lq.fill-between(
      (0, 6),
      (0, 0),
      y2: (6, 0),
      fill: tiling(
        size: (10pt, 10pt)
      )[
        #place(line(stroke: 0.7pt + red, start: (0%, 0%), end: (100%, 100%)))
        #place(line(stroke: 0.7pt + red, start: (0%, 100%), end: (100%, 0%)))
      ]
    ),
    
    lq.line(
      (0, 0), (0, 6),
      stroke: (paint: red, thickness: 1.3pt),
      label: [$x=0$]
    ),
    lq.line(
      (0, 0), (6, 0),
      stroke: (paint: green, thickness: 1.3pt),
      label: [$y=0$]
    ),
    lq.line(
      (0, 6), (6, 0),
      stroke: (paint: blue, thickness: 1.3pt),
      label: [$y=6-x$]
    )
  )
