from functools import cmp_to_key


def comp(a, b):
    num1 = (str)(a) + (str)(b)
    num2 = (str)(b) + (str)(a)
    if num1 < num2:
        return 1
    else:
        return -1


def solution(numbers):
    answer = ''
    numbers = sorted(numbers, key=cmp_to_key(comp))

    answer = ''.join(map(str, numbers))
    if answer[0] == '0':
        return '0'
    return answer