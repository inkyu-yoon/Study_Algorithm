def solution(prices):
    answer = []
    for i in range(len(prices)):
        for j in range(i,len(prices)):
            if prices[i]>prices[j]:
                point = j
                break
            else :
                point = j
        answer.append(point-i)
    return answer