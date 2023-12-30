import sys


def readline():
    return sys.stdin.readline().strip()


answer = ""
while True:
    input = list(map(int, readline().split()))
    if input[0] == 0:
        break
    line = str(input[1])
    prevNum = input[1]
    for i in range(1, input[0]+1):
        if prevNum == input[i]:
            continue
        else:
            line += " " + str(input[i])
            prevNum = input[i]
    answer += line + " $\n"
print(answer)

