days_of_month = [0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334]
day = ["Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday"]
D, M = map(int, input().split())
print(day[(days_of_month[M-1] + D) % 7])
