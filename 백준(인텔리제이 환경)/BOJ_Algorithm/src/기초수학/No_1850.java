package 기초수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1850 {
    public static void main(String[] args) throws IOException {
        // 두개의 자연수를 입력 받아 최대 공약수와 최소 공배수를 출력
        // ex) 24 18 입력 -> 6 72 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long input1 = Long.valueOf(input[0]);
        long input2 = Long.valueOf(input[1]);


        long Gcd = gcd(Math.max(input1, input2), Math.min(input1, input2));

        System.out.println("1".repeat((int)Gcd));

    }

    static long gcd(long num1, long num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return gcd(num2, num1 % num2);
    }
}
