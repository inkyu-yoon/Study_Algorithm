# 끝말잇기에 참여하는 사람 수 n
# 끝말잇기에 사용한 단어들이 들어있는 words
# 끝말잇기에서 탈락하는 사람 번호와 그 사람의 차례를 return
def solution(n, words):
    answer = []
    end = words[0][len(words[0]) - 1]

    _set = set()
    _set.add(words[0])
    for i in range(1, len(words)):
        word = words[i]
        start = word[0]
        if end != start or word in _set:
            return [i % n + 1, i // n + 1]
        else:
            _set.add(word)
            end = word[len(word) - 1]

    return [0, 0]
