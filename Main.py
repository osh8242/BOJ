import sys


def readline():
    return int(sys.stdin.readline().strip())


heights = []
for _ in range(9):
    height = readline()
    heights.append(height)

residue = sum(heights) - 100

found = False
for i in range(8):
    if found:
        break
    for j in range(i + 1, 9):
        if heights[i] + heights[j] == residue:
            heights.pop(j)
            heights.pop(i)
            found = True
            break

for height in sorted(heights):
    print(height)
