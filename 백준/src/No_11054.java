import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//10
//1 5 2 1 4 3 4 5 2 1
//가장 긴 바이토닉 구하기
public class No_11054 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		int[] dpAsc = new int[N + 1];
		int[] dpDsc = new int[N + 1];
		int[] dpTotal = new int[N + 1];
		int[] array = new int[N + 1];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < input.length; i++) {
			array[i + 1] = Integer.valueOf(input[i]);
			dpAsc[i+1]=1;
			dpDsc[i+1]=1;
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<i;j++) {
				if(array[i]>array[j] && dpAsc[i]<dpAsc[j]+1) {
					dpAsc[i]=dpAsc[j]+1;
				}
				if(array[N+1-i]>array[N+1-j] && dpDsc[N+1-i]<dpDsc[N+1-j]+1) {
					dpDsc[N+1-i]=dpDsc[N+1-j]+1;
				}
			}
		}
		for(int i=1;i<=N;i++) {
			dpTotal[i]=dpAsc[i]+dpDsc[i]-1;
		}
//		System.out.println(Arrays.toString(array));
//		System.out.println(Arrays.toString(dpAsc));
//		System.out.println(Arrays.toString(dpDsc));
//		System.out.println(Arrays.toString(dpTotal));
		Arrays.sort(dpTotal);
		System.out.println(dpTotal[N]);
		
	}
}
