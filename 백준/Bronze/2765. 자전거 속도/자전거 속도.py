import sys
import math


def read_line():
    return sys.stdin.readline()


N = 1
while True:
    line = read_line()
    r, s, t = line.split()
    r = float(r)
    s = int(s)
    t = float(t)    
    if s == 0:
        break    
    mile = math.pi * r * s / 63360    
    time_in_hours = t / 3600    
    mph = mile / time_in_hours    
    print(f"Trip #{N}: {mile:.2f} {mph:.2f}")
    N += 1
