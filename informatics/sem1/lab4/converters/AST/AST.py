from .Tree.Tree import TreeAPI

class AST():
    def __init__(self, to_json: bool = True) -> None:
        self.to_json = to_json

    def main(self, file: str) -> dict:
        file = file.replace(">", ">\n").replace("\n\n", "\n")
        lines = file.split("\n")
        Tree = TreeAPI("root")
        tag_stack = [Tree]

        for line in lines:
            TAG_FLAG = False
            OPEN_TAG, CLOSE_TAG = False, False
            tag_name_cache = ""
            buffer = ""

            if line[:2] == "<?": continue
            
            line = line.replace("\t", "") # удаляем лтшние табы
            
            for idx, sym in enumerate(line): 
                if TAG_FLAG:
                    if line[idx-1] == "<": # перепроверяем начало тэга
                        # флаги типа тэга: открывающий, закрывающий
                        OPEN_TAG, CLOSE_TAG = sym != "/", sym == "/"
                        # тут же добавим символ к имени открывающего тэга т.к. его захватило
                        if OPEN_TAG: tag_name_cache += sym
                    elif sym == ">" or sym == " ":
                        TAG_FLAG = False # отключаем сбор информации о тэге
                        if OPEN_TAG:
                            tag_stack.append(
                                tag_stack[-1].add_child(tag_name_cache)
                            )
                        elif CLOSE_TAG:
                            if buffer != "": tag_stack[-1].add_child(buffer)
                            if buffer == "" and len(tag_stack[-1].Tree.children) == 0: tag_stack[-1].add_child({})
                            buffer = ""
                            tag_stack = tag_stack[:-1]
                    else: tag_name_cache += sym
                
                elif sym == ">": # Inner args parser
                    for arg in buffer.split():
                        key, value = arg.split("=")
                        tag_stack[-1].add_child(key).add_child(value)
                    buffer = ""
                elif sym == "<": TAG_FLAG = True # детектируем начало тэга
                else: buffer += sym

        if self.to_json: return Tree.read_tree()["root"]
        else: return Tree
