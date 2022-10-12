package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


//소문자 대문자 숫자 공백 갯수 구하기
public class No_10820 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while ((input = br.readLine()) != null) {
            int count_small = 0;
            int count_large = 0;
            int count_num = 0;
            int count_space = 0;
            for (int i = 0; i < input.length(); i++) {
                if ('a' <= input.charAt(i) && input.charAt(i) <= 'z') {
                    count_small++;
                } else if ('A' <= input.charAt(i) && input.charAt(i) <= 'Z') {
                    count_large++;
                } else if ('0' <= input.charAt(i) && input.charAt(i) <= '9') {
                    count_num++;
                } else if (input.charAt(i) == ' ') {
                    count_space++;
                }
            }
            System.out.println(count_small + " " + count_large + " " + count_num + " " + count_space + " ");

        }

    }
}