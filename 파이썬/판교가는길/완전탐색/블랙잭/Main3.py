import sys
from itertools import combinations

N,M = map(int,sys.stdin.readline().split())
cards = list(map(int,sys.stdin.readline().split()))

ans = -1
cases = combinations(cards,3)
for case in cases:
    sum = 0
    for num in case:
        sum+=num

    if M >= sum and sum >ans:
        ans = sum
print(ans)