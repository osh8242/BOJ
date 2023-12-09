import math
r, b = map(int, input().split())
determinant = (4 + r) ** 2 - 4 * 2 * (2 * r + 2 * b)
max = (-(4 + r) - math.sqrt(determinant)) / -4
print(str(int(max)) + " " + str(int((r - 2 * max + 4) / 2)))