N = int(input())
q = N // 2 + 1
print(q * q if N % 2 == 0 else q * (q+1))
