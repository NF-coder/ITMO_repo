import itertools
import math
import random
from collections import defaultdict

# -----------------------------
# Task 1: TSP (Variant 10)
# -----------------------------
# Distance matrix from "Коммивояжер_варианты.pdf", Variant 10
DIST = [
    [0, 11, 10, 10, 6],
    [11, 0, 4, 4, 5],
    [10, 4, 0, 6, 3],
    [10, 4, 6, 0, 4],
    [6, 5, 3, 4, 0],
]

CITY_NAMES = ["1", "2", "3", "4", "5"]


def tsp_length(route):
    total = 0
    for i in range(len(route) - 1):
        total += DIST[route[i]][route[i + 1]]
    total += DIST[route[-1]][route[0]]
    return total


def brute_force_tsp():
    start = 0
    best_route = None
    best_len = math.inf
    for perm in itertools.permutations(range(1, len(DIST))):
        route = [start] + list(perm)
        length = tsp_length(route)
        if length < best_len:
            best_len = length
            best_route = route
    return best_route, best_len


def init_population(pop_size):
    base = list(range(1, len(DIST)))
    pop = []
    for _ in range(pop_size):
        individual = base[:]
        random.shuffle(individual)
        pop.append(individual)
    return pop


def individual_length(individual):
    route = [0] + individual
    return tsp_length(route)


def tournament_select(population, k=3):
    sample = random.sample(population, k)
    return min(sample, key=individual_length)


def ordered_crossover(p1, p2):
    n = len(p1)
    i, j = sorted(random.sample(range(n), 2))
    child = [None] * n
    child[i:j+1] = p1[i:j+1]

    fill = [x for x in p2 if x not in child]
    pos = 0
    for idx in range(n):
        if child[idx] is None:
            child[idx] = fill[pos]
            pos += 1
    return child


def mutate_swap(individual, p=0.2):
    if random.random() < p:
        i, j = random.sample(range(len(individual)), 2)
        individual[i], individual[j] = individual[j], individual[i]


def run_ga(generations=250, pop_size=60, elite_size=4, mutation_p=0.25, seed=42):
    random.seed(seed)
    population = init_population(pop_size)

    best = min(population, key=individual_length)
    best_len = individual_length(best)
    history = [best_len]

    for _ in range(generations):
        population = sorted(population, key=individual_length)
        next_pop = [ind[:] for ind in population[:elite_size]]

        while len(next_pop) < pop_size:
            p1 = tournament_select(population)
            p2 = tournament_select(population)
            child = ordered_crossover(p1, p2)
            mutate_swap(child, p=mutation_p)
            next_pop.append(child)

        population = next_pop
        cur_best = min(population, key=individual_length)
        cur_best_len = individual_length(cur_best)
        if cur_best_len < best_len:
            best = cur_best[:]
            best_len = cur_best_len
        history.append(best_len)

    return [0] + best, best_len, history


def route_to_names(route):
    return " -> ".join(CITY_NAMES[i] for i in route + [route[0]])


# -----------------------------
# Task 2: ACO shortest path A->G
# -----------------------------
# Graph from "Варианты заданий Алгоритм «Муравьиная колония».pdf" (variant table)
# Undirected weighted graph
GRAPH = {
    "A": {"B": 4, "C": 14, "E": 4},
    "B": {"A": 4, "G": 32},
    "C": {"A": 14},
    "D": {"E": 7, "F": 6, "G": 18},
    "E": {"A": 4, "D": 7},
    "F": {"D": 6, "G": 6},
    "G": {"B": 32, "D": 18, "F": 6},
}


def path_length(path):
    return sum(GRAPH[path[i]][path[i+1]] for i in range(len(path)-1))


def dijkstra(start, goal):
    dist = {node: math.inf for node in GRAPH}
    prev = {node: None for node in GRAPH}
    dist[start] = 0
    unvisited = set(GRAPH)

    while unvisited:
        u = min(unvisited, key=lambda x: dist[x])
        unvisited.remove(u)
        if u == goal or dist[u] == math.inf:
            break

        for v, w in GRAPH[u].items():
            alt = dist[u] + w
            if alt < dist[v]:
                dist[v] = alt
                prev[v] = u

    path = []
    cur = goal
    while cur is not None:
        path.append(cur)
        cur = prev[cur]
    path.reverse()
    return path, dist[goal]


def choose_next(current, visited, pheromone, alpha, beta):
    neighbors = [n for n in GRAPH[current] if n not in visited]
    if not neighbors:
        return None

    scores = []
    for n in neighbors:
        tau = pheromone[(current, n)] ** alpha
        eta = (1.0 / GRAPH[current][n]) ** beta
        scores.append(tau * eta)

    total = sum(scores)
    r = random.random() * total
    acc = 0.0
    for n, s in zip(neighbors, scores):
        acc += s
        if acc >= r:
            return n
    return neighbors[-1]


def run_aco(start="A", goal="G", ants=60, iterations=120, alpha=1.0, beta=2.5,
            rho=0.25, q=100.0, seed=42):
    random.seed(seed)

    pheromone = defaultdict(lambda: 1.0)
    for u in GRAPH:
        for v in GRAPH[u]:
            pheromone[(u, v)] = 1.0

    best_path = None
    best_len = math.inf

    for _ in range(iterations):
        paths = []

        for _a in range(ants):
            current = start
            visited = {start}
            path = [start]

            while current != goal:
                nxt = choose_next(current, visited, pheromone, alpha, beta)
                if nxt is None:
                    path = None
                    break
                path.append(nxt)
                visited.add(nxt)
                current = nxt

            if path is None:
                continue

            length = path_length(path)
            paths.append((path, length))

            if length < best_len:
                best_len = length
                best_path = path

        for edge in list(pheromone.keys()):
            pheromone[edge] *= (1.0 - rho)
            if pheromone[edge] < 1e-8:
                pheromone[edge] = 1e-8

        for path, length in paths:
            delta = q / length
            for i in range(len(path) - 1):
                u, v = path[i], path[i+1]
                pheromone[(u, v)] += delta
                pheromone[(v, u)] += delta

    return best_path, best_len


if __name__ == "__main__":
    print("=== Задание 1: Коммивояжер, вариант 10 ===")
    exact_route, exact_len = brute_force_tsp()
    ga_route, ga_len, ga_hist = run_ga()

    print(f"Точное решение (перебор): {route_to_names(exact_route)}")
    print(f"Длина точного маршрута: {exact_len}")
    print(f"ГА (лучший найденный): {route_to_names(ga_route)}")
    print(f"Длина маршрута ГА: {ga_len}")
    print(f"Длина в начале/в конце ГА: {ga_hist[0]} -> {ga_hist[-1]}")

    print("\n=== Задание 2: Муравьиная колония A -> G ===")
    d_path, d_len = dijkstra("A", "G")
    aco_path, aco_len = run_aco()

    print(f"Проверка (Дейкстра): {' -> '.join(d_path)}, длина = {d_len}")
    print(f"ACO (лучший найденный): {' -> '.join(aco_path)}, длина = {aco_len}")

    print("\nПроверка ключевых маршрутов вручную:")
    candidates = [
        ["A", "B", "G"],
        ["A", "E", "D", "G"],
        ["A", "E", "D", "F", "G"],
    ]
    for c in candidates:
        print(f"{' -> '.join(c)} = {path_length(c)}")
