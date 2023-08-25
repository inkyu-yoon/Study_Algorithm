package 바킹독.투포인터.구간자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    int N;
    int K;
    long[] arr;

    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        setUp();
        int left = 0, right = 0;
        long sum = 0;

        while (right < 1000001) {
            if (sum < K) {
                sum += arr[++right];
            } else if (sum > K) {
                sum -= arr[++left];
            } else {
                System.out.println(left + " " + right);
                System.exit(0);
                break;
            }
        }
        System.out.println("0 0");


    }


    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        arr = new long[1000002];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            int left = Integer.parseInt(input[0]), right = Integer.parseInt(input[1]);
            for (int j = left + 1; j < right + 1; j++) {
                arr[j] += 1;
            }
        }
    }
}
