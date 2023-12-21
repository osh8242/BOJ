T = int(input())
result = ""
for _ in range(T):
    strArr = list(map(sorted, input().split()))
    result += ("Possible" if strArr[0] == strArr[1] else "Impossible") + "\n"
print(result)
