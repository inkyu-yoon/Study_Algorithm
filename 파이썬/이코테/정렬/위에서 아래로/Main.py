N = int(input())
ans=[]
for _ in range(N):
    ans.append(int(input()))

ans.sort(reverse=True)
print(*ans)