package 바킹독.우선순위큐.최소힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        StringBuilder ans = new StringBuilder();
        while (N-- > 0) {
            // 만약 x가 자연수 라면 배열에 x값을 넣는다.
            int x = Integer.parseInt(br.readLine());

            if (x != 0) {
                pq.offer(x);
            }
            // 만약 x가 0이라면 가장 적은 값을 출력하고 제거한다.
            else {
                int removed = pq.isEmpty() ? 0 : pq.poll();
                ans.append(String.format("%d\n", removed));
            }
        }

        System.out.println(ans);
    }
}
