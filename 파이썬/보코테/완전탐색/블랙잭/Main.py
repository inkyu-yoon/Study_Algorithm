# M을 넘지 않으면서 M과 가장 가까운 카드 3장의 합을 출력한다.
import sys
from itertools import combinations

N, M = map(int, sys.stdin.readline().split())
cards = list(map(int, sys.stdin.readline().split()))

cases = combinations(cards, 3)
ans = 0
for case in cases:
    if M >= sum(case) :
       ans = max(sum(case),ans)
print(ans)