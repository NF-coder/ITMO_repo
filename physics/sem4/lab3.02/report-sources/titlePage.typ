
#let group = state("group", "0.0.0")
#let students = state("students", "Иванов Иван")
#let teacher = state("teacher", "Ландау Л.Д.")
#let date_of_admission = state("date_of_admission", "01.01.1970")
#let date_of_completance = state("date_of_completance", "01.01.1970")
#let work_acceptor = state("work_acceptor", "Ландау Л.Д.")
#let lab_id = state("lab_id", "0.00")
#let lab_title_first_row = state("lab_title_first_row", "Теоретический минимум Ландау")
#let lab_title_second_row = state("lab_title_second_row", "электродинамика сплошных сред")
// Header
#block[
  #v(-1cm)
  #align(center)[
    #columns(2, gutter: -20pt)[
      #align(center)[
        #set text(size:11pt)
        *Университет ИТМО \
        Физико-технический мегафакультет \
        Физический факультет*
      ]
      #colbreak()
      #align(center)[
        #image("assets/itmo.png")
      ]
      
    ]
  ]
  #line(length: 100%, stroke: 2pt)
]

// Student info
#block[
  #align(center)[
    #columns(2, gutter: 10pt)[
      #align(left)[
        Группа  #box(baseline: 3pt)[#place(dy:-13pt)[#context group.get()] #line(end:(168pt, 0pt)) ]  \ \
        Студент #box(baseline: 3pt)[#place(dy:-13pt)[#context students.get()] #line(end:(163pt, 0pt))] \ \
        Преподаватель #box(baseline: 3pt)[#place(dy:-13pt)[#context teacher.get()] #line(end:(120pt, 0pt))] \ \
      ]
      #colbreak()
      #align(center)[
        К работе допущен #box(baseline: 3pt)[#place(dy:-13pt)[#context date_of_admission.get()] #line(end:(95pt, 0pt)) ] \ \
        Работа выполнена #box(baseline: 3pt)[#place(dy:-13pt)[#context date_of_completance.get()] #line(end:(100pt, 0pt))] \ \
        Отчет принят #box(baseline: 3pt)[#place(dy:-13pt)[#context work_acceptor.get()] #line(end:(130pt, 0pt))] \ \
      ]
    ]
  ]
]

// Title
#block[
  #set text(size: 20pt)
  #pad(left:60pt, right: 60pt)[
    #align(center)[
      *Рабочий протокол и отчет по лабораторной работе № #context lab_id.get()*
    ] 
  ] 
  #v(10pt)
  #box()[#line(length: 100%) #place(center,dy: -20pt)[#context lab_title_first_row.get()]]
  #v(10pt)
  #box()[#line(length: 100%) #place(center,dy: -20pt)[#context lab_title_second_row.get()]]
]




