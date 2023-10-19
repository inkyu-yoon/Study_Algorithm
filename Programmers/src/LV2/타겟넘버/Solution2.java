package LV2.타겟넘버;

import java.util.*;

class Solution2 {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<Node> q = new LinkedList<>();
        int N = numbers.length;
        boolean[] checked = new boolean[N];

        q.offer(new Node(-1, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.idx != N - 1) {
                int idx = node.idx + 1;
                q.offer(new Node(idx, node.val + numbers[idx]));
                q.offer(new Node(idx, node.val - numbers[idx]));
            } else {
                if (node.val == target) {
                    answer++;
                }
            }
        }


        return answer;
    }

    static class Node {
        int idx;
        int val;

        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
}