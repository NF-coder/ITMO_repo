#import "@preview/lilaq:0.3.0" as lq


#lq.diagram(
  title: [Функции принадлежности для количества шпаргалок],
  xlabel: $a$, 
  ylabel: $A(a)$,

  width: 350pt,
  height: 200pt,
  
  lq.line(
    (0, 1), (3, 0),
    stroke: (paint: red, thickness: 1.3pt),
     label: [LA]
  ),

  lq.line(
    (2, 0), (4, 1),
    stroke: (paint: blue, thickness: 1.3pt),
     label: [MA]
  ),
  lq.line(
    (4, 1), (6, 0),
    stroke: (paint: blue, thickness: 1.3pt),
  ),

  lq.line(
    (4, 0), (8, 1),
    stroke: (paint: green, thickness: 1.3pt),
     label: [HA]
  )
)


#lq.diagram(
  title: [Функции принадлежности для качества шпаргалок],
  xlabel: $b$, 
  ylabel: $Q(b)$,

  width: 350pt,
  height: 200pt,
  
  lq.line(
    (0, 1), (.4, 0),
    stroke: (paint: red, thickness: 1.3pt),
     label: [LQ]
  ),

  lq.line(
    (.2, 0), (.5, 1),
    stroke: (paint: blue, thickness: 1.3pt),
     label: [MQ]
  ),
  lq.line(
    (.5, 1), (.7, 0),
    stroke: (paint: blue, thickness: 1.3pt),
  ),

  lq.line(
    (.6, 0), (1, 1),
    stroke: (paint: green, thickness: 1.3pt),
     label: [HQ]
  )
)