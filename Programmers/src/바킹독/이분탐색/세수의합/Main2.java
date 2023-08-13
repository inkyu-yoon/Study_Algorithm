package 바킹독.이분탐색.세수의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main2 {
    int N;
    int[] arr;
    int[] sums;
    int ans = 0;

    public static void main(String[] args) throws IOException {
        new Main2().sol();
    }

    private void sol() throws IOException {
        setUp();
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                list.add(arr[i] + arr[j]);
            }
        }

        sums = list.stream().mapToInt(Integer::valueOf).toArray();
        Arrays.sort(sums);

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int target = arr[j] - arr[i];
                if (bs(target)) {
                    ans = Math.max(ans, target + arr[i]);
                }
            }
        }

        System.out.println(ans);
    }


    private boolean bs(int target) {
        int left = 0, right = sums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target <= sums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (0 <= left && left < sums.length) {
            if (sums[left] == target) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;

        }
    }

    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }
}
