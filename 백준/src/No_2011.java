import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2011 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		long[] dp = new long[input.length()+1];
		
		dp[0] =1;
		dp[1] = 1; // 0인 경우 제외하면 무조건 1개
		
		if (input.charAt(0) == '0') {
			System.out.println(0);
			return;
		}
		
		
		for (int i = 1; i < input.length(); i++) {
			char front = input.charAt(i-1); //앞 숫자
			char back = input.charAt(i);
			int num = (front-'0')*10+(back-'0');
			if(back>='1' && back<='9') {
				dp[i+1]=dp[i];
				 dp[i+1]%=1000000;
			}
			if((num>=10 && num<=26)) {
				dp[i+1]+=dp[i-1];
				 dp[i+1]%=1000000;
			}
			
		}
		System.out.println(dp[input.length()]%1000000);
	}

}
