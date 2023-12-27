word = list(input())

T = int(input())

for _ in range(T):

    switch = list(map(int, input().split()))

    temp = word[switch[0]]

    word[switch[0]] = word[switch[1]]

    word[switch[1]] = temp

print("".join(word))