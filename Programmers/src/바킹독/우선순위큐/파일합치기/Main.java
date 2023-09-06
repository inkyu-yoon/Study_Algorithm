package 바킹독.우선순위큐.파일합치기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        StringBuilder ans = new StringBuilder();
        while (T-- > 0) {
            pq.clear();
            int K = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");

            if (input.length == 1) {
                ans.append(input[0] + "\n");
                continue;
            }

            for (int i = 0; i < K; i++) {
                pq.offer(Long.parseLong(input[i]));
            }


            long result = 0;

            while (pq.size() > 1) {
                Long first = pq.poll();
                Long second = pq.poll();
                long sum = first + second;

                result += sum;
                pq.offer(sum);
            }

            ans.append(String.format("%d\n", result));
        }

        System.out.println(ans);
    }
}
