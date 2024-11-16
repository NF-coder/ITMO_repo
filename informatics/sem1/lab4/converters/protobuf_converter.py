from .AST.AST import AST

class Converter(): # GOVNOKOD
    def __init__(self):
        self.AST_Builder = AST(False).main

    def main(self, file: str) -> str:
        out = 'syntax = "proto3";\n\n'

        AST = self.AST_Builder(file)

        def rec(data: dict):
            KEY, VALUE = data.Tree.name, data.Tree.children

            struct_buffer = []
            data_buffer = []

            for elem in VALUE:
                elem_children = elem.Tree.children

                if len(elem_children) == 1 and len(elem_children[0].Tree.children) == 0:
                    type_name = elem.Tree.name[0].upper() + elem.Tree.name[1:]
                    struct_buffer.append({"param_type": elem.Tree.name.lower(), "type": type_name})
                    continue
                else: data_buffer.append(rec(elem))
            
            out_structure_buffer = []
            for elem in struct_buffer:
                REPEATED = struct_buffer.count(elem) > 1 
                _ = f"{'repeated 'if REPEATED else ""}string {elem['param_type']}"
                
                if _ not in out_structure_buffer: out_structure_buffer.append(_)
            out_structure_buffer = [elem + f" = {idx+1};" for idx,elem in enumerate(out_structure_buffer)]
            out_msg_buffer_1 = f"message {KEY[0].upper() + KEY[1:]}" + "{"
            for elem in out_structure_buffer: out_msg_buffer_1 += f"\n\t{elem}"
            
            _, _1 = [], []
            for elem in data_buffer:
                if elem["OM_Buffer"] not in _: _.append(elem["OM_Buffer"])
                _1.append(elem["OM_Buffer"])

            out_msg_buffer_2 = out_msg_buffer_1
            for idx, elem in enumerate(_):
                out_msg_buffer_2 += "\n"
                out_msg_buffer_2 += f"\n\t{"repeated " if _1.count(elem) > 1 else ""}{elem["type"]}{idx} {elem["type"].lower()}{idx} = {len(out_structure_buffer)+idx+1};"
                out_msg_buffer_2 += f"\n\t{"\n\t".join(elem["data"].split("\n"))}".replace(elem["type"], f"{elem["type"]}{idx}")
            else: out_msg_buffer_2 += "\n}"

            return {
                f"{KEY}": list(struct_buffer),
                "OM_Buffer": {
                    "data": out_msg_buffer_2,
                    "type": f"{KEY[0].upper() + KEY[1:]}"
                }
            }
        return out + str(rec(AST.Tree.children[0])["OM_Buffer"]["data"])