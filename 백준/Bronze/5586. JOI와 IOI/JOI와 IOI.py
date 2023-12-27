import sys

def readline():

    return sys.stdin.readline().strip()

line = readline()

joi = 0

ioi = 0

index = 0

while index < len(line) - 2:

    if line[index: index + 3] == "JOI":

        joi += 1

    elif line[index: index + 3] == "IOI":

        ioi += 1

    else:

        index -= 1

    index += 2

print(joi)

print(ioi)