package 배열.알파벳개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//알파벳 소문자로만 이루어진 단어 S가 주어진다. 각 알파벳이 단어에 몇 개가 포함되어 있는지 구하는 프로그램을 작성하시오.
/*
baekjoon

1 1 0 0 1 0 0 0 0 1 1 0 0 1 2 0 0 0 0 0 0 0 0 0 0 0
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] input = br.readLine().split("");
        int[] arr = new int[26];
        for(String s : input){
            arr[s.charAt(0) - 'a']++;
        }

        for(int element : arr){
            sb.append(element + " ");
        }
        System.out.println(sb);
    }
}
