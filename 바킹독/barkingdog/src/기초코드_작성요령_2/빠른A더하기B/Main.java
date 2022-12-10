package 기초코드_작성요령_2.빠른A더하기B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.valueOf(br.readLine());
        for (int time = 1; time <= N; time++) {
            String[] input = br.readLine().split(" ");
            sb.append(Integer.valueOf(input[0]) + Integer.valueOf(input[1])+"\n");
        }
        System.out.println(sb);

    }
}
