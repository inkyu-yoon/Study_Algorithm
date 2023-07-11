package 바킹독.배열.숫자의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine()), B = Integer.parseInt(br.readLine()), C = Integer.parseInt(br.readLine());
        char[] result = String.valueOf(A * B * C).toCharArray();
        int[] ans = new int[10];
        for (char ch : result) {
            ans[ch - '0']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : ans) {
            sb.append(i + "\n");
        }
        System.out.println(sb);

    }
}
