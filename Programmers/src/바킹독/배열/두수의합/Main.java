package 바킹독.배열.두수의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] nums = new boolean[2000001];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            nums[Integer.parseInt(input[i])] = true;
        }

        int target = Integer.parseInt(br.readLine());

        int cnt = 0;

        for (int i = 1; i < target; i++) {
            if (i >= Math.ceil(target / 2d)) {
                break;
            }
            if (nums[i] && nums[target - i]) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
