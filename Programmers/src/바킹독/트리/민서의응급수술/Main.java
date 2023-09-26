package 바킹독.트리.민서의응급수술;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> nodes;
    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        nodes = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            nodes.get(u).add(v);
            nodes.get(v).add(u);
        }

        checked = new boolean[N + 1];
        int ans = 0;
        int cntOfGroup = 0;

        for (int i = 1; i < N + 1; i++) {
            if (!checked[i]) {
                int[] result = bfs(i);
                ans += (result[1] - (result[0] - 1));
                cntOfGroup++;
            }
        }
        ans += cntOfGroup - 1;
        System.out.println(ans);
    }

    private static int[] bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        checked[start] = true;

        int cntOfEdge = 0;
        int cntOfNode = 0;

        while (!q.isEmpty()) {
            int poll = q.poll();
            cntOfNode++;
            for (int connect : nodes.get(poll)) {
                if (!checked[connect]) {
                    checked[connect] = true;
                    q.offer(connect);
                }
            }
            cntOfEdge += nodes.get(poll).size();
        }
        return new int[]{cntOfNode, cntOfEdge/2};
    }

}
