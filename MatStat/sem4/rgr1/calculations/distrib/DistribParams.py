from dataclasses import dataclass

@dataclass
class UniformDistribParams:
    a: float
    b: float

@dataclass
class NormalDistribParams:
    a: float
    sigma2: float

@dataclass
class ExpDistribParams:
    l: float
    c: float