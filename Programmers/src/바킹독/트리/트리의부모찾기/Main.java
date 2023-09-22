package 바킹독.트리.트리의부모찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<List<Integer>> tree = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String[] input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]) - 1;
            int v = Integer.parseInt(input[1]) - 1;

            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        int[] ans = new int[N];


        Queue<Integer> q = new LinkedList<>();
        boolean[] checked = new boolean[N];
        q.offer(0);
        checked[0] = true;

        while (!q.isEmpty()) {
            int parent = q.poll();
            List<Integer> children = tree.get(parent);
            for (int child : children) {
                if (!checked[child]) {
                    ans[child] = parent;
                    checked[child] = true;
                    q.offer(child);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N; i++) {
            sb.append((ans[i] + 1) + "\n");
        }
        System.out.println(sb);


    }

}
