ignores = ['i', 'pa', 'te', 'ni', 'niti', 'a', 'ali', 'nego', 'no', 'ili']
subjectWords = input().split()
answer = ""
for i in range(len(subjectWords)):
    if i == 0:
        answer += subjectWords[i][0]
    else:
        if subjectWords[i] not in ignores:
            answer += subjectWords[i][0]
print(answer.upper())
