package 바킹독.dp.구간합구하기5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] map = new int[N+1][N+1];

        for (int r = 1; r <= N; r++) {
            input = br.readLine().split(" ");
            for (int c = 1; c <= N; c++) {
                map[r][c] = Integer.parseInt(input[c - 1]);
            }
        }

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                map[r][c] += (map[r - 1][c] + map[r][c - 1] - map[r - 1][c - 1]);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (M-- > 0) {
            input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]), y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]), y2 = Integer.parseInt(input[3]);
            sb.append(map[x2][y2] - (map[x2][y1 - 1] + map[x1 - 1][y2]) + map[x1 - 1][y1 - 1] + "\n");

        }
        System.out.println(sb);


    }
}
