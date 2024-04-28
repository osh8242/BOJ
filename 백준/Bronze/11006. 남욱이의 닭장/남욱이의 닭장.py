import sys


def read_line():
    return sys.stdin.readline()


T = int(read_line())
for _ in range(T):
    N, M = map(int, read_line().split())
    cut_leg = M * 2 - N
    print(cut_leg, M - cut_leg)
