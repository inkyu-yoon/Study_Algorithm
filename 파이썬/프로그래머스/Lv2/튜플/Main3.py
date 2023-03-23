import re
from collections import Counter
def solution(s):
    answer = []
    c = Counter(re.findall('\d+',s))
    c = sorted(c.items(),key=lambda x:-x[1])
    for num in c:
        answer.append(num[0])
    answer = list(map(int,answer))
    return answer