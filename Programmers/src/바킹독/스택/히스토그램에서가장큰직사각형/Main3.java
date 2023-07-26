package 바킹독.스택.히스토그램에서가장큰직사각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> s = new Stack<>();
        while (true) {
            s.clear();
            long ans = 0;

            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            int N = input[0];
            if (N == 0) {
                break;
            }

            long[] arr = new long[N];
            for (int i = 0; i < N; i++) {
                arr[i] = input[i + 1];
            }


            for (int i = 0; i < N; i++) {
                long h = arr[i];
                while (!s.isEmpty() && arr[s.peek()] > h) {
                    int idx = s.pop();
                    long height = arr[idx];
                    int width = s.isEmpty() ? i : i - s.peek() - 1;
                    long area = width * height;
                    ans = Math.max(ans, area);
                }
                s.push(i);
            }

            while (!s.isEmpty()) {
                int idx = s.pop();
                long height = arr[idx];
                long width = s.isEmpty() ? N : N - s.peek() - 1;
                long area = width * height;
                ans = Math.max(ans, area);
            }

            System.out.println(ans);

        }
    }
}
