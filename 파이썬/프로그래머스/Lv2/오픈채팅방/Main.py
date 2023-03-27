def solution(record):
    answer = []
    dic = {}
    for rec in record:
        info = rec.split()
        if info[0] == 'Enter' or info[0] == 'Change':
            uid, nick = info[1], info[2]
            if uid in dic.keys():
                dic[uid] = nick
            else:
                dic[uid] = nick

    for rec in record:
        info = rec.split()
        act = info[0]
        uid = info[1]
        if act == 'Enter':
            answer.append(dic[uid] + '님이 들어왔습니다.')
        elif act == 'Leave':
            answer.append(dic[uid] + '님이 나갔습니다.')

    return answer