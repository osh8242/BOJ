n, k = map(int, input().split())
max_result = -1
for i in range(1, k + 1):
    temp = n * i
    if temp >= 10:
        temp = int(str(temp)[::-1])
    max_result = max(max_result, temp)
print(max_result)
