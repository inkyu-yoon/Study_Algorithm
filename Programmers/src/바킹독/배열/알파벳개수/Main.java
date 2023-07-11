package 바킹독.배열.알파벳개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] S = br.readLine().toCharArray();
        int[] ans = new int[26];

        for (char c : S) {
            ans[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            sb.append(ans[i] + " ");
        }
        System.out.println(sb);
    }
}
