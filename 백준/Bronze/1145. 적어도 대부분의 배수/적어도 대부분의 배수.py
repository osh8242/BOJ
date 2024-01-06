import sys
from itertools import combinations


def getGCD(x, y):
    while y > 0:
        x, y = y, x % y
    return x


def getLCM(x, y):
    return x * y // getGCD(x, y)


input = sys.stdin.readline
nums = list(map(int, input().split()))
combi = list(combinations(nums, 3))
abcLCM = sys.maxsize
for comb in combi:
    a, b, c = comb
    abLCM = getLCM(a, b)
    abcLCM = min(getLCM(abLCM, c), abcLCM)
print(abcLCM)
