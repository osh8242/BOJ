def process(number):
    return eval('*'.join(str(number)))


while (num := int(input())) != 0:
    while num >= 10:
        print(num, end=" ")
        num = process(num)
    print(num)
