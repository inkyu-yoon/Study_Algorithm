package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        String str;
        StringBuilder[] sbArray = new StringBuilder[10001];
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < sbArray.length; i++) {
            sbArray[i] = new StringBuilder();
        }

        for (int i = 1; i <= N; i++) {
            str = br.readLine();
            sbArray[Integer.valueOf(str)].append(str + "\n");
        }
        for (StringBuilder sb : sbArray) {
            result.append(sb);
        }
        System.out.println(result);
    }
}
