import sys


def readline():
    return sys.stdin.readline().strip()


word = readline()
testStr = readline()
print(1 if testStr in word else 0)