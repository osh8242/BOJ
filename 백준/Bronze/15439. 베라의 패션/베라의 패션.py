import sys


def read_line():
    return sys.stdin.readline()


n = int(read_line())
print(n * (n - 1))
