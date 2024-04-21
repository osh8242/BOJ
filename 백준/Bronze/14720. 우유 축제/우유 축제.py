import sys


def readLine():
    return sys.stdin.readline()


N = int(readLine())
shop_list = list(map(int, readLine().split()))
count = 0
for shop in shop_list:
    if shop == count % 3:
        count += 1
print(count)
