import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_11055 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		int[] dp = new int[N + 1];
		int[] array = new int[N + 1];
		String[] input = br.readLine().split(" "); // 수열을 split을 이용하여 공백을 기준으로 나눈 String 배열로 입력 받는다.
		
		
		for (int i = 1; i <= N; i++) {
			array[i] = Integer.valueOf(input[i - 1]); //입력받은 수열이 String이기 때문에, int로 바꾼 후 array 배열을 채운다.
			dp[i]=array[i];
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				if (array[i] > array[j] && dp[j] + array[i] > dp[i]) { 
                //1 ~ i-1 번째 원소들 중 i보다 작은 경우 그리고 현재 dp[i] 보다 dp[j]+array[i]가 큰 경우 업데이트
					dp[i] = dp[j] + array[i]; 
                    
				}

			}
		}
		System.out.println(Arrays.toString(dp));
		Arrays.sort(dp); //dp를 오름차순으로 정렬해줌
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]); // 제일 뒤에있는 값이 최댓값일 것

	}
}