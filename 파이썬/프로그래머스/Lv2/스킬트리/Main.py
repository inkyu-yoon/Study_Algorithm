# 스킬이 CBD이면 CBD 순으로 되어있는 스킬 트리를 찾으면 됨
def solution(skill, skill_trees):
    answer = 0
    dic = {}

    for i in range(len(skill)):
        dic[skill[i]] = i

    for skill_tree in skill_trees:
        stack = []
        _list = list(skill_tree)

        for i in range(len(skill_tree)):
            sk = skill_tree[i]
            if sk in dic.keys():
                if dic[sk] == len(stack):
                    stack.append(sk)
                else:
                    break
        else:
            answer += 1

    return answer