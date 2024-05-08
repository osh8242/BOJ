import sys


def read_line():
    return sys.stdin.readline()


T = int(read_line())
for _ in range(T):
    x, y = map(int, read_line().split())
    print(f"{ 'NO' if x < y else 'MMM' } BRAINS")
