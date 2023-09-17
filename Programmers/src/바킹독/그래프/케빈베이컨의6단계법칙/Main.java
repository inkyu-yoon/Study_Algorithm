package 바킹독.그래프.케빈베이컨의6단계법칙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]);

        int[][] g = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (r == c) {
                    g[r][c] = 0;
                } else {
                    g[r][c] = 10001;
                }
            }
        }

        while (M-- > 0) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0])-1, v = Integer.parseInt(input[1])-1;

            g[u][v] = 1;
            g[v][u] = 1;
        }


        for (int m = 0; m < N; m++) {
            for (int u = 0; u < N; u++) {
                for (int v = 0; v < N; v++) {
                    g[u][v] = Math.min(g[u][v], g[u][m] + g[v][m]);
                }
            }
        }

        int kevin = 10001;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int[] user = g[i];
            int sum = Arrays.stream(user).sum();
            if (sum < kevin) {
                ans = i + 1;
                kevin = sum;
            }
        }

        System.out.println(ans);

    }
}
