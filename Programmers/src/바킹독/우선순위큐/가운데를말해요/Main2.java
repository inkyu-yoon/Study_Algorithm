package 바킹독.우선순위큐.가운데를말해요;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> right = new PriorityQueue<>();

        StringBuilder ans = new StringBuilder();

        while (N-- > 0) {
            int n = Integer.parseInt(br.readLine());

            if (left.isEmpty()) {
                left.offer(n);
            } else {
                Integer maxOfLeft = left.peek();

                if (maxOfLeft >= n) {
                    left.offer(n);
                } else {
                    right.offer(n);
                }
            }

            arrangeQueueSize(left, right);

            ans.append(left.peek() + "\n");
        }

        System.out.println(ans);
    }

    private static void arrangeQueueSize(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
        int sizeOfLeft = left.size();
        int sizeOfRight = right.size();

        if (sizeOfLeft < sizeOfRight) {
            left.offer(right.poll());
        } else {
            if (sizeOfLeft > sizeOfRight + 1) {
                right.offer(left.poll());
            }
        }


    }
}
