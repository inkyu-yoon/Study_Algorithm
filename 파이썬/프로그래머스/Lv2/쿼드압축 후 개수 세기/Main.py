# 쿼드 압축 후 0과 1의 갯수
# arr 행의 개수는 1 2 4 8 16 .... 2의 제곱
def solution(arr):

    answer = [0,0]
    n = len(arr)
    zero = 0

    for i in range(n):
        zero +=arr[i].count(0)
    if zero == n*n:
        return [1,0]
    elif zero == 0:
        return [0,1]

    def calculate(r,c,size):
        result = [0,0]
        for i in range(r,r+size):
            for j in range(c,c+size):
                if arr[i][j]==0:
                    result[0]+=1
                else:
                    result[1]+=1
        return result

    def quad(startR,startC,endR,endC):
        size = (endR-startR+1)//2
        if size == 1:
            result = calculate(startR,startC,2)
            answer[0]+=result[0]
            answer[1]+=result[1]
            return

        for r in range(startR,endR,size):
            for c in range(startC,endC,size):
                result = calculate(r,c,size)
                if result[0]==0:
                    answer[1]+=1
                elif result[1]==0:
                    answer[0]+=1
                else:
                    quad(r,c,r+size-1,c+size-1)

    quad(0,0,n-1,n-1)

    return answer