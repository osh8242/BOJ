import sys


def read_line():
    return sys.stdin.readline()


def is_right_triangle(sides):
    sides.sort()
    c = sides.pop()
    a, b = sides
    return c ** 2 == a ** 2 + b ** 2


T = int(read_line())
for i in range(1, T + 1):
    arr = list(map(int, read_line().split()))
    print(f"Scenario #{i}:")
    print("yes" if is_right_triangle(arr) else "no")
    if i < T:
        print()
