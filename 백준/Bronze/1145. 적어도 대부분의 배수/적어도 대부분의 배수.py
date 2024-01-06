import sys


def readline():
    return sys.stdin.readline().strip()


nums = sorted(list(map(int, readline().split())))
index = nums[2]
for i in range(nums[2], nums[0] * nums[1] * nums[2] + 1):
    find = False
    if sum(i % nums[j] == 0 for j in range(5)) >= 3:
        find = True
    if find:
        print(i)
        break

