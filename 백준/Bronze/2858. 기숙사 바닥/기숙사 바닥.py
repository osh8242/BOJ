import math


def main():
    r, b = map(int, input().split())
    # 2 * w + 2 * h - 4 = r;
    # (w-2)*(h-2) = b;
    # (r-2*h)*(h-2) = 2*b;
    # - 2*h^2 + (4 + r) * h  -2*r = 2*b
    determinant = (4 + r) ** 2 - 4 * 2 * (2 * r + 2 * b)
    max = (-(4 + r) - math.sqrt(determinant)) / -4
    print(str(int(max)) + " " + str(int((r - 2 * max + 4) / 2)))


if __name__ == "__main__":
    main()
