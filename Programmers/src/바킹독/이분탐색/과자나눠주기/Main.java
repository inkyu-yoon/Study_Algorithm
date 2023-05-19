package 바킹독.이분탐색.과자나눠주기;

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
        int M = info[0], N = info[1];
        int[] snacks = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        Arrays.sort(snacks);
        int left = 0,right = snacks[N-1]+1;

        while (left < right) {

            int mid = (left + right) / 2;
            if (mid == 0) {
                break;
            }
            int cnt = 0;
            for (int snack : snacks) {
                cnt += snack / mid;
            }
            if (cnt < M) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(right-1);

    }
}
