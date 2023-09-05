package 바킹독.우선순위큐.카드정렬하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while (N-- > 0) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;

        while (true) {
            if (pq.size() <= 1) {
                break;
            }
            int A = pq.poll();
            int B = pq.poll();
            int sum = A + B;
            result += sum;
            pq.add(sum);
        }
        System.out.println(result);
    }
}
