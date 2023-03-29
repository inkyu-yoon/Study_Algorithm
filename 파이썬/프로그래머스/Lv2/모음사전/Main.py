# 사전 A -> AA ->...-> AAAAA -> AAAAE -> AAAAI
def solution(word):
    text = ["A", "E", "I", "O", "U"]

    stack = []
    dic = []

    def bt(limit):
        if len(stack) == limit:
            dic.append(''.join(stack))
            return
        for i in text:
            stack.append(i)
            bt(limit)
            stack.pop()

    for i in range(1, 6):
        bt(i)

    dic = sorted(dic)

    return dic.index(word) + 1