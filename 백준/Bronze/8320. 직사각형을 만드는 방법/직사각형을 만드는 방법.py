import sys


def readline():
    return sys.stdin.readline().strip()


N = int(readline())
answer = 0
for i in range(1, N + 1):
    for j in range(i, N // i + 1):
        answer += 1
print(answer)

