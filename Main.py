import math
import sys


def read_line():
    return sys.stdin.readline()


N = 1
while True:
    r, s, t = map(float, read_line().split())
    if s == 1:
        break
    mile = math.pi * r * s / 63360
    rpm = mile / t * 60 * 60
    print(f"Trip #{N}: {mile:.2f} {rpm:.2f}")
