package 바킹독.트리.트리2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        TreeNode[] nodes = new TreeNode[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new TreeNode(i);
        }

        String[] input = br.readLine().split(" ");

        for (int i = 0; i < input.length; i++) {
            int parent = Integer.parseInt(input[i]);
            if (parent != -1) {
                nodes[parent].children.add(i);
            }
        }

        int deleted = Integer.parseInt(br.readLine());


        Queue<Integer> q = new LinkedList<>();
        boolean[] checked = new boolean[N];
        q.offer(deleted);
        checked[deleted] = true;

        while (!q.isEmpty()) {
            int poll = q.poll();
            for (int child : nodes[poll].children) {
                if (!checked[child]) {
                    q.offer(child);
                    checked[child] = true;
                }
            }
            nodes[poll].children.clear();
        }

        if (!input[deleted].equals("-1")) {
            nodes[Integer.parseInt(input[deleted])].children.remove(deleted);
        }


        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (nodes[i].children.size() == 0 && !checked[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }

    static class TreeNode {
        int idx;
        Set<Integer> children = new HashSet<>();

        public TreeNode(int idx) {
            this.idx = idx;
        }
    }
}
