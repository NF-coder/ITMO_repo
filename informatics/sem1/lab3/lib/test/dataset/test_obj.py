from dataclasses import dataclass
from typing import List, Union, Optional

@dataclass
class Test:
    test: str
    result: str | int

    # Possible flags - IGNORE_ERROR, SPACES_MODE
    flags: Optional[Union[List[str]]] = None