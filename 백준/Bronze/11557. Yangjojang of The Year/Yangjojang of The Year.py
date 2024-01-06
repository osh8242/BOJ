import sys


input = sys.stdin.readline
T = int(input())
for _ in range(T):
    N = int(input())
    winnerQuantity = -1
    winner = "None"
    for i in range(N):
        readline = list(input().split())
        quantity = int(readline[1])
        if winnerQuantity < quantity:
            winnerQuantity = quantity
            winner = readline[0]
    print(winner)


