package 바킹독.dp.암호코드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        if (input.startsWith("0")) {
            System.out.println(0);
            System.exit(0);
        }

        int len = input.length();
        String[] nums = new String[len + 1];
        int[] dp = new int[len + 1];

        boolean isError = false;

        for (int i = 1; i <= len; i++) {
            nums[i] = String.valueOf(input.charAt(i - 1));
        }

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= len; i++) {
            int num = Integer.parseInt(nums[i - 1] + nums[i]);
            if ((num != 10 && num != 20 && num % 10 == 0)) {
                isError = true;
                break;
            } else {
                if (num == 10 || num == 20) {
                    dp[i] = dp[i - 2]%1000000;
                } else if (num < 10 || num > 26) {
                    dp[i] = dp[i - 1]%1000000;
                } else{
                    dp[i] = dp[i - 1]%1000000 + dp[i - 2]%1000000;
                }
            }
        }

        if (isError) {
            System.out.println(0);
        } else {
            System.out.println(dp[len]%1000000);
        }


    }

}
