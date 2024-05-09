import sys
input = sys.stdin.read

def find_nemo():
    lines = input().strip().split('\n')
    for line in lines:
        if line == "EOI":
            break
        if 'nemo' in line.lower():
            print("Found")
        else:
            print("Missing")

find_nemo()
