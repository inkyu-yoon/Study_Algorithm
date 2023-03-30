def solution(numbers):
    answer = []
    mask = 0xffffffff
    for number in numbers:
        target = list((str)(format(number, '0b')))[::-1]
        for i in range(len(target)):
            if target[i] == '0':
                target[i] = '1'
                if i >= 1:
                    target[i - 1] = '0'
                break
        else:
            target[-1] = '0'
            target.append('1')
        answer.append((int)(''.join(target[::-1]), 2))

    return answer