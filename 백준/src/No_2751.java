import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2751 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.valueOf(br.readLine()); //수는 절댓값이 1000000 보다 작거나 같은 정수가 주어진다.
		boolean [] array = new boolean[2000001];
		for(int i=1;i<=N;i++) {
			array[Integer.valueOf(br.readLine())+1000000]=true;
		}
		for(int i=0;i<array.length;i++) {
			if(array[i]) {
				sb.append(i-1000000).append("\n");
			}
		}
		System.out.println(sb);
		
		
	}
}
