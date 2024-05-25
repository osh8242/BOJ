import sys


def read_line():
    return sys.stdin.readline()


N = int(read_line())
record = read_line()
total_score = 0
bonus_score = 0
for i in range(1, len(record) + 1):
    if record[i-1] == 'O':
        total_score += (i + bonus_score)
        bonus_score += 1
    else:
        bonus_score = 0
print(total_score)
