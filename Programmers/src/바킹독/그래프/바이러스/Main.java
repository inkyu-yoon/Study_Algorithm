package 바킹독.그래프.바이러스;

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

        int numOfComputer = Integer.parseInt(br.readLine());

        List<List<Integer>> computers = new ArrayList<>();

        for (int i = 0; i < numOfComputer; i++) {
            computers.add(new ArrayList<>());
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]) - 1, v = Integer.parseInt(input[1]) - 1;
            computers.get(u).add(v);
            computers.get(v).add(u);
        }

        System.out.println(bfs(computers));
    }

    private static int bfs(List<List<Integer>> computers) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] checked = new boolean[computers.size()];
        checked[0] = true;
        q.offer(0);

        int cnt = 0;

        while (!q.isEmpty()) {
            int computer = q.poll();
            List<Integer> neighbors = computers.get(computer);
            for (int i = 0; i < neighbors.size(); i++) {
                int neighbor = neighbors.get(i);
                if (!checked[neighbor]) {
                    checked[neighbor] = true;
                    q.offer(neighbor);
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
