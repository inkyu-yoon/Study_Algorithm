
# 주어진 수들을 M번 더하여 가장 큰 수를 만든다.(연속 K번 까지 더할 수 있다.)
N,M,K = map(int,input().split())
arr = list(map(int,input().split()))

arr.sort(reverse=True)
_max = arr[0]
_secondMax = arr[1]


numOfMax = M//(K+1)
result1= numOfMax*(_max*K+_secondMax)

numOfRest = M-(K+1)*numOfMax

result1+=numOfRest*_max

print(result1)


'''
5 6 2
2 4 5 2 6

34
'''

