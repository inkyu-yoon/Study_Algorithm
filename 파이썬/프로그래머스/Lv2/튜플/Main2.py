def solution(s):
    answer = []
    s = s[2:len(s) - 2].split('},{')

    dic = {}
    for text in s:
        text = text.split(',')
        for num in text:
            if num in dic:
                dic[num] += 1
            else:
                dic[num] = 1
    s = sorted(dic.items(), key=lambda x: -x[1])

    print(s)

    for num in s:
        answer.append(num[0])
    answer = list(map(int, answer))

    return answer