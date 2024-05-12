import sys


def read_line():
    return sys.stdin.readline()


M = int(read_line())
ratio = 1
direction = True
for _ in range(M):
    a, b, s = map(int, read_line().split())
    if s == 1:
        direction = not direction
    ratio = ratio / a * b
print(f"{0 if direction else 1} {int(ratio)}")
