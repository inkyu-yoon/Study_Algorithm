package 바킹독.이분탐색.용액;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    int N;
    int[] arr;
    int[] di = {1, 0, -1};
    int sum = Integer.MAX_VALUE;
    String ans;

    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        setUp();
        for (int i = 0; i < N; i++) {
            int num = arr[i];
            int target = num * -1;
            int idx = bs(arr, target);
            for (int j = 0; j < 3; j++) {
                int nidx = idx + di[j];
                if (0 <= nidx && nidx < N && nidx != i) {
                    check(num, arr[nidx]);
                }
            }
        }
        System.out.println(ans);
    }

    private void check(int num1, int num2) {
        int result = Math.abs(num1 + num2);
        if (result < sum) {
            sum = result;
            ans = String.format("%d %d", Math.min(num1, num2), Math.max(num1, num2));
        }
    }

    private int bs(int[] arr, int target) {
        int left = 0,right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target <= arr[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
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
