# N 자리 숫자가 주어졌을 때, 여기서 숫자 K개를 지워서 얻을 수 있는 가장 큰 수를 구하는 프로그램
N, K = map(int, input().split())

numbers = list(input())
answer = []

for number in numbers:
    while(len(answer)>0 and answer[-1]<number and K >0):
        answer.pop()
        K-=1
    answer.append(number)

while(K>0):
    answer.pop()
    K-=1

print(''.join(answer))
