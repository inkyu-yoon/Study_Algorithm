package 바킹독.배열.방배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 성별과 학년이 같아야 하고 한 방에 한명만 배정 가능, 최대 K명
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] students = new int[7][2];
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            int sex = Integer.parseInt(input[0]);
            int grade = Integer.parseInt(input[1]);
            students[grade][sex]++;
        }


        int ans = 0;
        for (int g = 1; g < 7; g++) {
            for (int s = 0; s < 2; s++) {
                ans += Math.ceil(students[g][s] / (double) K);
            }
        }
        System.out.println(ans);
    }
}
