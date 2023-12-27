need_gradient = [0.5, 0.5, 0.25, 0.0625, 0.5625]

need_toping = [1, 30, 25, 10]

T = int(input())

result = []

for _ in range(T):

    input()

    input_gradient = list(map(int, input().split()))

    input_toping = list(map(int, input().split()))

    gradient = [int(input_gradient[i] / need_gradient[i]) for i in range(5)]

    toping = sum(int(input_toping[i] / need_toping[i]) for i in range(4))

    result.append(min(min(gradient), toping))

for answer in result:

    print(answer)