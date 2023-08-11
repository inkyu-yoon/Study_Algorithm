package 바킹독.bfs.숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static Queue<Integer> q = new LinkedList<>();
    static int[] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int N = input[0], K = input[1];
        time = new int[100001];
        Arrays.fill(time, Integer.MAX_VALUE);

        q.offer(N);
        time[N] = 0;


        while (!q.isEmpty()) {
            Integer subin = q.poll();
            int t = time[subin];
            if (subin == K) {
                System.out.println(t);
            }

            check(subin + 1, t);
            check(subin - 1, t);
            check(subin * 2, t);

        }

    }

    private static void check(Integer subin, int t) {
        if (0 <= subin && subin <= 100000 && time[subin] > t + 1) {
            q.offer(subin);
            time[subin] = t + 1;
        }
    }

}
