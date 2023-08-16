package 바킹독.이분탐색.좋다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    int N;
    int[] arr;
    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        setUp();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int target = arr[i];
            int left = 0, right = N - 1;
            while (left < right) {
                int sum = arr[left] + arr[right];

                if (left == i) {
                    left++;
                    continue;
                }
                if (right == i) {
                    right--;
                    continue;
                }

                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                   cnt++;
                   break;
                }
            }
        }
        System.out.println(cnt);
    }


    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).sorted().toArray();
    }
}
