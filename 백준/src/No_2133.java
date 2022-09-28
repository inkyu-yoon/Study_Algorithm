import java.util.Arrays;
import java.util.Scanner;

public class No_2133 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		long [] dp = new long [N+2];
		dp[2] = 3;
		for(int n=4;n<=N;n+=2) {
			dp[n]+=dp[n-2]*dp[2];
			for(int j=2;j<=n-4;j+=2) {
				dp[n]+=2*dp[j];
			}
			dp[n]+=2;
		}
		
		System.out.println(dp[N]);
//		System.out.println(Arrays.toString(dp));
	}
}
