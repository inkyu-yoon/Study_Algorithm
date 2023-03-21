def solution(people, limit):
    answer = 0
    people.sort()

    left = 0
    right = len(people) - 1

    while left <= right:
        if left == right:
            answer += 1
            break

        _sum = people[left] + people[right]

        if _sum <= limit:
            answer += 1
            left += 1
            right -= 1
        else:
            answer += 1
            right -= 1

    return answer