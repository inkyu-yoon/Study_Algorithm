import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class No_11650 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.valueOf(br.readLine());
		Integer[][] array = new Integer[N][2];
		
		
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			array[i][0] = Integer.valueOf(input[0]);
			array[i][1] = Integer.valueOf(input[1]);
		}
		
		
//		System.out.println(Arrays.deepToString(array));
		Arrays.sort(array, new CustomComparator());
//		System.out.println(Arrays.deepToString(array));
		
		
		for (int i = 0; i < N; i++) {
			sb.append(array[i][0]).append(" ").append(array[i][1]).append("\n");
		}
		System.out.println(sb);
	}
}

class CustomComparator implements Comparator<Integer[]> {
	@Override
	public int compare(Integer[] a1, Integer[] a2) {
		if (a1[0].equals(a2[0])) {
			return a1[1] - a2[1];
		}
		return a1[0] - a2[0];
	}
}