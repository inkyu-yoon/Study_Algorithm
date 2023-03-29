def solution(files):
    answer = []
    _list = []
    for file in files:
        idx = 0
        while True:
            if not file[idx].isdigit():
                idx += 1
            else:
                break
        headIdx = idx
        Head = file[:headIdx]

        while True:
            if idx < len(file) and file[idx].isdigit():
                idx += 1
            else:
                break
        numberIdx = idx

        number = file[headIdx:numberIdx]
        tail = file[numberIdx:]
        _list.append([Head, number, tail])

    _list = sorted(_list, key=lambda x: (x[0].lower(), (int)(x[1])))

    for ele in _list:
        answer.append(''.join(ele))

    return answer