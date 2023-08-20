package 바킹독.투포인터.수들의합2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    int N;
    int M;
    int[] arr;
    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        setUp();

        System.out.println(getAns());

    }

    private int getAns() {
        int cnt = 0;
        int left = 0, right = 0;
        int sum = arr[right];

        while (right < N) {
            if (sum < M) {
                if (right == N - 1) {
                    break;
                }
                sum += arr[++right];
            } else {
                if (sum == M) {
                    cnt++;
                }
                sum -= arr[left++];
            }
        }

        return cnt;
    }

    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[N];

        input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

    }
}
