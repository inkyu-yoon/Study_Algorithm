package 바킹독.이분탐색.랜선자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int K = info[0], N = info[1];

        long[] arr = new long[K];
        long right = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(arr[i],right);
        }

        right++;
        long left = 0;
        while (left < right) {
            long mid = (left + right) / 2;
            int cnt = getNum(arr, mid);
            if (cnt < N) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left-1);

    }

    int getNum(long[] arr, long length) {
        int result = 0;
        for (long num : arr) {
            result += num / length;
        }

        return result;
    }

}
