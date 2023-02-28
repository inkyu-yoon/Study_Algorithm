T = int(input())


for _ in range(T):
    outfit = {}
    n = int(input())
    for _ in range(n):
        item, category = input().split()
        if category in outfit:
            outfit[category] += 1
        else:
            outfit[category] = 1
    answer = 1
    for num in list(outfit.values()):
        answer*=num+1
    print(answer-1)
