import sys


def getNumGroup(num):
    if num == 0:
        return [0, 0]
    for i in range(1, num + 1):
        count = i * (i + 1) // 2
        if count >= num:
            return [i, count - num]
        else:
            continue


def getSum(info):
    n = info[0]
    return n * (n + 1) * (2 * n + 1) // 6 - n * info[1]


readline = sys.stdin.readline
A, B = map(int, readline().split())
print(getSum(getNumGroup(B)) - getSum(getNumGroup(A - 1)))
