numbers = input().split()
testNumber = input()
answer = 0
for number in numbers:
    if testNumber != number:
        num = int(int(number) / 10 ** (len(number) - len(testNumber)))
        if num == int(testNumber):
            answer += 1
print(answer)