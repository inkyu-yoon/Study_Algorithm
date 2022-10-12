package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_10824 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long num1 = Long.valueOf((input[0] + input[1]));
        long num2 = Long.valueOf((input[2] + input[3]));
        System.out.println(num1 + num2);

    }
}
