def solution(genres, plays):
    answer = []
    dic = {}
    for idx in range(len(genres)):
        genre = genres[idx]
        if genre not in dic:
            dic[genre] = [plays[idx], [[plays[idx], idx]]]
        else:
            dic[genre][0] += plays[idx]
            dic[genre][1].append([plays[idx], idx])
            dic[genre][1] = sorted(dic[genre][1], key=lambda x: (-x[0], x[1]))

    info = sorted(dic.items(), key=lambda x: (-x[1][0]))

    for musics in info:
        for music in musics[1][1][:2]:
            answer.append(music[1])

    return answer