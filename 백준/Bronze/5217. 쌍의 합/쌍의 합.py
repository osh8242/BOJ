import sys


def read_line():
    return sys.stdin.readline()


def get_pairs(num):
    str = ""
    index = 1
    while 2 * index < num:
        str += f"{index} {num - index}"
        index += 1
        if 2 * index < num:
            str += ', '
    return str


T = int(read_line())
for _ in range(T):
    num = int(read_line())
    print(f"Pairs for {num}:", get_pairs(num))
