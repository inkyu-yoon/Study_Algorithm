package 바킹독.연결리스트.요세푸스문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int N = input[0];
        int K = input[1];
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            dq.offer(i);
        }
        int cnt = 1;

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!dq.isEmpty()) {
            if (cnt == K) {
                int num = dq.poll();
                sb.append(num+", ");
                cnt = 1;
            } else {
                cnt++;
                dq.offer(dq.poll());
            }
        }
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        sb.append(">");
        System.out.println(sb);
    }
}
