switch = {'A': (0, 1),
          'B': (1, 2),
          'C': (2, 0)}
ball = [1, 0, 0]
command_list = list(input())
for t in command_list:
    command = switch[t]
    temp = ball[command[0]]
    ball[command[0]] = ball[command[1]]
    ball[command[1]] = temp
for i in range(len(ball)):
    if ball[i] == 1:
        print(i + 1)
