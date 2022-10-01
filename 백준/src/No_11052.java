import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_11052 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		int [] dp = new int[N+1];
		String [] input = br.readLine().split(" ");
		int [] cardPack = new int [N+1];
		for(int i=0;i<N;i++) {
			cardPack[i+1] = Integer.valueOf(input[i]);
		}
		
//		System.out.println(Arrays.toString(cardPack));
		
		for(int i=1;i<=N;i++) {
			dp[i]=cardPack[i];
			for(int j =1;j<=i-1;j++) {
				dp[i]=Math.max(dp[i], dp[j]+dp[i-j]);
			}
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);
	}
	
}
