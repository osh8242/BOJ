import sys


def readline():
    return sys.stdin.readline()


aeiou = ('a', 'e', 'i', 'o', 'u')
line = list(readline())
answer = ""
i = 0
while i < len(line):
    answer += line[i]
    i += 3 if line[i] in aeiou else 1
print(answer)
