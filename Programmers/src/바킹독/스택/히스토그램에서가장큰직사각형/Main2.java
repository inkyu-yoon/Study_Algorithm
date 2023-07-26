package 바킹독.스택.히스토그램에서가장큰직사각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input;
        Stack<Integer> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while (true) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

            int n = input[0];

            if (n == 0) {
                break;
            }

            long[] arr = new long[n];

            for (int i = 0; i < n; i++) {
                arr[i] = input[i + 1];
            }

            s.clear();

            long ans = 0;

            for (int i = 0; i < n; i++) {
                long h = arr[i];
                while (!s.isEmpty() && arr[s.peek()] > h) {
                    int idx = s.pop();
                    long height = arr[idx];
                    int width = s.isEmpty() ? i : i - s.peek() - 1;

                    long area = height * width;

                    ans = Math.max(ans, area);
                }

                s.push(i);
            }

            while (!s.isEmpty()) {
                int idx = s.pop();
                long height = arr[idx];
                int width = s.isEmpty() ? n : n - s.peek() - 1;
                long area = height * width;

                ans = Math.max(ans, area);
            }

            sb.append(ans + "\n");
        }
        System.out.println(sb);
    }
}
