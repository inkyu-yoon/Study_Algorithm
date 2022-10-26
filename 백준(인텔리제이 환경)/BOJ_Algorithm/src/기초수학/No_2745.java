package 기초수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2745 {
    public static void main(String[] args) throws IOException {
        //N진법수를 B을 10진수로
        //ZZZZZ 36을 입렫받으면
        //60466175

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String B = input[0];
        int N = Integer.valueOf(input[1]);
        int result =0;
        int num =0;
        for (int i = B.length() - 1; i >= 0; i--) {
            char tmp = B.charAt(B.length() - 1 - i);
            if (tmp >= 'A') {
                num = tmp-'A'+10;
            } else {
                num = tmp - '0';
            }
            result += num * Math.pow(N, i);
        }
        System.out.println(result);

    }
}
