import sys


def readline():
    return sys.stdin.readline().strip()


N = int(readline())
B = [0] + list(map(int, readline().split()))
A = [0]
sumOfA = [0]
for i in range(1, N + 1):
    A.append(B[i] * i - sumOfA[i - 1])
    sumOfA.append(sumOfA[i - 1] + A[i])
for i in range(1, N + 1):
    print(A[i], end=" ")