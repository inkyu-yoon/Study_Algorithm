package 바킹독.최소신장트리.행성터널;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        parent = new int[N];

        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        List<int[]> points = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            points.add(new int[]{i, Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2])});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        //x좌표 기준 정렬
        Collections.sort(points, (a, b) -> a[1] - b[1]);
        for (int i = 1; i < N; i++) {
            int[] point1 = points.get(i - 1);
            int[] point2 = points.get(i);
            pq.offer(new int[]{point1[0], point2[0], Math.abs(point1[1] - point2[1])});
        }

        //y좌표 기준 정렬
        Collections.sort(points, (a, b) -> a[2] - b[2]);
        for (int i = 1; i < N; i++) {
            int[] point1 = points.get(i - 1);
            int[] point2 = points.get(i);
            pq.offer(new int[]{point1[0], point2[0], Math.abs(point1[2] - point2[2])});
        }

        //z좌표 기준 정렬
        Collections.sort(points, (a, b) -> a[3] - b[3]);
        for (int i = 1; i < N; i++) {
            int[] point1 = points.get(i - 1);
            int[] point2 = points.get(i);
            pq.offer(new int[]{point1[0], point2[0], Math.abs(point1[3] - point2[3])});
        }

        int ans = 0;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int u = poll[0], v = poll[1];
            int c = poll[2];
            int a = find(u), b = find(v);
            if (a != b) {
                parent[b] = a;
                ans += c;
            }
        }
        System.out.println(ans);

    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}
