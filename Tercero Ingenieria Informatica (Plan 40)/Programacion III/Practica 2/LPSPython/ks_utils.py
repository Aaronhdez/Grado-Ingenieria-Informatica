from collections import namedtuple

Item = namedtuple("Item", ['index', 'value', 'weight', 'ratio'])

# Routine used in my_tests.py to read input-data from a string!
def from_data_to_items(input_data):
    lines = input_data.split('\n')

    first_line = lines[0].split()
    item_count = int(first_line[0])
    capacity = int(first_line[1])

    items = []
    for i in range(1, item_count + 1):
        line = lines[i]
        parts = line.split()
        items.append(Item(i - 1, int(parts[0]), int(parts[1])))

    return items,capacity
    
def total_weight(items, taken):
    weight = 0
    for item in items:
        if taken[item.index]== 1:
            weight += item.weight
    return weight
    
def check_solution(capacity, items, taken):
    weight = 0
    value = 0
    for item in items:
        if taken[item.index]== 1:
            weight += item.weight
            value += item.value
    if weight> capacity:
        print("solución incorrecta, se supera la capacidad de la mochila (capacity, weight):", capacity, weight)
        return 0
    return value

def taken_items (items, taken):
    
    def get_taken_list(taken):
        result = []
        for j in range(0, len(taken)):
            if taken[j]: result.append(j)
        return result

    items.sort(key=lambda x: getattr(x, 'index'), reverse=False)
    return get_taken_list(taken)
