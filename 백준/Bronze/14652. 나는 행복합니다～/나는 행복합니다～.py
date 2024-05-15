import sys


def read_line():
    return sys.stdin.readline()


n, m, k = map(int, read_line().split())
print(k // m, k % m % n)
