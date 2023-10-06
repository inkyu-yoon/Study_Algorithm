package 바킹독.위상정렬.문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[] indegree = new int[N + 1];

        Problem[] problems = new Problem[N + 1];
        for (int i = 0; i <= N; i++) {
            problems[i] = new Problem(i);
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int num = Integer.parseInt(input[0]);
            int next = Integer.parseInt(input[1]);
            problems[num].next.add(next);
            indegree[next]++;
        }
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int num = q.poll();
            Problem problem = problems[num];
            sb.append(num + " ");
            for (int nextProblem : problem.next) {
                indegree[nextProblem]--;
                if (indegree[nextProblem] == 0) {
                    q.offer(nextProblem);
                }
            }
        }

        System.out.println(sb);
    }

    static class Problem {
        int idx;
        List<Integer> next = new ArrayList<>();

        public Problem(int idx) {
            this.idx = idx;
        }
    }

}
