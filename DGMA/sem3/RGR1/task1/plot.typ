#import "@preview/elembic:1.1.0" as e
#import "@preview/tiptoe:0.3.1"
#import "@preview/lilaq:0.5.0" as lq

// see: https://lilaq.org/docs/examples/schoolbook-style
#show: lq.set-tick(inset: 1.5pt, outset: 1.5pt, pad: 0.4em)
#show: lq.set-spine(tip: tiptoe.stealth)
#show: e.show_(
  lq.label.with(kind: "y"),
  it => place(bottom + right, dy: -100% - .2em, dx: 50%+3.9em, rotate(90deg, it))
)
#show: e.show_(
  lq.label.with(kind: "x"),
  it => place(left + top, dx: 100% - .9em, dy: -3em, it)
)

#let x = lq.linspace(-10, 10, num: 2000) 

#let xc = lq.linspace(-0.1,0.1, num:100)

#lq.diagram(
    xlabel: $x$, 
    ylabel: $y$,
    width: 300pt,
    height: 300pt,
    
    xlim: (-10, 10),
    ylim: (-10, 10),
    
    xaxis: (position: 0),
    yaxis: (position: 0),


    // top half of graph
    lq.fill-between(x, x => 100 ,y2: x => calc.pow(x,2), fill: tiling(
        size: (4pt, 4pt)
      )[
        #place(line(stroke: 0.6pt + blue, start: (0%, 100%), end: (100%, 0%)))
      ]
    ),
    lq.plot(x, x => calc.pow(x,2), mark: none, color: rgb("#000000")),
    // bottom half of graph
    lq.plot(x, x => -calc.pow(x,2), mark: none,color: rgb("#000000")),
    lq.fill-between(x, x => -100 ,y2: x => -calc.pow(x,2), fill: tiling(
        size: (4pt, 4pt)
      )[
        #place(line(stroke: 0.6pt + blue, start: (0%, 100%), end: (100%, 0%)))
      ]
    ),
    // unincluded axis
    lq.line(
      stroke: (paint: red, dash: "dashed", thickness: 2pt, cap: "round"),
      (0%, 50%), (100%,50%)
    )
  )

  
