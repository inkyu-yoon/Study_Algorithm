# 가장 높은 숫자가 쓰인 카드 한 장을 뽑는 게임
# N x M 형태로 놓여있다. 선택된 행에 있는 카드 중 가장 낮은 카드를 뽑아야 한다.
# 각 행 중 최솟값이 가장 높은 행을 선택한 뒤, 거기서 최솟값을 선택해야 한다.

R,C = map(int,input().split())

ans = -1e9
for r in range(R):
    info = list(map(int,input().split()))
    ans = max(ans,min(info))
print(ans)



'''
3 3
3 1 2
4 1 4
2 2 2

2


2 4
7 3 1 8
3 3 3 4

3
'''