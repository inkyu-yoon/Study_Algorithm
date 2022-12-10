package 기초코드_작성요령_2.최댓값;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int initial = Integer.valueOf(br.readLine());
        int max = initial;
        int index =1;
        for (int i = 1; i <= 8; i++) {
            int num = Integer.valueOf(br.readLine());
            if (num > max) {
                max = num;
                 index = i + 1;
            }

        }
        System.out.println(max);
        System.out.println(index);
    }
}
