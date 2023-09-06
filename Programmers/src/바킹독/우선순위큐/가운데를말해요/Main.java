package 바킹독.우선순위큐.가운데를말해요;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> right = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {

            int n = Integer.parseInt(br.readLine());

            if (left.isEmpty()) {
                left.add(n);
            } else {
                if (left.peek() <= n) {
                    right.offer(n);
                } else {
                    left.offer(n);
                }
            }

            arrangeQueue(left, right);
            sb.append(left.peek() + "\n");
        }
        System.out.println(sb);
    }

    private static void arrangeQueue(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {

        if (left.size() > right.size()) {
            while (!left.isEmpty() && left.size() > right.size() + 1) {
                right.offer(left.poll());
            }
        } else {
            while (!right.isEmpty() && left.size() < right.size()) {
                left.offer(right.poll());
            }
        }


    }
}
