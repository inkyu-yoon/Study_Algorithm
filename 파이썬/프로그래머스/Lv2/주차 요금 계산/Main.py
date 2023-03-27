# fees : 요금표
# [기본시간 , 기본 요금, 단위 시간(분), 단위 요금] 단위 시간으로 나누어떨어지지 않으면 올림
# records = [시간 차량번호 IN or OUT]
# 출차 내역이 없으면 23:59에 출차된 것으로 간주
# 차량 번호가 작은 자동차부터 주차요금 정산
import math


def solution(fees, records):
    dic = {}
    result = {}
    for record in records:
        time, car, status = record.split()

        h, m = map(int, time.split(":"))

        time = 60 * h + m

        if status == "IN":
            dic[car] = time
        else:
            if car in result:
                result[car] += time - dic[car]
            else:
                result[car] = time - dic[car]
            del dic[car]

    if len(dic) != 0:
        for car in dic.keys():
            if car in result:
                result[car] += 23 * 60 + 59 - dic[car]
            else:
                result[car] = 23 * 60 + 59 - dic[car]

    answer = []

    for car in sorted(result.keys()):
        total = result[car] - fees[0]
        if total <= 0:
            answer.append(fees[1])
        else:
            answer.append(fees[1] + math.ceil((total) / fees[2]) * fees[3])
    return answer