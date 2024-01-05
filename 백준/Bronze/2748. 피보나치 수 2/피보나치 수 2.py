import sys


def readline():
    return sys.stdin.readline().strip()


N = int(readline())
if N == 0:
    print(0)
elif N == 1:
    print(1)
else:
    temp = [0, 0, 1]
    for _ in range(1, N):
        temp[0] = temp[1]
        temp[1] = temp[2]
        temp[2] = temp[0] + temp[1]
    print(temp[2])