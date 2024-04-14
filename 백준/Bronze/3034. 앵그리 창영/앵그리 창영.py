import math
import sys


def readLine():
    return sys.stdin.readline()


N, W, H = map(int, readLine().split())
length = math.sqrt(W*W+H*H)
for _ in range(N):
    if int(readLine()) <= length:
        print("DA")
    else:
        print("NE")