import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_1912 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		long[] dp = new long[N + 1];
		long[] array = new long[N + 1];
		String[] input = br.readLine().split(" ");

		for (int i = 1; i <= N; i++) {
			array[i] = Integer.valueOf(input[i - 1]);
		}
		
		dp[1] = array[1];

		for (int i = 1; i <= N; i++) {
			dp[i] = array[i] + dp[i - 1];
			if (dp[i] <= 0) {

				dp[i] = 0;
			}
		}

		Arrays.sort(dp);
		Arrays.sort(array);
//		System.out.println(Arrays.toString(dp));
//		System.out.println(Arrays.toString(array));
		if (dp[N] == 0) {
			System.out.println(array[N - 1]);
		} else
			System.out.println(dp[N]);
	}
}
