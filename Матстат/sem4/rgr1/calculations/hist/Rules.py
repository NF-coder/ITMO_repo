from sires.SiresInfo import SiresInfo
import math

def scott_rule(info: SiresInfo) -> int:
    h = 3.5 * info.s * info.n**(-1/3)
    k = math.ceil((info.x_max - info.x_min)/h)
    return k

def stredzhes_rule(info: SiresInfo) -> int:
    return 1 + int(math.log2(info.n))

def fridman_dianokis_rule(info: SiresInfo) -> int:
    return math.ceil(2*(info.q75-info.q25)*info.n**(-1/3))