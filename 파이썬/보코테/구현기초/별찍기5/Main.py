#N번째 줄에는 2*N-1개를 찍어야함
N=int(input())

for i in range(N):
    for j in range(N-(i+1)):
        print(" ",end="")
    for k in range(2*(i+1)-1):
        print("*",end="")
    print()