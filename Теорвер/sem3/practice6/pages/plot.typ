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

#let x = lq.linspace(10, 25, num: 6) 
#let y = lq.linspace(110, 250, num: 8) 

//#let xc = lq.linspace(-0.1,0.1, num:100)

#lq.diagram(
  xlabel: $x$, 
  ylabel: $y$,
  width: 300pt,
  height: 300pt,
  
  xlim: (0, 25 + 5),
  ylim: (0, 250 + 20),
  
  xaxis: (position: 0),
  yaxis: (position: 0),

  lq.scatter(
    (10,10,10) + (13,13,13) + (16,16,16) + (19,19,19) + (22,22,22) + (25,25,25),
    (110,130,150) + (130,150,170) + (150,170,190) + (150,170,190) + (190,210,230) + (210,230,250),
    size: 5pt,
    color: red
  ),
  lq.line(
    (0, 67.18), (100, 691.18)
  )
)

  
