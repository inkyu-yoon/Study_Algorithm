import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_11722 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		String [] input = br.readLine().split(" ");
		int [] array = new int [N+1];
		int [] dp = new int [N+1];
		for(int i=1;i<array.length;i++) {
			array[i]=Integer.valueOf(input[i-1]);
			dp[i]=1;
		}
//		System.out.println(Arrays.toString(array));
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<i;j++) {
				if(array[i]<array[j] && dp[i]<dp[j]+1) {
					dp[i]=dp[j]+1;
				}
			}
		}
//		System.out.println(Arrays.toString(dp));
		Arrays.sort(dp);
		System.out.println(dp[N]);
	}
}
