import sys

A, B, C, N = map(int, input().split())
for i in range(0, int(N / A)):
    for j in range(0, int(N / B)):
        if A * i + B * j > N: break
        for k in range(0, int(N / C)):
            if A * i + B * j + C * k > N:
                break
            if A * i + B * j + C * k == N:
                print(1)
                sys.exit()
print(0)
