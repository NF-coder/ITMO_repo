class Converter():
    def __init__(self, *args, **kwargs): pass

    def main(self, file: str) -> str:
        file = file.replace("\t","").replace("\n", "")

        r = lambda d1,d2: file.replace(d1.replace("\t", ""),d2,1)

        file = r('<?xml version="1.0" encoding="UTF-8"?>', "")
        file = r("<root>", '{\n\t"root":{\n')
        file = r("<schedule>", '\t\t"schedule": [\n')
        file = r("<weeks>", '\t\t\t{\n\t\t\t\t"weeks": {\n')
        file = r("""<num>1</num>
<num>3</num>
<num>5</num>
<num>7</num>
<num>9</num>
<num>11</num>
<num>13</num>
<num>15</num>""".replace("\n", ""), """\t\t\t\t\t"num": [
                        "1",
                        "3",
                        "5",
                        "7",
                        "9",
                        "11",
                        "13",
                        "15"
                    ]\n""")
        file = r("</weeks>", '\t\t\t\t},\n')
        file = r("<lesson>", '\t\t\t\t"lesson": {\n')
        file = r("<name>Программирование</name>", '\t\t\t\t\t"name": "Программирование",\n')
        file = r("<type>Лекция</type>", '\t\t\t\t\t"type": "Лекция",\n')
        file = r("<format>Очно-Дистанционный</format>", '\t\t\t\t\t"format": "Очно-Дистанционный",\n')
        file = r("<time>", '\t\t\t\t\t"time": {\n')
        file = r("<start>8:20</start>", '\t\t\t\t\t\t"start": "8:20",\n')
        file = r("<end>9:50</end>", '\t\t\t\t\t\t"end": "9:50"\n')
        file = r("</time>", '\t\t\t\t\t},\n')
        file = r("<place>", '\t\t\t\t\t"place": {\n')
        file = r("<address>ул.Ломоносова, д.9, лит. М</address>", '\t\t\t\t\t\t"address": "ул.Ломоносова, д.9, лит. М",\n')
        file = r("<classroom>Ауд. Актовый зал (1216/0 (усл))</classroom>", '\t\t\t\t\t\t "classroom": "Ауд. Актовый зал (1216/0 (усл))"\n')
        file = r("</place>", '\t\t\t\t\t},\n')
        file = r("<teacher>Гаврилов Антон Валерьевич</teacher>", '\t\t\t\t\t"teacher": "Гаврилов Антон Валерьевич"\n')
        file = r("</lesson>", '\t\t\t\t}\n')
        file = r("</schedule>", '\t\t\t},\n')
        
        file = r("<schedule>", '\t\t\t{\n')
        file = r("<weeks>", '\t\t\t\t"weeks": {\n')
        file = r("""<num>2</num>
			<num>4</num>
			<num>6</num>
			<num>8</num>
			<num>10</num>
			<num>12</num>
			<num>14</num>
			<num>16</num>""".replace("\n", ""), """\t\t\t\t\t"num": [
                        "2",
                        "4",
                        "6",
                        "8",
                        "10",
                        "12",
                        "14",
                        "16"
                    ]""")
        file = r("</weeks>", '\t\t\t\t},\n')
        
        file = r("<lesson>", '\t\t\t\t"lesson": [\n')
        file = r("<name>Информатика</name>", '\t\t\t\t\t{\n\t\t\t\t\t\t "name": "Информатика",\n')
        file = r("<type>Лекция</type>", '\t\t\t\t\t\t"type": "Лекция",\n')
        file = r("<format>Очно</format>", '\t\t\t\t\t\t"format": "Очно",\n')
        file = r("<time>", '\t\t\t\t\t\t"time": {\n')
        file = r("<start>8:20</start>", '\t\t\t\t\t\t\t"start": "8:20",\n')
        file = r("<end>9:50</end>", '\t\t\t\t\t\t\t"end": "9:50"\n')
        file = r("</time>", '\t\t\t\t\t\t},\n')
        file = r("<place>", '\t\t\t\t\t\t"place": {\n')
        file = r("<address>ул.Ломоносова, д.9, лит. М</address>", '\t\t\t\t\t\t\t"address": "ул.Ломоносова, д.9, лит. М",\n')
        file = r("<classroom>Ауд. Актовый зал (1216/0 (усл))</classroom>", '\t\t\t\t\t\t\t "classroom": "Ауд. Актовый зал (1216/0 (усл))"\n')
        file = r("</place>", '\t\t\t\t\t\t},\n')
        file = r("<teacher>Балакшин Павел Валерьевич</teacher>", '\t\t\t\t\t\t"teacher": "Балакшин Павел Валерьевич"\n')
        file = r("</lesson>", '\t\t\t\t\t},\n')

        file = r("<lesson>", '\t\t\t\t\t{\n')
        file = r("<name>Основы профессиональной деятельности</name>", '\n\t\t\t\t\t\t "name": "Основы профессиональной деятельности",\n')
        file = r("<type>Лекция</type>", '\t\t\t\t\t\t"type": "Лекция",\n')
        file = r("<format>Очно</format>", '\t\t\t\t\t\t"format": "Очно",\n')
        file = r("<time>", '\t\t\t\t\t\t"time": {\n')
        file = r("<start>10:00</start>", '\t\t\t\t\t\t\t"start": "10:00",\n')
        file = r("<end>11:30</end>", '\t\t\t\t\t\t\t"end": "11:30"\n')
        file = r("</time>", '\t\t\t\t\t\t},\n')
        file = r("<place>", '\t\t\t\t\t\t"place": {\n')
        file = r("<address>ул.Ломоносова, д.9, лит. М</address>", '\t\t\t\t\t\t\t"address": "ул.Ломоносова, д.9, лит. М",\n')
        file = r("<classroom>Ауд. Актовый зал (1216/0 (усл))</classroom>", '\t\t\t\t\t\t\t "classroom": "Ауд. Актовый зал (1216/0 (усл))"\n')
        file = r("</place>", '\t\t\t\t\t\t},\n')
        file = r("<teacher>Клименков Сергей Викторович</teacher>", '\t\t\t\t\t\t"teacher": "Клименков Сергей Викторович"\n')
        file = r("</lesson>", '\t\t\t\t\t}\n\t\t\t\t]\n')
        file = r("</schedule>", '\t\t\t}\n\t\t]\n')
        file = r("</root>", '\t}\n}\n')
        return file