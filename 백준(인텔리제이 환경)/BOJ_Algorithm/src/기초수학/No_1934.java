package 기초수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.valueOf(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            int num1 = Integer.valueOf(input[0]);
            int num2 = Integer.valueOf(input[1]);
            int Gcd = gcd(Math.max(num1, num2), Math.min(num1, num2));
            System.out.println(num1 * num2 / Gcd);
        }
    }

    static int gcd(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return gcd(num2, num1 % num2);
    }

}
