#import "titlePage.typ": group, students, teacher, date_of_admission, date_of_completance, work_acceptor, lab_id, lab_title_first_row, lab_title_second_row
#set par(justify: true)
#set text(
  lang: "ru",
  size: 14pt,
  font: "New Computer Modern",
)


#show math.cases: math.display

#show link: it => underline(text(fill: dark_blue)[#it])

// Группа
#context group.update("ПИиКТ 1.3.1")
// Выполнили
#context students.update("Горин,Решетников,Филимонов")
// Преподаватель лаб
#context teacher.update("Сорокина Е.К.")
// Дата выполнения лр
#context date_of_admission.update("13.02.2026")
// Дата сдачи
#context date_of_completance.update("20.02.2026")
// Работу принял
#context work_acceptor.update("")
// Номер лабораторной работы
#context lab_id.update("3.02")
// Название лабораторной работы
#context lab_title_first_row.update("Характеристики источника тока");
#context lab_title_second_row.update("")

#set page(
  margin: 1.5cm,
  numbering: ("1")
)

#include "titlePage.typ"


#show heading: set align(left)
#show heading: set text(size: 14pt)
#set heading(numbering: "1.",)
#set enum(numbering: "  1)")



#include "content.typ"


