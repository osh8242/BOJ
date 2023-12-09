def determine(g, b):
    if g > b:
        return "GOOD"
    elif g < b:
        return "A BADDY"
    else:
        return "NEUTRAL"


T = int(input())
for _ in range(T):
    name = input()
    gCount = name.lower().count('g')
    bCount = name.lower().count('b')
    print(name + " is " + determine(gCount, bCount))
