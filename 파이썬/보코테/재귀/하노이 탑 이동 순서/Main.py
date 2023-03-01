# 3개의 장대가 있다.
# 1번째 장대에서 3번째 장대로 옮겨야 한다.


def hanoi(N,start,via,end):
    if N == 1:
        print(start,end)
    else:
        hanoi(N-1,start,end,via)
        print(start,end)
        hanoi(N-1,via,start,end)

N=int(input())
print(2**N-1)
hanoi(N,1,2,3)