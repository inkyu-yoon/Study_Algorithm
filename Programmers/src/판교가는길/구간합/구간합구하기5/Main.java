package 판교가는길.구간합.구간합구하기5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    int N;
    int M;
    int[][] board;



    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        board = new int[N + 1][N + 1];
        for (int r = 1; r <= N; r++) {
            input = br.readLine().split(" ");
            for (int c = 1; c <= N; c++) {
                board[r][c] = Integer.parseInt(input[c - 1])+board[r-1][c]+board[r][c-1]-board[r-1][c-1];
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int r1 = Integer.parseInt(input[0]), c1 = Integer.parseInt(input[1]);
            int r2 = Integer.parseInt(input[2]), c2 = Integer.parseInt(input[3]);

            sb.append(board[r2][c2] - (board[r2][c1-1] + board[r1-1][c2]) + board[r1 - 1][c1 - 1]+"\n");
        }
        System.out.println(sb);

    }

}
