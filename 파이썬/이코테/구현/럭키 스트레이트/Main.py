
# 캐릭터의 점수를 반으로 나누었을 때, 자릿수의 합이 동일해야한다.
# 자릿수는 항상 짝수이다.

score = list(map(int,input()))
idx = len(score)//2

if sum(score[:idx]) == sum(score[idx:]):
    print("LUCKY")
else:
    print("READY")


'''
123402

LUCKY

7755

READY
'''