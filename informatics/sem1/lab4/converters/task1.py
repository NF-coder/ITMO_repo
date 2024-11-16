import json
from .AST.AST import AST

class Converter():
    def __init__(self, pretty: bool = True):
        self.AST_Builder = AST().main
        self.pretty = pretty

    def main(self, file: str) -> str:
        AST = self.AST_Builder(file)
        if self.pretty:
            return json.dumps(
                AST,
                indent=4,
                ensure_ascii=False
            )
        return str(AST).replace("'", '"')