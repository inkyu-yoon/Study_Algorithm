package 바킹독.이분탐색.예산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    int N;
    long [] arr;
    int M;
    long max = 0;
    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        setUp();
        long left = 0, right = max;
        while (left < right) {
            long mid = (left + right) / 2;
            long num = getNum(mid);
            if (num > M) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left-1);
    }

    private long getNum(long mid) {
        long result = 0;
        for (long l : arr) {
            if (l > mid) {
                result += mid;
            } else {
                result += l;
            }
        }
        return result;
    }

    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new long[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(input[i]);
            max = Math.max(max, arr[i]);
        }
        max++;


        M = Integer.parseInt(br.readLine());
    }
}
