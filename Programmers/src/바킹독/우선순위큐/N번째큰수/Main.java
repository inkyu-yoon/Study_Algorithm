package 바킹독.우선순위큐.N번째큰수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 번째 큰 수 찾기
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        // 모든 수는 자신의 한 칸 위에 있는 수보다 크다.
        for (int r = 0; r < N; r++) {
            String[] input = br.readLine().split(" ");
            for (int c = 0; c < N; c++) {
                pq.offer(Integer.parseInt(input[c]));
            }
        }

        int ans = 0;
        while (N-- > 0) {
            ans = pq.poll();
        }

        System.out.println(ans);
    }
}
