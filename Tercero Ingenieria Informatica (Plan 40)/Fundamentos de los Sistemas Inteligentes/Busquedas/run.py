# Search methods

import search

ab = search.GPSProblem('A', 'B'
                       , search.romania)
ah = search.GPSProblem('A', 'H'
                       , search.romania)

node, count = search.breadth_first_graph_search(ab)
print('Busqueda por BFS')
print(node.path(), end='')
print('\nNodos visitados: ' + str(count) + '\n')

node, count = search.depth_first_graph_search(ab)
print('Busqueda por DFS')
print(node.path(), end='')
print('\nNodos visitados: ' + str(count) + '\n')

# Parte 1
node, count = search.branch_and_bound_search(ab)
print('Busqueda por Branch and Bound')
print(node.path(), end='')
print('\nNodos visitados: ' + str(count) + '\n')

# Parte 2
node, count = search.branch_and_bound_SubEstimation_search(ab)
print('Busqueda por Branch and Bound subestimada (heurística)')
print(node.path(), end='')
print('\nNodos visitados: ' + str(count) + '\n')

# Result:
# BFS
# [<Node B>, <Node F>, <Node S>, <Node A>] : 211 + 99 + 140 = 450
# DFS
# [<Node B>, <Node P>, <Node C>, <Node D>, <Node M>, <Node L>, <Node T>, <Node A>] : 101 + 138 + 120 + 75 + 70 + 111 + 118 = 733
# BNB
# [<Node B>, <Node P>, <Node R>, <Node S>, <Node A>] : 101 + 97 + 80 + 140 = 418

## PRUEBAS PROPIAS

print('PRUEBA 2: Oradea a Eforie')

oe = search.GPSProblem('O', 'E'
                       , search.romania)

node, count = search.depth_first_graph_search(oe)
print('Busqueda por DFS')
print(node.path(), end='')
print('\nNodos visitados: ' + str(count) + '\n')

node, count = search.breadth_first_graph_search(oe)
print('Busqueda por BFS')
print(node.path(), end='')
print('\nNodos visitados: ' + str(count) + '\n')

# Parte 1
node, count = search.branch_and_bound_search(oe)
print('Busqueda por Branch and Bound')
print(node.path(), end='')
print('\nNodos visitados: ' + str(count) + '\n')

# Parte 2
node, count = search.branch_and_bound_SubEstimation_search(oe)
print('Busqueda por Branch and Bound subestimada (heurística)')
print(node.path(), end='')
print('\nNodos visitados: ' + str(count) + '\n')

print('PRUEBA 3: Zerind a Craiova')

zc = search.GPSProblem('Z', 'C'
                       , search.romania)

node, count = search.depth_first_graph_search(zc)
print('Busqueda por DFS')
print(node.path(), end='')
print('\nNodos visitados: ' + str(count) + '\n')

node, count = search.breadth_first_graph_search(zc)
print('Busqueda por BFS')
print(node.path(), end='')
print('\nNodos visitados: ' + str(count) + '\n')

# Parte 1
node, count = search.branch_and_bound_search(zc)
print('Busqueda por Branch and Bound')
print(node.path(), end='')
print('\nNodos visitados: ' + str(count) + '\n')

# Parte 2
node, count = search.branch_and_bound_SubEstimation_search(zc)
print('Busqueda por Branch and Bound subestimada (heurística)')
print(node.path(), end='')
print('\nNodos visitados: ' + str(count) + '\n')

print('PRUEBA 4: Dobreta a Neant')

dn = search.GPSProblem('D', 'N'
                       , search.romania)

node, count = search.depth_first_graph_search(dn)
print('Busqueda por DFS')
print(node.path(), end='')
print('\nNodos visitados: ' + str(count) + '\n')

node, count = search.breadth_first_graph_search(dn)
print('Busqueda por BFS')
print(node.path(), end='')
print('\nNodos visitados: ' + str(count) + '\n')

# Parte 1
node, count = search.branch_and_bound_search(dn)
print('Busqueda por Branch and Bound')
print(node.path(), end='')
print('\nNodos visitados: ' + str(count) + '\n')

# Parte 2
node, count = search.branch_and_bound_SubEstimation_search(dn)
print('Busqueda por Branch and Bound subestimada (heurística)')
print(node.path(), end='')
print('\nNodos visitados: ' + str(count) + '\n')

print('PRUEBA 5: Timisoara a Giurgiu')

tg = search.GPSProblem('T', 'G'
                       , search.romania)

node, count = search.depth_first_graph_search(tg)
print('Busqueda por DFS')
print(node.path(), end='')
print('\nNodos visitados: ' + str(count) + '\n')

node, count = search.breadth_first_graph_search(tg)
print('Busqueda por BFS')
print(node.path(), end='')
print('\nNodos visitados: ' + str(count) + '\n')

# Parte 1
node, count = search.branch_and_bound_search(tg)
print('Busqueda por Branch and Bound')
print(node.path(), end='')
print('\nNodos visitados: ' + str(count) + '\n')

# Parte 2
node, count = search.branch_and_bound_SubEstimation_search(tg)
print('Busqueda por Branch and Bound subestimada (heurística)')
print(node.path(), end='')
print('\nNodos visitados: ' + str(count) + '\n')