arr = [list(map(int, input().split())) for _ in range(5)]
maxScore = 0
person = 0
for i in range(5):
    sum = 0
    for score in arr[i]:
        sum += score
    if maxScore < sum:
        maxScore = sum
        person = i + 1

print(person, maxScore)
