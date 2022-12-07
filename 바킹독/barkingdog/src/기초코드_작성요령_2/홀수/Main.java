package 기초코드_작성요령_2.홀수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int min = 100;
        for (int i = 1; i <= 7; i++) {
            int num = Integer.valueOf(br.readLine());
            if (num % 2 != 0) {
                sum += num;
                min = Math.min(min, num);
            }
        }
        if (sum == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(sum);
        System.out.println(min);

    }
}
