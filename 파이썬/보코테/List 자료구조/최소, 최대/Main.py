N = int(input())
arr = list(map(int, input().split()))

max = arr[0]
min = arr[0]
for element in arr:
    if max < element:
        max = element
    if min > element:
        min = element

print(min, max)
