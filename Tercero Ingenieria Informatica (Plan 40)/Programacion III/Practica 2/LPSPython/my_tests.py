import unittest

from ks_utils     import *
from solve_greedy import *

class TestKSP(unittest.TestCase):

    def test_from_data_to_item(self):
        content = """3 10
                    45 5
                    48 8
                    35 3
                    """
        items, capacity = from_data_to_items(content)
        self.assertEqual(10, capacity)
        self.assertEqual([Item(0, 45, 5), Item(1, 48, 8), Item(2, 35, 3)], items)
        return
    
    def test_4(self):
        content = """4 11
                    8 4
                    10 5
                    15 8
                    4 3
                    """
        items, capacity = from_data_to_items(content)
        value, taken = solve_greedy(items, capacity)

        self.assertEqual(19, check_solution(capacity, items, taken))
        self.assertEquals(taken_items(items,taken), [2,3])
        return
