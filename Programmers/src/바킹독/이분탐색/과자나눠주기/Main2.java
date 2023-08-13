package 바킹독.이분탐색.과자나눠주기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main2 {
    int M;
    int N;
    int[] snacks;
    int max = 0;
    public static void main(String[] args) throws IOException {
        new Main2().sol();
    }

    private void sol() throws IOException {
        setUp();
        System.out.println(getAns());

    }

    private int getAns() {
        int left = 0, right = max;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid == 0) {
                return 0;
            }
            if (getNum(mid) < M) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left-1;
    }

    private int getNum(int mid) {
        int cnt = 0;
        for (int snack : snacks) {
            cnt += snack / mid;
        }
        return cnt;
    }

    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        snacks = new int[N];

        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            snacks[i] = Integer.parseInt(input[i]);
            max = Math.max(max, snacks[i]);
        }

        max++;
    }
}
