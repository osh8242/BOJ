import sys


def calculate_total_wine(C, K, P):
    total_wine = 0
    for n in range(1, C + 1):
        total_wine += K * n + P * n * n
    return total_wine


C, K, P = map(int, sys.stdin.readline().split())
total_wine = calculate_total_wine(C, K, P)
print(total_wine)
