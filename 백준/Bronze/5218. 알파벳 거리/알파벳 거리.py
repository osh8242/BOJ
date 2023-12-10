T = int(input())
for _ in range(T):
    word1, word2 = map(str, input().split())
    result = "Distances:"
    for (i, j) in zip(word1, word2):
        distance = ord(j) - ord(i)
        if distance < 0:
            distance += 26
        result += " " + str(distance)
    print(result)
