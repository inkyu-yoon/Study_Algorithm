import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_2579 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		int[] dp = new int[N + 2];
		int[] array = new int[N + 2];
		for (int i = 1; i <= N; i++) {
			array[i] = Integer.valueOf(br.readLine());
		}
		dp[1] = array[1];
		dp[2] = array[1] + array[2];
			for (int i = 3; i <= N; i++) {

					dp[i] = Math.max(dp[i - 3] + array[i - 1] + array[i], dp[i - 2] + array[i]); 
			}
//		System.out.println(Arrays.toString(array));
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);
	}
}
