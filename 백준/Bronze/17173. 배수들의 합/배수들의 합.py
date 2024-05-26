import sys


def read_line():
    return sys.stdin.readline()


N, M = map(int, read_line().split())
nums_m = list(map(int, read_line().split()))
nums_all = list(range(N+1))
answer = 0
visited = set()
for num in nums_m:
    if num in visited:
        continue
    factor = 1
    while num * factor <= N:
        temp = num * factor
        answer += nums_all[temp]
        nums_all[temp] = 0
        factor += 1
print(answer)
