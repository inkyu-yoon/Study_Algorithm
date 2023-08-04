package 바킹독.덱.최솟값찾기;

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
        int N = input[0], L = input[1];

        input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        Deque<Integer> dq = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int num = input[i];


            while (!dq.isEmpty() && input[dq.peekLast()] > num) {
                dq.pollLast();
            }

            dq.offerLast(i);

            if (dq.peekFirst() < i - L + 1) {
                dq.pollFirst();
            }


            sb.append(input[dq.peekFirst()] + " ");
        }

        System.out.println(sb);

    }
}
