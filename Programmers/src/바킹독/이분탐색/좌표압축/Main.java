package 바킹독.이분탐색.좌표압축;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    // 해당 숫자보다 작은 서로다른 수의 갯수를 구한다.
    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int[] nums = Arrays.stream(arr).distinct().toArray();

        Arrays.sort(nums);
        StringBuilder sb = new StringBuilder();
        for (int n : arr) {
            sb.append(bs(nums,n)+" ");
        }
        System.out.println(sb);
    }
    int bs(int[] nums,int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
