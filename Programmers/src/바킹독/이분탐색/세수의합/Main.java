package 바킹독.이분탐색.세수의합;

import java.io.*;
import java.util.*;


public class Main {

    int ans = 0;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                list.add(nums[i] + nums[j]);
            }
        }

        Collections.sort(list);
        int[] sums = list.stream().mapToInt(Integer::valueOf).toArray();

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int target = nums[j] - nums[i];
                int result = bs(sums, target);
                if (result != -1) {
                    ans = Math.max(ans, result+nums[i]);
                }
            }
        }


        System.out.println(ans);
    }

    int bs(int[] nums, int n) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (n < nums[mid]) {
                right = mid - 1;
            } else if (n > nums[mid]) {
                left = mid + 1;
            } else {
                return nums[mid];
            }
        }
        return -1;
    }

}
