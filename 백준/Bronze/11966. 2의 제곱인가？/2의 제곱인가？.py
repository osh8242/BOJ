import sys
N = int(sys.stdin.readline())
print(1 if (N & (N - 1)) == 0 else 0)