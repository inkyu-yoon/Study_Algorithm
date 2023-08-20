package 바킹독.투포인터.수고르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    int N;
    int M;
    int [] arr;
    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        setUp();
        Arrays.sort(arr);

        System.out.println(getAns());

    }

    private int getAns() {
        int ans = Integer.MAX_VALUE;
        int left = 0, right = 0;
        while (right < N) {
            int result = arr[right] - arr[left];
            if (result < M) {
                right++;
            } else if (result == M) {
                return M;
            } else {
                left++;
                ans = Math.min(ans, result);
            }
        }
        return ans;
    }

    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }



    }
}
