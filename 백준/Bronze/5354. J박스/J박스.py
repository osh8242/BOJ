import sys


def read_line():
    return sys.stdin.readline()


def get_line(n, is_body):
    return '#' * n if not is_body else '#' + ('J' * (n - 2)) + '#'


T = int(read_line())
for _ in range(T):
    N = int(read_line())
    str = ""
    for i in range(N):
        if i == 0 or i == N-1:
            str += get_line(N, False) + '\n'
        else:
            str += get_line(N, True) + '\n'
    print(str)