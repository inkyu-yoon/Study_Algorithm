from collections import deque
N = int(input())

queue = deque([i+1 for i in range(N)])

# 카드를 버린다 -> 카드를 제일 밑으로 옮긴다 -> ... 1장 남을때까지 무한 반복

while(len(queue) != 1):
    queue.popleft()
    if queue:
        queue.append(queue.popleft())

print(queue.pop())