package 바킹독.최소신장트리.물대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cost = new int[N+1];
        parent = new int[N+1];

        for (int j = 0; j <= N; j++) {
            parent[j] = j;
        }

        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(br.readLine());
        }

        List<int[]> paths = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            for (int j = 0; j < input.length; j++) {
                if (i != j) {
                    paths.add(new int[]{i+1, j+1, Integer.parseInt(input[j])});
                } else {
                    paths.add(new int[]{0, i+1, cost[i+1]});
                }
            }
        }

        Collections.sort(paths, (a, b) -> a[2] - b[2]);


        long totalCost = 0;
        for (int[] path : paths) {
            int u = path[0];
            int v = path[1];
            int c = path[2];

            if (find(u) != find(v)) {
                union(u, v);
                totalCost += c;
            }
        }

        System.out.println(totalCost);



    }

    private static void union(int u, int v) {
        int a = find(u);
        int b = find(v);

        if (a != b) {
            parent[b] = a;
        }
    }

    private static int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return find(parent[i]);
    }
}

/*
3
1
1
1
0 2 2
2 0 2
2 2 0

 */