package 바킹독.그래프.환승;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]), K = Integer.parseInt(input[1]), M = Integer.parseInt(input[2]);

        List<List<Integer>> nodes = new ArrayList<>();
        for (int i = 0; i < N + M; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int hyperTube = N + i;
            for (int j = 0; j < K; j++) {
                int connectedStation = Integer.parseInt(input[j]) - 1;
                nodes.get(hyperTube).add(connectedStation);
                nodes.get(connectedStation).add(hyperTube);
            }
        }


        Queue<Integer> q = new LinkedList<>();
        int[] checked = new int[N + M];
        q.offer(0);
        checked[0] = 1;

        while (!q.isEmpty()) {
            int num = q.poll();
            if (num == N - 1) {
                System.out.println(checked[num]);
                System.exit(0);
                break;
            }

            List<Integer> connects = nodes.get(num);

            for (int connect : connects) {
                if (checked[connect] == 0) {
                    if (connect < N) {
                        checked[connect] = checked[num] + 1;
                        q.offer(connect);
                    } else {
                        checked[connect] = checked[num];
                        q.offer(connect);
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
