import sys


def read_line():
    return sys.stdin.readline()


num_cases = int(read_line())
for _ in range(num_cases):
    original_price = float(read_line())
    discounted_price = original_price * 0.8
    print(f"${discounted_price:.2f}")
