import sys


def read_line():
    return sys.stdin.readline()


n, T = map(int, read_line().split())
answer = 0
total_time = 0
times = list(map(int, read_line().split()))
for i in range(n):
    if total_time + times[i] <= T:
        answer += 1
        total_time += times[i]
    else:
        break
print(answer)