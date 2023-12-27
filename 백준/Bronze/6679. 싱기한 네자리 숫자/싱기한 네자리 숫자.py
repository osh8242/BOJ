def transform(number, factor):
    transform_num = []
    while number >= factor:
        transform_num = [number % factor] + transform_num
        number = int(number / factor)
    if number != 0:
        transform_num = [number] + transform_num
    return transform_num

def get_digit_sum(nums):
    digit_sum = 0
    for n in nums:
        digit_sum = digit_sum + n
    return digit_sum

answer = []
for i in range(1000, 10000):
    sum = get_digit_sum(transform(i, 10))
    if sum == get_digit_sum(transform(i, 12)) and sum == get_digit_sum(transform(i, 16)):
        answer.append(i)
for a in answer:
    print(a)