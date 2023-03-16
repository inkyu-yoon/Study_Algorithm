
arr = list(map(int,input()))

ans = 1

for num in arr:
    if num !=0:
        ans*=num
print(ans)