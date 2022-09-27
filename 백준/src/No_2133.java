import java.util.Arrays;
import java.util.Scanner;

public class No_2133 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		long [] dp = new long [N+2];
		dp[0] = 1; //각 케이스마다 존재하는 예외상황 2개
		dp[2] = 3;
		for(int i=4;i<=N;i+=2) {
			dp[i]+=dp[i-2]*dp[2];
			for(int j=0;j<=i-4;j+=2) {
				dp[i]+=2*dp[j];
			}
		}
		
		System.out.println(dp[N]);
		System.out.println(Arrays.toString(dp));
	}
}
