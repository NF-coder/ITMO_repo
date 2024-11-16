from .Tree.Tree import TreeAPI
import re

'''
    УПРОЩЁННАЯ ВЕРСИЯ
    НЕ ПОДДЕРЖИИВАЮТСЯ ДАННЫЕ ВНУТРИ ТЭГА!!!
'''

class AST():
    def __init__(self, to_json: bool = True) -> None:
        self.R_TYPE_1 = re.compile(
            r"(?i)((?<=<)[A-z]+)>((.|\n)*?)(</\1>)"
        )
        self.Tree = TreeAPI("root")
        self.to_json = to_json

    def recursive_builder(self, data: str) -> object:

        array = re.findall(self.R_TYPE_1, data)
        for item in array:
            TAG, DATA, _, END = map(str, item)
            self.tag_stack.append(
                self.tag_stack[-1].add_child(TAG)
            )
            self.recursive_builder(DATA)

        if array == [] and data != "": self.tag_stack[-1].add_child(data)
        elif array == [] and data == "": self.tag_stack[-1].add_child({})

        self.tag_stack = self.tag_stack[:-1]

    def main(self, file: str) -> dict:
        self.tag_stack = [self.Tree]
        self.recursive_builder(file)

        if self.to_json: return self.Tree.read_tree()["root"]
        else: return self.Tree