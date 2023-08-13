package 바킹독.이분탐색.수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        int M = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(input[i]);
            if (isExist(arr,target)) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean isExist(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (target <= arr[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (0 <= left && left < arr.length) {
            if (arr[left] == target) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
