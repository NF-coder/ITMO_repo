class Node:
    def __init__(self, name: str):
        self.children = []
        self.name = name

class TreeAPI:
    def __init__(self, base: str = "") -> None:
        self.Tree = Node(base)

    def __repr__(self):
        return f"{self.Tree.name}: {self.Tree.children}"

    def read_tree(self): # + some postprocessing
        children = self.Tree.children

        if len(children) == 0: return self.Tree.name        
        out = []
        for child in children: out.append(child.read_tree())
        
        # postprocessing block (delete unused lists)
        if len(out) == 1: out = out[0]
        else:
            buffer = {}
            for elem in out:
                for k,v in elem.items():
                    buffer.setdefault(k, [])
                    buffer[k].append(v)
            
            for elem in buffer:
                if len(buffer[elem]) == 1: 
                    buffer[elem] = buffer[elem][0]
            out = buffer

        return {self.Tree.name: out}
    
    def add_child(self, child_name: str) -> object:
        _ = TreeAPI(child_name)
        self.Tree.children.append(_)
        return _