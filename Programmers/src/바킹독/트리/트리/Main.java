package 바킹독.트리.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int caseNum = 1;
        while (true) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("0")) {
                break;
            }

            int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
            List<List<Integer>> nodes = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                nodes.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                input = br.readLine().split(" ");
                int u = Integer.parseInt(input[0]) - 1;
                int v = Integer.parseInt(input[1]) - 1;
                nodes.get(u).add(v);
                nodes.get(v).add(u);
            }

            int cnt = 0;

            Queue<Integer> q = new LinkedList<>();
            boolean[] checked = new boolean[n];

            for (int i = 0; i < n; i++) {
                if (!checked[i]) {
                    int edge = 0;
                    int numOfNode = 0;
                    q.offer(i);
                    checked[i] = true;
                    while (!q.isEmpty()) {
                        int node = q.poll();
                        numOfNode++;
                        List<Integer> connects = nodes.get(node);
                        for (int connect : connects) {
                            edge++;
                            if (!checked[connect]) {
                                q.offer(connect);
                                checked[connect] = true;
                            }
                        }
                    }
                    if ((edge / 2) == numOfNode - 1) {
                        cnt++;
                    }
                }
            }

            if (cnt > 1) {
                sb.append("Case " + caseNum + ": A forest of " + cnt + " trees.\n");
            } else if (cnt == 1) {
                sb.append("Case " + caseNum + ": There is one tree.\n");
            } else {
                sb.append("Case " + caseNum + ": No trees.\n");
            }

            caseNum++;
        }
        System.out.println(sb);
    }


}
