package 구름톤첼린지.폭탄구현하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    int N;
    int K;
    String[][] map;
    int[][] score;

    List<int[]> bombs = new ArrayList<>();
    int[] dr = {0, 0, 0, 1, -1};
    int[] dc = {0, 1, -1, 0, 0};
    int ans;

    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        setUp();
        for (int[] bomb : bombs) {
            explode(bomb[0], bomb[1]);
        }

        getMax();

        System.out.println(ans);

    }

    private void getMax() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                ans = Math.max(ans, score[r][c]);
            }
        }
    }

    private void explode(int r, int c) {
        for (int i = 0; i < 5; i++) {
            int nr = r + dr[i], nc = c + dc[i];
            if (0 <= nr && nr < N && 0 <= nc && nc < N) {
                if (map[nr][nc].equals("0")) {
                    score[nr][nc] += 1;
                } else if (map[nr][nc].equals("@")) {
                    score[nr][nc] += 2;
                }
            }
        }
    }

    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        map = new String[N][N];
        score = new int[N][N];

        for (int r = 0; r < N; r++) {
            input = br.readLine().split(" ");
            for (int c = 0; c < N; c++) {
                map[r][c] = input[c];
            }
        }

        for (int i = 0; i < K; i++) {
            input = br.readLine().split(" ");
            bombs.add(new int[]{Integer.parseInt(input[0])-1, Integer.parseInt(input[1])-1});
        }
    }
}
