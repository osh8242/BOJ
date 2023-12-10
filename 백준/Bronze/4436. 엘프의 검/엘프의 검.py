while True:
    try:
        n = int(input())
    except:
        break

    s, k = 0, 0
    digit_set = set()
    while len(digit_set) < 10:
        k += 1
        s += n
        for digit in str(s):
            digit_set.add(digit)
            if len(digit) == 10:
                break
    print(k)
