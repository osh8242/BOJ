import sys


def getCount(num):
    result = 0
    num_str = str(num)
    for digit in num_str:
        if digit in '369':
            result += 1
    return result


N = int(sys.stdin.readline())
answer = 0
for i in range(1, N + 1):
    answer += getCount(i)
print(answer)

