package 바킹독.트리.트리의높이와너비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main2 {
    static Node[] tree;
    static Map<Integer, int[]> info = new HashMap<>();
    static int col = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new Node[N + 1];
        boolean[] isChild = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            tree[i] = new Node(i);
        }

        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            int parentNode = Integer.parseInt(input[0]);
            int leftNode = Integer.parseInt(input[1]);
            int rightNode = Integer.parseInt(input[2]);

            if (leftNode != -1) {
                tree[parentNode].leftNode = tree[leftNode];
                isChild[leftNode] = true;
            }

            if (rightNode != -1) {
                tree[parentNode].rightNode = tree[rightNode];
                isChild[rightNode] = true;
            }

        }

        int root = findRoot(N, isChild);

        inOrder(tree[root], 1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        for (Integer depth : info.keySet()) {
            int[] value = info.get(depth);
            int width = value[0] - value[1] + 1;
            pq.offer(new int[]{width, depth});
        }

        int[] poll = pq.poll();
        System.out.println(poll[1] + " " + poll[0]);

    }

    private static void inOrder(Node root, int depth) {
        if (root == null) {
            return;
        }

        inOrder(root.leftNode, depth + 1);
        setMaxAndMin(depth);
        col++;
        inOrder(root.rightNode, depth + 1);

    }

    private static void setMaxAndMin(int depth) {
        if (!info.containsKey(depth)) {
            info.put(depth, new int[]{col, col});
        } else {
            int[] maxAndMin = info.get(depth);
            maxAndMin[0] = Math.max(maxAndMin[0], col);
            maxAndMin[1] = Math.min(maxAndMin[1], col);
            info.put(depth, maxAndMin);
        }
    }

    private static int findRoot(int N, boolean[] isChild) {
        int rootNode = 1;
        for (int i = 1; i <= N; i++) {
            if (!isChild[i]) {
                rootNode = i;
                break;
            }
        }
        return rootNode;
    }

    static class Node {
        int value;
        Node leftNode;
        Node rightNode;

        public Node(int value) {
            this.value = value;
        }
    }
}
