# 길이가 1인 모든 단어를 포함하도록 사전을 초기화
# 1:A 2:B ...... 24:X 25:Y 26:Z
# EX) KAKAO
# K는 사전에 11번으로 등록되어있음 11 출력
# KA를 27번으로 등록
# A는 사전에 1번으로 등록되어있음 1 출력
# AK를 28번으로 등록
# KA가 27번으로 등록되어있음, 27 출력
# KAO를 29번으로 등록
# O는 등록되어잇음 15 출력
def solution(msg):
    answer = []
    dic = {}
    for i in range(26):
        dic[chr((ord('A') + i))] = i + 1

    texts = list(msg)
    target = ''
    for text in texts:
        target += text
        if target in dic.keys():
            continue
        else:
            answer.append(dic[target[:-1]])
            dic[target] = len(dic) + 1
            target = target[-1]
    answer.append(dic[target])

    return answer