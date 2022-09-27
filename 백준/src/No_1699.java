import java.util.Arrays;
import java.util.Scanner;

public class No_1699 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		int[] dp = new int[input + 1];
		for (int i = 1; i <= input; i++) {
			dp[i] = i;
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
			}
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[input]);
	}
}
