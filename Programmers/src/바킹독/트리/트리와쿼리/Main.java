package 바킹독.트리.트리와쿼리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static List<List<Integer>> nodes;
    static boolean[] checked;
    static Map<Integer, Integer> map = new HashMap<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int R = Integer.parseInt(input[1]);
        int Q = Integer.parseInt(input[2]);
        checked = new boolean[N + 1];
        nodes = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            nodes.add(new ArrayList<>());
        }


        for (int i = 0; i < N - 1; i++) {
            input = br.readLine().split(" ");
            int U = Integer.parseInt(input[0]);
            int V = Integer.parseInt(input[1]);
            nodes.get(U).add(V);
            nodes.get(V).add(U);
        }

        TreeNode head = new TreeNode(R);

        makeTree(head);


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int U = Integer.parseInt(br.readLine());
            sb.append(map.get(U) + "\n");
        }
        System.out.println(sb);
    }

    private static int makeTree(TreeNode head) {
        int value = head.value;
        checked[value] = true;
        List<Integer> connects = nodes.get(value);
        int cnt = 1;
        for (int connect : connects) {
            if (!checked[connect]) {
                TreeNode child = new TreeNode(connect);
                head.children.add(child);
                cnt += makeTree(child);
            }
        }
        map.put(value, cnt);
        return cnt;
    }

}

class TreeNode {
    int value;
    List<TreeNode> children;

    public TreeNode(int value) {
        this.value = value;
        this.children = new ArrayList<>();
    }
}
