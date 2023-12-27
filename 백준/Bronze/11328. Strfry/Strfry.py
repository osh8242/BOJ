import sys


def readline():
    return sys.stdin.readline().strip()


T = int(readline())
result = ""
for _ in range(T):
    strArr = list(map(sorted, readline().split()))
    result += ("Possible" if strArr[0] == strArr[1] else "Impossible") + "\n"
print(result)
