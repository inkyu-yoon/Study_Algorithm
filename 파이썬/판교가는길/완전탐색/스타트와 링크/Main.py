import sys
from itertools import combinations

N = int(input())
capacities = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

numbers = [i + 1 for i in range(N)]
cases = combinations(numbers, N // 2)
ans = -1;
for startTeam in cases:
    linkTeam = numbers[:]
    for n in startTeam:
        linkTeam.remove(n)

    linkScore = 0
    startScore = 0
    for link in combinations(linkTeam, 2):
        linkScore += capacities[link[0] - 1][link[1] - 1] + capacities[link[1] - 1][link[0] - 1]
    for start in combinations(startTeam, 2):
        startScore += capacities[start[0] - 1][start[1] - 1] + capacities[start[1] - 1][start[0] - 1]

    if ans == -1:
        ans = abs(startScore - linkScore)
    else:
        ans = min(ans, abs(startScore - linkScore))
print(ans)
