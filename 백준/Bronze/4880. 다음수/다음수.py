import sys

def read_line():
    return sys.stdin.readline()

while True:
    a, b, c = map(int, read_line().split())
    if a == 0 and b == 0 and c == 0:
        break
    if b - a == c - b:
        next_term = c + (c - b)
        print("AP", next_term)
    else:
        next_term = c * (c // b)
        print("GP", next_term)
