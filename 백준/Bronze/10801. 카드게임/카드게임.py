A = list(map(int, input().split()))
B = list(map(int, input().split()))
score = {'A': 0, 'B': 0}
for i in range(0, 10):
    if A[i] > B[i]:
        score['A'] += 1
    elif B[i] > A[i]:
        score['B'] += 1
if score['A'] > score['B']:
    print('A')
elif score['B'] > score['A']:
    print('B')
else:
    print('D')