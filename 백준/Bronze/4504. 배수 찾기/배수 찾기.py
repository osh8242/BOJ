import sys
input = sys.stdin.readline

n = int(input())
while True:
    num = int(input())
    if num == 0:
        break
    print(f"{num} is {'a multiple' if num % n == 0 else 'NOT a multiple'} of {n}.")
