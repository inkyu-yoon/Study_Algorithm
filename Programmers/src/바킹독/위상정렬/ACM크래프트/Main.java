package 바킹독.위상정렬.ACM크래프트;

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
        int T = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);

            int[] indegree = new int[N + 1];
            Node[] nodes = new Node[N + 1];
            input = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                nodes[i + 1] = new Node(i + 1);
                nodes[i + 1].cost = Integer.parseInt(input[i]);
            }

            for (int i = 0; i < K; i++) {
                input = br.readLine().split(" ");
                int pre = Integer.parseInt(input[0]);
                int next = Integer.parseInt(input[1]);
                nodes[pre].next.add(next);
                indegree[next]++;
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                if (indegree[i] == 0) {
                    q.offer(i);
                    nodes[i].endTime = nodes[i].cost;
                }
            }

            int goal = Integer.parseInt(br.readLine());

            while (!q.isEmpty()) {
                Node current = nodes[q.poll()];
                if (current.idx == goal) {
                    ans.append(current.endTime + "\n");
                    break;
                }
                for (int next : current.next) {
                    Node nextNode = nodes[next];
                    nextNode.startTime = Math.max(nextNode.startTime, current.endTime);
                    nextNode.endTime = nextNode.startTime + nextNode.cost;
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        q.offer(next);
                    }
                }
            }
        }
        System.out.println(ans);
    }

    static class Node{
        int idx;
        int cost;
        int startTime;
        int endTime;
        List<Integer> next = new ArrayList<>();

        public Node(int idx) {
            this.idx = idx;
        }
    }
}
