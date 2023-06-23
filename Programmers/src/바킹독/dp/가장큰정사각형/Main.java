package 바킹독.dp.가장큰정사각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int R = Integer.parseInt(input[0]), C = Integer.parseInt(input[1]);
        int ans = 0;

        int[][] g = new int[R][C];
        for (int r = 0; r < R; r++) {
            input = br.readLine().split("");
            for (int c = 0; c < C; c++) {
                g[r][c] = Integer.parseInt(input[c]);
                ans = Math.max(ans, g[r][c]);
            }
        }

        for (int r = 1; r < R; r++) {
            for (int c = 1; c < C; c++) {
                if (g[r][c] != 0) {
                    if (g[r - 1][c] != 0 && g[r][c - 1] != 0 && g[r - 1][c - 1] != 0) {
                        g[r][c] = Math.min(Math.min(g[r - 1][c], g[r][c - 1]), g[r - 1][c - 1]) + 1;
                        ans = Math.max(ans, g[r][c]);
                    }
                }
            }
        }


        System.out.println(ans*ans);
    }
}
