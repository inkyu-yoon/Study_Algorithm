package 바킹독.투포인터.부분합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    int N;
    int S;
    int [] arr;
    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        setUp();
        System.out.println(getAns());

    }

    private int getAns() {
        int ans = Integer.MAX_VALUE;

        int left = 0, right = 0;
        int sum = arr[right];
        while (right < N) {
            if (sum < S) {
                if (right == N - 1) {
                    break;
                }
                sum += arr[++right];
            } else {
                ans = Math.min(ans, right - left + 1);
                sum -= arr[left++];
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;

    }

    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);
        arr = new int[N];

        input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

    }
}
