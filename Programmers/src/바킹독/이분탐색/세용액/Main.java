package 바킹독.이분탐색.세용액;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    int N;
    long[] arr;

    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        setUp();
        long ans = Long.MAX_VALUE;
        String answer = "";
        for (int i = 0; i < N; i++) {
            long fixed = arr[i];
            int left = i + 1;
            int right = N - 1;
            while (left < right) {
                long sum = fixed + arr[left] + arr[right];
                if (sum < 0) {
                    if (Math.abs(sum) < Math.abs(ans)) {
                        ans = sum;
                        answer = String.format("%d %d %d", fixed, arr[left], arr[right]);
                    }
                    left++;
                } else {
                    if (sum < Math.abs(ans)) {
                        ans = sum;
                        answer = String.format("%d %d %d", fixed, arr[left], arr[right]);
                    }
                    right--;
                }
            }
        }
        System.out.println(answer);
    }

    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::valueOf).sorted().toArray();

    }
}
