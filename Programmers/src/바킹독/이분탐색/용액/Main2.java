package 바킹독.이분탐색.용액;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main2 {
    int N;
    int[] arr;

    public static void main(String[] args) throws IOException {
        new Main2().sol();
    }

    private void sol() throws IOException {
        setUp();
        int result = Integer.MAX_VALUE;
        int left = 0;
        int right = N - 1;
        String ans = "";
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(sum) < result) {
                ans = String.format("%d %d", arr[left], arr[right]);
                result = Math.abs(sum);
            }
            if (sum >= 0) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(ans);
    }


    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
    }
}
