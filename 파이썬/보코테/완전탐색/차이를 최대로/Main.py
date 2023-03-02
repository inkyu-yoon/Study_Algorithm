from itertools import permutations
import sys

N = int(input())
arr = list(map(int,sys.stdin.readline().split()))

cases = permutations(arr)
max = -1

for case in cases:
    sum = 0
    for i in range(N-1):
        sum+=abs(case[i]-case[i+1])
    if sum > max :
        max = sum
print(max)