package 바킹독.위상정렬.음악프로그램;

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

        int[] arr = new int[N + 1];
        Node[] nodes = new Node[N + 1];
        for (int i = 0; i <= N; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int num = Integer.parseInt(input[0]);
            for (int j = 1; j < num; j++) {
                int singer = Integer.parseInt(input[j]);
                Node node = nodes[singer];
                int nextSinger = Integer.parseInt(input[j + 1]);
                node.next.add(nextSinger);
                arr[nextSinger]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (arr[i] == 0) {
                q.offer(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int singer = q.poll();
            sb.append(singer + "\n");
            Node node = nodes[singer];
            for (int nextSinger : node.next) {
                arr[nextSinger]--;
                if (arr[nextSinger] == 0) {
                    q.offer(nextSinger);
                }
            }
        }

        for (int i : arr) {
            if (i != 0) {
                System.out.println(0);
                System.exit(0);
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
