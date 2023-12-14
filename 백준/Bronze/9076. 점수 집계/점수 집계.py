T = int(input())
result = ""
for _ in range(T):
    scores = sorted(list(map(int, input().split())))
    if scores[3] - scores[1] >= 4:
        result += "KIN"
    else:
        result += str(scores[1] + scores[2] + scores[3])
    result += "\n"
print(result)
