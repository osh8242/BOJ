import sys


def read_line():
    return sys.stdin.readline().strip()


n, m = map(int, read_line().split())
for _ in range(n):
    print(read_line()[::-1])
    