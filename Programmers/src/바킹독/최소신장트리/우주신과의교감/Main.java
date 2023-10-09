package 바킹독.최소신장트리.우주신과의교감;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        parent = new int[N + 1];
        int[][] points = new int[N+1][2];

        for (int i = 1; i <= N; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            points[i][0] = x;
            points[i][1] = y;
        }

        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }


        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int point1 = Integer.parseInt(input[0]);
            int point2 = Integer.parseInt(input[1]);

            int a = find(point1);
            int b = find(point2);

            if (a != b) {
                parent[b] = a;
            }
        }

        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[2] < b[2]) {
                return -1;
            } else if (a[2] > b[2]) {
                return 1;
            } else {
                return 0;
            }
        });

        for (int i = 1; i <= N-1; i++) {
            int[] point1 = points[i];
            for (int j = i+1; j <= N; j++) {
                int[] point2 = points[j];
                double d = Math.sqrt(Math.pow((point1[0] - point2[0]), 2) + Math.pow((point1[1] - point2[1]), 2));
                pq.offer(new double[]{i, j, d});
            }
        }
        double total = 0;
        while (!pq.isEmpty()) {
            double[] poll = pq.poll();

            int u = (int) poll[0];
            int v = (int) poll[1];
            int a = find(u);
            int b = find(v);
            if (a != b) {
                parent[b] = a;
                total += poll[2];
            }
        }
        System.out.printf("%.2f",total);
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}
