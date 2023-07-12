package 바킹독.배열.애너그램만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr1 = getArr(br);
        int[] arr2 = getArr(br);

        int ans = 0;

        for (int i = 0; i < 26; i++) {
            ans += Math.abs(arr1[i] - arr2[i]);
        }
        System.out.println(ans);
    }

    private static int[] getArr(BufferedReader br) throws IOException {
        char[] first = br.readLine().toCharArray();
        int[] alpha = new int[26];
        for (char c : first) {
            alpha[c - 'a']++;
        }
        return alpha;
    }
}
