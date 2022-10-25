package 기초수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2609 {
    public static void main(String[] args) throws IOException {
        // 두개의 자연수를 입력 받아 최대 공약수와 최소 공배수를 출력
        // ex) 24 18 입력 -> 6 72 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int num1 = Integer.valueOf(input[0]);
        int num2 = Integer.valueOf(input[1]);
        int Gcd = gcd(Math.max(num1, num2), Math.min(num1, num2));
        int Lcm = (num1 * num2) / Gcd;
        System.out.println(Gcd);
        System.out.println(Lcm);

    }

    static int gcd(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return gcd(num2, num1 % num2);
    }

}
