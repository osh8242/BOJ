def print_d_shape(n):
    for _ in range(n):
        print('@' * (5 * n))

    for _ in range((3 * n - 2 * n) * 3):
        print('@' * n)

    for _ in range(n):
        print('@' * (5 * n))


n = int(input())
print_d_shape(n)
