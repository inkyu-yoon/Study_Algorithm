from functools import cmp_to_key


def comparator(a, b):
    num1 = (int)((str)(a) + (str)(b))
    num2 = (int)((str)(b) + (str)(a))
    if num1 == num2:
        return 0
    elif num1 < num2:
        return 1
    else:
        return -1


def solution(numbers):
    answer = ''

    numbers = sorted(numbers, key=cmp_to_key(comparator))
    if numbers.count(0) == len(numbers):
        return "0"
    for num in numbers:
        answer += (str)(num)
    return answer