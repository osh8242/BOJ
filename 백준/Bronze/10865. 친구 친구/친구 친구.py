import sys


def read_line():
    return sys.stdin.readline()


N, M = map(int, read_line().split())
friendMap = {}
for i in range(1, N+1):
    friendMap[i] = []
for _ in range(M):
    a, b = map(int, read_line().split())
    friendMap[a].append(b)
    friendMap[b].append(a)
for key, value in friendMap.items():
    print(len(value))
