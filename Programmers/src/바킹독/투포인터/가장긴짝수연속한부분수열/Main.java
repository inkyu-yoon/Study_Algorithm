package 바킹독.투포인터.가장긴짝수연속한부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    int N;
    int K;
    int[] arr;
    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        setUp();
        int numOfRemoveChance = K;
        int left = 0, right = -1;
        int ans = 0;
        while (right < N-1) {
            int target = arr[right+1];
            if (target % 2 != 0) {
                if (numOfRemoveChance > 0) {
                    right++;
                    numOfRemoveChance--;
                } else {
                    while (arr[left] % 2 == 0) {
                        left++;
                    }
                    left++;
                    right++;
                }
            } else {
                right++;
            }
            ans = Math.max(ans, (right - left + 1 - (K - numOfRemoveChance)));
        }
        System.out.println(ans);
    }

    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        arr = new int[N];

        K = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
    }
}
