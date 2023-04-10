def solution(n):
    result = []
    checked = []

    # 최종 넘버
    final = (n) * (n + 1) // 2

    # 그래프와 방문 여부 checked 초기화
    for i in range(1, n + 1):
        arr = [j + 1 for j in range(i)]
        chk = [False for j in range(i)]
        result.append(arr)
        checked.append(chk)

    # 움직일 수 있는 방향 왼쪽 아래 방향 부터 진행
    dr = [1, 0, -1]
    dc = [0, 1, -1]
    direct = 0

    # 0,0 1번 부터 넘버링 시작
    num = 1
    r, c = 0, 0
    while True:
        # 넘버링이 최종넘버와 동일해지면 루프 종료
        if num == final:
            result[r][c] = final
            break

        # 넘버링 하면서 체크 진행
        result[r][c] = num
        checked[r][c] = True
        num += 1

        # 더 나아갈 수 없거나 이미 방문했던 칸을 만나면 방향 전환
        while True:
            nr, nc = dr[direct] + r, dc[direct] + c
            if 0 <= nr < n and nc < n and not checked[nr][nc]:
                break
            else:
                direct = (direct + 1) % 3

        r, c = nr, nc

    answer = []
    for res in result:
        answer += res
    return answer