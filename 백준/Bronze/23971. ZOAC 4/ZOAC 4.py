import sys


def read_line():
    return sys.stdin.readline()


def get_count(width, space):
    answer = width // space
    if width % space != 0:
        answer += 1
    return answer


H, W, N, M = map(int, read_line().split())
print(get_count(H, N + 1) * get_count(W, M + 1))
