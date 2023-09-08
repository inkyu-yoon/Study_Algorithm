package 바킹독.그래프.dfs와bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> nodes;
    static boolean[] checked;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]), V = Integer.parseInt(input[2]);

        nodes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]) - 1, v = Integer.parseInt(input[1]) - 1;
            nodes.get(u).add(v);
            nodes.get(v).add(u);
        }

        for (int i = 0; i < N; i++) {
            Collections.sort(nodes.get(i));
        }


        checked = new boolean[N];
        checked[V - 1] = true;
        sb = new StringBuilder();
        sb.append((V) + " ");
        dfs(V - 1);
        System.out.println(sb);

        checked = new boolean[N];
        checked[V - 1] = true;
        sb = new StringBuilder();
        sb.append((V) + " ");
        bfs(V - 1);
        System.out.println(sb);

    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int u = q.poll();
            List<Integer> connects = nodes.get(u);
            for (int i = 0; i < connects.size(); i++) {
                int v = connects.get(i);
                if (!checked[v]) {
                    checked[v] = true;
                    sb.append((v + 1) + " ");
                    q.offer(v);
                }
            }
        }


    }

    private static void dfs(int start) {
        List<Integer> connects = nodes.get(start);

        for (int i = 0; i < connects.size(); i++) {
            int v = connects.get(i);
            if (!checked[v]) {
                sb.append((v + 1) + " ");
                checked[v] = true;
                dfs(v);

            }
        }


    }
}
