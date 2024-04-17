import sys

input = sys.stdin.readline
n = int(input())
sum = 0
for i in range(n + 1):
    sum += i * (n + 1 - i) + (n + 1 - i) * (i + n) // 2
print(sum)
