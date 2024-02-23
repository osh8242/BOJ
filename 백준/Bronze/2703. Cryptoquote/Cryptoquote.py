import sys


def readline():
    return sys.stdin.readline().strip()


T = int(readline())
for _ in range(T):
    message = readline()
    code = list(readline())
    answer = []
    for ch in message:
        value = ord(ch)
        if value > 64:
            answer.append(code[value - 65])
        else:
            answer.append(ch)
    print(''.join(answer))
