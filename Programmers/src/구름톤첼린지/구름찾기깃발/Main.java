package 구름톤첼린지.구름찾기깃발;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    int N;
    int K;
    int[][] map;
    int[] dr = {1, 1, 1, 0, 0, -1, -1, -1};
    int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
    int ans = 0;
    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        setUp();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] != 1) {
                    scan(r, c);
                }
            }
        }

        getAns();

    }

    private void getAns() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] == -K) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    private void scan(int r, int c) {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (0 <= nr && nr < N && 0 <= nc && nc < N && map[nr][nc] == 1) {
                cnt++;
            }
        }
        map[r][c] = -cnt;
    }

    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
    }
}
