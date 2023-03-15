N = int(input())
ans = []
for _ in range(N):
    info = input().split()
    ans.append([info[0],int(info[1])])

ans.sort(key=lambda x : x[1])

for s in ans:
    print(s[0],end=' ')


'''
2
홍길동 95
이순신 77

이순신 홍길동
'''
