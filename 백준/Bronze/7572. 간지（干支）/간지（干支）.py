year = int(input()) - 4
order = year % 60
second = order % 10
first = order % 12
print(chr(first+65) + str(second))
