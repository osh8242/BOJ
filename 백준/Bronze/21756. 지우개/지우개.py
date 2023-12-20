N = int(input())
queue = [i for i in range(1, N + 1)]

while len(queue) > 1:
    length = len(queue)
    if length == 1:
        break
    new_queue = []
    for i in range(length):
        if i % 2 != 0:
            new_queue.append(queue[i])
    queue = new_queue

print(queue[0])
