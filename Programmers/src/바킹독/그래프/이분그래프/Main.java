package 바킹독.그래프.이분그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int V;
    static int[] checked;
    static Queue<Integer> q;
    static List<List<Integer>> nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        while (K-- > 0) {
            String[] input = br.readLine().split(" ");
            V = Integer.parseInt(input[0]);
            int E = Integer.parseInt(input[1]);

            nodes = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                nodes.add(new ArrayList<>());
            }

            while (E-- > 0) {
                input = br.readLine().split(" ");
                int u = Integer.parseInt(input[0]) - 1, v = Integer.parseInt(input[1]) - 1;
                nodes.get(u).add(v);
                nodes.get(v).add(u);
            }

            checked = new int[V];
            q = new LinkedList<>();

            for (int i = 0; i < V; i++) {
                if (checked[i] == 0) {
                    q.offer(i);
                    checked[i] = 1;
                    bfs();
                }
            }

            if (checkBipartite()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }


        }

    }

    private static boolean checkBipartite() {
        for (int i = 0; i < V; i++) {
            List<Integer> connects = nodes.get(i);
            int color = checked[i];
            for (int connect : connects) {
                if (checked[connect] == color) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            int u = q.poll();
            List<Integer> connects = nodes.get(u);
            for (int connect : connects) {
                if (checked[connect] == 0) {
                    checked[connect] = checked[u] * -1;
                    q.offer(connect);
                }
            }
        }
    }
}
