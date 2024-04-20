def count_sticks(X):
    # X를 이진수로 변환하고 '1'의 개수를 센다
    return bin(X).count('1')

# 입력 받기
X = int(input().strip())
# 출력
print(count_sticks(X))
