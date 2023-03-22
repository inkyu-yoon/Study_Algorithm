import math
def solution(progresses, speeds):
    answer = []
    arr = list(100 - i for i in progresses)
    for i in range(len(arr)):
        arr[i] = math.ceil(arr[i] / speeds[i])

    previous = arr[0]
    num = 1

    for i in range(1, len(arr)):

        if arr[i] > previous:
            answer.append(num)
            previous = arr[i]
            num = 1
        else:
            num += 1

    answer.append(num)

    return answer