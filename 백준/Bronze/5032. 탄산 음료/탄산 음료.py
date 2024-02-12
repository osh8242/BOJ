import sys


def readLine():
    return sys.stdin.readline()


def getNewBottle(bottles, count):
    answer = 0
    while bottles >= c:
        newBottle = bottles // c
        answer += newBottle
        bottles = bottles % c + newBottle
    return answer


e, f, c = map(int, readLine().split())
bottles = e + f
print(getNewBottle(bottles, c))
