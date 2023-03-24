def solution(n, computers):
    answer = 0
    checked = [False for _ in range(n)]
    stack = []

    def dfs(num):
        while stack:
            cpuInfo = stack.pop()
            for idx in range(len(cpuInfo)):
                if cpuInfo[idx] == 1 and not checked[idx]:
                    checked[idx] = True
                    stack.append(computers[idx])

    for num in range(n):
        cpu = computers[num]
        if not checked[num]:
            checked[num] = True
            stack.append(cpu)
            dfs(num)
            answer += 1

    return answer
