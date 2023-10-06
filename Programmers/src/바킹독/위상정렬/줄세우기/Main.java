package 바킹독.위상정렬.줄세우기;

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
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] arr = new int[N + 1];
        Node[] students = new Node[N + 1];
        for (int i = 0; i <= N; i++) {
            students[i] = new Node(i);
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int num = Integer.parseInt(input[0]);
            Node student = students[num];

            int next = Integer.parseInt(input[1]);

            student.next.add(next);
            arr[next]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (arr[i] == 0) {
                q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int num = q.poll();
            sb.append(num + " ");
            Node student = students[num];
            for (int nextStudent : student.next) {
                arr[nextStudent]--;
                if (arr[nextStudent] == 0) {
                    q.offer(nextStudent);
                }
            }
        }
        System.out.println(sb);

    }

    static class Node{
        int idx;
        List<Integer> next = new ArrayList<>();

        public Node(int idx) {
            this.idx = idx;
        }

    }
}
