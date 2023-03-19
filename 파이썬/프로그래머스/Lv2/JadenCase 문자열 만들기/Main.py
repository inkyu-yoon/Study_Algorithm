# 첫 문자가 대문자이고 그 외는 소문자
def solution(s):
    s = s.lower()
    s = list(s)
    # 첫문자
    if s[0].isalpha():
        s[0] = s[0].upper()

    for i in range(1, len(s)):
        if s[i - 1] == ' ' and s[i].isalpha():
            s[i] = s[i].upper()
    answer = ''.join(s)

    return answer