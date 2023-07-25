package 바킹독.스택.히스토그램에서가장큰직사각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            long ans = 0;
            String[] input = br.readLine().split(" ");

            if (input[0].equals("0")) {
                break;
            }

            int n = Integer.parseInt(input[0]);

            long[] arr = new long[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(input[i + 1]);
            }

            Stack<Integer> s = new Stack<>();

            for (int i = 0; i < n; i++) {
                long h = arr[i];
                while (!s.isEmpty() && arr[s.peek()] > h) {
                    int idx = s.pop();
                    long height = arr[idx];
                    int width = i;
                    if (!s.isEmpty()) {
                        width = i - s.peek()-1;
                    }
                    long area = width * height;
                    ans = Math.max(ans, area);
                }

                s.push(i);
            }

            while (!s.isEmpty()) {
                int idx = s.pop();
                int width = n;
                if (!s.isEmpty()) {
                    width = n - s.peek()-1;
                }
                long area = width * arr[idx];
                ans = Math.max(ans, area);

            }



            System.out.println(ans);
        }


    }
}
