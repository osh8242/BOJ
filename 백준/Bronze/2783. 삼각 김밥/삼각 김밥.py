import sys


def read_line():
    return sys.stdin.readline()


def get_price(x, y):
    return 1000 * x / y


X, Y = map(int, read_line().split())
min_price = get_price(X, Y)
T = int(read_line())
for _ in range(T):
    x, y = map(int, read_line().split())
    min_price = min(min_price, get_price(x, y))
print(f"{min_price:.2f}")