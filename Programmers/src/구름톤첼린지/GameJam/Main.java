package 구름톤첼린지.GameJam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    int N;
    int[] goorm;
    int[] player;
    String[][] map;

    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        setUp();
        int g = run(goorm);
        int p = run(player);
        if (g > p) {
            System.out.println("goorm " + g);
        } else {
            System.out.println("player " + p);
        }
    }

    private int run(int[] point) {
        boolean[][] checked = new boolean[N][N];
        int r = point[0], c = point[1];
        checked[r][c] = true;
        int score = 0;
        while (true) {
            String s = map[r][c];
            int cnt = Integer.parseInt(s.substring(0, s.length()));
            String dir = s.substring(s.length()-1);

            if (dir.equals("R")) {
                c = (c + cnt) % N;
            } else if (dir.equals("L")) {
                c = (c - cnt + N) % N;
            } else if (dir.equals("U")) {
                r = (r - cnt + N) % N;
            } else if (dir.equals("D")) {
                r = (r + cnt) % N;
            }

            if (checked[r][c]) {
                return score;
            } else {
                checked[r][c] = true;
                score++;
            }
        }



    }


    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        goorm = new int[]{Integer.parseInt(input[0]) - 1, Integer.parseInt(input[1]) - 1};

        input = br.readLine().split(" ");
        player = new int[]{Integer.parseInt(input[0]) - 1, Integer.parseInt(input[1]) - 1};

        map = new String[N][N];
        for (int r = 0; r < N; r++) {
            input = br.readLine().split(" ");
            for (int c = 0; c < N; c++) {
                map[r][c] = input[c];
            }
        }

    }
}
