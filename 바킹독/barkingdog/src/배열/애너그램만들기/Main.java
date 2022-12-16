package 배열.애너그램만들기;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    // 에너 그램 이란, 두 영어 단어 철자의 순서를 바꾸어 같아질 수 있을 때
    // 두개의 영어단어가 주어졌을 떄, 두 단어가 서로 애너그램관계에 있도록 만들기 위해 제거해야 하는 최소 문자의 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();

        // 전체 알파벳 - 중복되는 알파벳 * 2

        int[] alphabetOfFirst = new int[26];
        int[] alphabetOfSecond = new int[26];

        Arrays.stream(first.split("")).forEach(string -> alphabetOfFirst[string.charAt(0) - 'a']++);
        Arrays.stream(second.split("")).forEach(string -> alphabetOfSecond[string.charAt(0) - 'a']++);
        for (int i = 0; i <= 25; i++) {
            alphabetOfFirst[i] = Math.abs(alphabetOfFirst[i] - alphabetOfSecond[i]);
        }

        int answer = Arrays.stream(alphabetOfFirst).sum();
        System.out.println(answer);


    }
}
