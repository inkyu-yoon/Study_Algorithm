import heapq


def solution(operations):
    q = []

    for op in operations:
        cmd, num = op.split()
        num = (int)(num)

        if cmd == 'I':
            heapq.heappush(q, num)
        elif cmd == 'D' and len(q) > 0:
            if num == -1:
                heapq.heappop(q)
            else:
                q.pop()
    if len(q) == 0:
        return [0, 0]
    else:
        return [max(q), min(q)]
