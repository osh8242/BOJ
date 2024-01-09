import sys
from itertools import combinations


def calculate_winning_probability(yeondoo, name):
    ref_char_list = ['L', 'O', 'V', 'E']
    count_list = combinations([(yeondoo.count(ch) + name.count(ch)) for ch in ref_char_list], 2)
    answer = 1
    for count in count_list:
        answer *= (count[0] + count[1])
    return answer % 100


readline = sys.stdin.readline
yeondoo = readline().strip()
N = int(readline())
winner_probability = -1
winner_name = "NULL"

for _ in range(N):
    name = readline().strip()
    probability = calculate_winning_probability(yeondoo, name)
    if winner_probability < probability:
        winner_probability = probability
        winner_name = name
    elif winner_probability == probability and winner_name > name:
        winner_name = name

print(winner_name)
