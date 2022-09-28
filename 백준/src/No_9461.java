import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_9461 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine());
		long[] dp = new long[101];
		
		dp[1]=1;dp[2]=1;dp[3]=1;
		dp[4]=2;dp[5]=2;
		for(int i=6;i<=100;i++) {
			dp[i]=dp[i-5]+dp[i-1];
		}
		for(int i=1;i<=T;i++) {
			System.out.println(dp[Integer.valueOf(br.readLine())]);
		}

	}
}
