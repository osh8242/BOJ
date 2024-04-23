import sys


def read_line():
    return sys.stdin.readline().strip()


T = int(read_line())
for _ in range(T):
    alphabets = read_line()
    is_visit = [False] * 26
    answer = 2015
    for ch in alphabets:
        if not is_visit[ord(ch) - 65]:
            is_visit[ord(ch) - 65] = True
            answer -= ord(ch)
    print(answer)
