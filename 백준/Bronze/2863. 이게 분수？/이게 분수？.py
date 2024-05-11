def calculate_value(A, B, C, D):
    rotations = [
        A / C + B / D,  # 0번 회전
        C / D + A / B,  # 1번 회전
        D / B + C / A,  # 2번 회전
        B / A + D / C   # 3번 회전
    ]
    
    max_value = max(rotations)
    return rotations.index(max_value)

# 입력
A, B = map(int, input().split())
C, D = map(int, input().split())

# 출력
print(calculate_value(A, B, C, D))
