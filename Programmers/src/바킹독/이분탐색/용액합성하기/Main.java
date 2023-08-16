package 바킹독.이분탐색.용액합성하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    int N;
    int [] arr;
    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        setUp();

        int ans = Integer.MAX_VALUE;
        int left = 0, right = N - 1;
        while (left < right){
            int sum = arr[left] + arr[right];
            if (sum > 0) {
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                ans = 0;
                break;
            }
            if (sum < 0 && Math.abs(sum) < Math.abs(ans)) {
                ans = sum;
            } else if (sum > 0 && sum < Math.abs(ans)) {
                ans = sum;
            }
        }
        System.out.println(ans);
    }

    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

    }
}
