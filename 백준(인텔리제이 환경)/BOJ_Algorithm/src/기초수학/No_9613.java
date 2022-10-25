package 기초수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.valueOf(br.readLine());

        for (int i = 1; i <= T; i++) {

            long result = 0;

            String[] input = br.readLine().split(" ");
            for (int j = 1; j < input.length; j++) {
                for (int k = j+1; k < input.length; k++) {
                    result += gcd(Math.max(Integer.valueOf(input[j]), Integer.valueOf(input[k])),
                            Math.min(Integer.valueOf(input[j]), Integer.valueOf(input[k])));
                }
            }


            System.out.println(result);

        }

    }

    static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
