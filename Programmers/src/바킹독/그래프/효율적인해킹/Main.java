package 바킹독.그래프.효율적인해킹;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]);

        List<List<Integer>> computers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            computers.add(new ArrayList<>());
        }

        while (M-- > 0) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]) - 1, v = Integer.parseInt(input[1]) - 1;
            computers.get(v).add(u);
        }

        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            Queue<Integer> q = new LinkedList<>();
            boolean[] checked = new boolean[N];
            q.offer(i);
            checked[i] = true;

            int sum = 1;

            while (!q.isEmpty()) {
                int num = q.poll();

                List<Integer> connects = computers.get(num);
                for (int connect : connects) {
                    if (!checked[connect]) {
                        q.offer(connect);
                        checked[connect] = true;
                        sum++;
                    }
                }

            }
            result[i] = sum;
        }

        int max = Arrays.stream(result).max().getAsInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int value = result[i];
            if (value == max) {
                sb.append((i + 1) + " ");
            }
        }

        System.out.println(sb);
    }
}
