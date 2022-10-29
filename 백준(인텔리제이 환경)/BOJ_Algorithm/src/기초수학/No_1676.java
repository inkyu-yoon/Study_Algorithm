package 기초수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class No_1676 {
    public static void main(String[] args) throws IOException {
        //N! 에서 뒤에서부터 처음 0이 아닌 숫자가 나올때까지 0의 갯수를 구하는 프로그램
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.valueOf(br.readLine());
        int result = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 5 == 0) {
                int num2 =i;
                while (num2 % 5 == 0) {
                    result++;
                    num2 /=5;
                }
            }
        }

        System.out.println(result);

    }
}
