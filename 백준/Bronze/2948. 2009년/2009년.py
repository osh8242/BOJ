m = [0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334]
d = ["Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday"]
D, M = map(int, input().split())
print(d[(m[M-1] + D) % 7])
