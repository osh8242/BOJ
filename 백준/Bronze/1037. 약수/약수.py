import sys


def readline():
    return sys.stdin.readline().strip()


N = int(readline())
if N == 1:
    print(int(readline()) ** 2)
else:
    factors = list(map(int, readline().split()))
    max = 1
    min = 1000001
    for factor in factors:
        if factor > max:
            max = factor
        if factor < min:
            min = factor
    print(min * max)
