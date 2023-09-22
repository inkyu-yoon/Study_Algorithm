package 바킹독.트리.트리순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Node head = new Node("A");
        Map<String, Node> map = new HashMap<>();
        map.put("A", head);

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            String parent = input[0];
            String left = input[1];
            String right = input[2];

            Node parentNode = map.get(parent);
            if (!left.equals(".")) {
                Node leftChild = new Node(left);
                parentNode.left = leftChild;
                map.put(left, leftChild);
            }

            if (!right.equals(".")) {
                Node rightChild = new Node(right);
                parentNode.right = rightChild;
                map.put(right, rightChild);
            }
        }


        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);



    }

    private static void postOrder(Node head) {
        if (head == null) {
            return;
        }
        postOrder(head.left);
        postOrder(head.right);
        System.out.print(head.alpha);
    }

    private static void inOrder(Node head) {
        if (head == null) {
            return;
        }
        inOrder(head.left);
        System.out.print(head.alpha);
        inOrder(head.right);
    }

    private static void preOrder(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.alpha);
        preOrder(head.left);
        preOrder(head.right);
    }


    static class Node {
        String alpha;
        Node right;
        Node left;

        public Node(String alpha) {
            this.alpha = alpha;
        }
    }
}
