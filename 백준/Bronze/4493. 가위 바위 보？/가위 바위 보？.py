def determine_winner(player1, player2):
    win_map = {'R': 'S', 'S': 'P', 'P': 'R'}
    if win_map[player1] == player2:
        return 1
    elif win_map[player2] == player1:
        return 2
    else:
        return 0

import sys
input = sys.stdin.read
data = input().split()
index = 0

t = int(data[index])
index += 1

results = []

for _ in range(t):
    n = int(data[index])
    index += 1
    
    player1_wins = 0
    player2_wins = 0
    
    for _ in range(n):
        p1, p2 = data[index], data[index + 1]
        index += 2
        result = determine_winner(p1, p2)
        if result == 1:
            player1_wins += 1
        elif result == 2:
            player2_wins += 1
    
    if player1_wins > player2_wins:
        results.append("Player 1")
    elif player2_wins > player1_wins:
        results.append("Player 2")
    else:
        results.append("TIE")

for result in results:
    print(result)
