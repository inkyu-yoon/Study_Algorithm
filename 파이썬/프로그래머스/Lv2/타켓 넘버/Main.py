def dfs(stack, numbers, target):
    ans = 0
    limit = len(numbers) - 1
    while stack:
        depth, num = stack.pop()
        if depth < limit:
            stack.append([depth + 1, num - numbers[depth + 1]])
            stack.append([depth + 1, num + numbers[depth + 1]])
        else:
            if num == target:
                ans += 1
    return ans


def solution(numbers, target):
    stack = []
    stack.append([0, numbers[0]])
    stack.append([0, -numbers[0]])
    answer = dfs(stack, numbers, target)

    return answer