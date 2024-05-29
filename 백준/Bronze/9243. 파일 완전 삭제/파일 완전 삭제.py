import sys


def read_line():
    return sys.stdin.readline().strip()


def flip_bits(bits):
    return ''.join('1' if bit == '0' else '0' for bit in bits)


N = int(read_line())
origin = read_line()
result = read_line()

if N % 2 == 1:
    expected_bits = flip_bits(origin)
else:
    expected_bits = origin
print("Deletion succeeded" if expected_bits == result else "Deletion failed")
