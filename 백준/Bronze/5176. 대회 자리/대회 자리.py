T = int(input())
result = []
for _ in range(T):
    P, M = map(int, input().split())
    seat = [False for _ in range(M+1)]
    answer = 0
    for i in range(0, P):
        seat_wanted = int(input())
        if seat[seat_wanted]:
            answer += 1
        else:
            seat[seat_wanted] = True
    result.append(answer)
for element in result:
    print(element)