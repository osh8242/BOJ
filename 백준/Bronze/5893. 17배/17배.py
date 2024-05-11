import sys
binary_input = sys.stdin.readline()
decimal = int(binary_input, 2)
multiplied_decimal = decimal * 17
result_binary = bin(multiplied_decimal)[2:]
print(result_binary)
