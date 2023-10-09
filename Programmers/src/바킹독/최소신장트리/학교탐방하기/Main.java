package 바킹독.최소신장트리.학교탐방하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int[] parent;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);


        PriorityQueue<int[]> pqForMin = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        PriorityQueue<int[]> pqForMax = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int i = 0; i < M + 1; i++) {
            input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            // C 가 1인 경우 내리막, 0 인 경우 오르막
            int C = Integer.parseInt(input[2]);

            pqForMin.offer(new int[]{A, B, C});
            pqForMax.offer(new int[]{A, B, C});
        }

        System.out.println(getValue(pqForMax)- getValue(pqForMin));

    }

    private static int getValue(PriorityQueue<int[]> pq) {
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        int cnt = 0;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int a = find(poll[0]);
            int b = find(poll[1]);

            if (a != b) {
                parent[b] = a;
                if (poll[2] == 0) {
                    cnt++;
                }
            }
        }

        return cnt * cnt;
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}
