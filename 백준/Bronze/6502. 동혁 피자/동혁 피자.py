import sys


def readline():
    return sys.stdin.readline().strip()


answer = ""
index = 1
while True:
    input = list(map(int, readline().split()))
    if input[0] == 0:
        break
    answer += "Pizza " + str(index) + " "
    r = input[0]
    w = input[1]
    l = input[2]
    answer += "fits on the table." if 4 * r * r >= w * w + l * l else "does not fit on the table."
    answer += "\n"
    index += 1

print(answer)
