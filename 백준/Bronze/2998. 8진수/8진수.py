import sys


def readline():
    return sys.stdin.readline()


binaryStr = readline()
num = int(binaryStr, 2)
octalStr = oct(num)[2:]

print(octalStr)
