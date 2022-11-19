package 그래프;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No_1697 {
    static int N;
    static int K;
    static int[] check = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        if (N == K) {
            System.out.println(0);
        } else {
            bfs(N);
        }
    }

    static void bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        check[num] = 1;

        while (!q.isEmpty()) {
            int temp = q.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = temp + 1;
                } else if (i == 1) {
                    next = temp - 1;
                } else {
                    next = temp * 2;
                }

                if (next == K) {
                    System.out.println(check[temp]);
                    return;
                }

                if (next >= 0 && next < check.length && check[next] == 0) {
                    q.add(next);
                    check[next] = check[temp] + 1;
                }
            }
        }
    }
}
//수빈이의 위치 N
// 동생의 위치 K
// 수빈이는 +- 1 혹은 *2 포인트로 이동 가능
// 수빈이가 동생을 찾을 수 있는 가장 빠른 시간은?
/* 예제 입력
5 17
 *///4