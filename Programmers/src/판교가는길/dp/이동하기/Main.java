package 판교가는길.dp.이동하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]);
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int r = 1; r < N; r++) {
            map[r][0] += map[r - 1][0];
        }
        for (int c = 1; c < M; c++) {
            map[0][c] += map[0][c-1];
        }

        for (int r = 1; r < N; r++) {
            for (int c = 1; c < M; c++) {
                map[r][c] = Math.max(map[r - 1][c], map[r][c - 1]) + map[r][c];
            }
        }
        System.out.println(map[N-1][M-1]);

    }
}
