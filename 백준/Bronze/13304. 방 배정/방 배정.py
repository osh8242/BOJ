import sys


def read_line():
    return sys.stdin.readline()


def count_room(n, k):
    return n // k if n % k == 0 else n // k + 1


def get_group(s, y):
    if y == 1 or y == 2:
        return 0
    else:
        if Y == 3 or Y == 4:
            if S == 0:
                return 1
            else:
                return 2
        elif Y == 5 or Y == 6:
            if S == 0:
                return 3
            else:
                return 4


N, K = map(int, read_line().split())
group = [0] * 5
for _ in range(N):
    S, Y = map(int, read_line().split())
    group[get_group(S, Y)] += 1


print(sum([count_room(count, K) for count in group]))
    