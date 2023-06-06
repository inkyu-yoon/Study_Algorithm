package 바킹독.dp.가장긴증가하는부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        List<Integer> nums = new ArrayList<>();

        nums.add(arr[0]);

        for (int i = 1; i < n; i++) {
            if (arr[i] > nums.get(nums.size() - 1)) {
                nums.add(arr[i]);
            } else {
                int idx = bs(nums, arr[i]);
                nums.set(idx, arr[i]);
            }
        }
        System.out.println(nums.size());

    }

    private static int bs(List<Integer> nums, int target) {
        int left = 0, right = nums.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target <= nums.get(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
