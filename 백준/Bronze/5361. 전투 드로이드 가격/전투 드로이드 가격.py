import sys


def read_line():
    return sys.stdin.readline()


def get_price(a, b, c, d, e):
    return 350.34 * a + 230.90 * b + 190.55 * c + 125.30 * d + 180.90 * e


T = int(read_line())
for _ in range(T):
    a, b, c, d, e = map(int, read_line().split())
    print(f"${get_price(a, b, c, d, e):.2f}")
