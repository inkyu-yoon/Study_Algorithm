package 기초수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class No_1212 {
    public static void main(String[] args) throws IOException {
        //8진수가 주어졌을 떄, 2진수로 변환하는 프로그램
        //314 -> 11001100
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            int num = input.charAt(i) - '0';
            String change = Integer.toBinaryString(num);
            if (i > 0) {
                if (change.length() == 1) {
                    sb.append("00");
                }
                if (change.length() == 2) {
                    sb.append("0");
                }
            }
                sb.append(change);
        }
        System.out.println(sb);

    }
}
