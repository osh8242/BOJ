import sys


def read_line():
    return sys.stdin.readline()


T = int(read_line())
for _ in range(T):
    hp1, mp1, atk1, def1, hp2, mp2, atk2, def2 = map(int, read_line().split())
    print(max(hp1 + hp2, 1) + 5 * max(mp1 + mp2, 1) + 2 * max(atk1 + atk2, 0) + 2 * (def1 + def2))
