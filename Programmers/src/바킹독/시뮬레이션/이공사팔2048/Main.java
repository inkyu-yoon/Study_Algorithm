package 바킹독.시뮬레이션.이공사팔2048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    static int N;
    static int[][] map;
    static int[][] temp;
    static Stack<Integer> cases;
    static int ans = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        temp = new int[N][N];
        cases = new Stack<>();

        for (int r = 0; r < N; r++) {
            String[] input = br.readLine().split(" ");
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(input[c]);
            }
        }

        bt();
        System.out.println(ans);

    }

    private static void bt() {
        if (cases.size() == 5) {
            run();
            getMax();
            return;
        }

        for (int i = 0; i < 4; i++) {
            cases.push(i);
            bt();
            cases.pop();
        }
    }

    private static void getMax() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                ans = Math.max(ans, temp[r][c]);
            }
        }
    }

    private static void run() {
        deepCopy();
        for (Integer dir : cases) {
            switch (dir) {
                case 0:
                    up();
                    break;
                case 1:
                    down();
                    break;
                case 2:
                    left();
                    break;
                case 3:
                    right();
                    break;
            }
        }
    }

    private static void up() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                for (int i = r+1; i < N; i++) {
                    if (temp[i][c] != 0) {
                        if (temp[i][c] == temp[r][c]) {
                            temp[r][c] *= 2;
                            temp[i][c] = 0;
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        for (int c = 0; c < N; c++) {
            for (int r = 0; r < N; r++) {
                if (temp[r][c] == 0) {
                    for (int i = r + 1; i < N; i++) {
                        if (temp[i][c] != 0) {
                            temp[r][c] = temp[i][c];
                            temp[i][c] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void down() {
        for (int r = N - 1; r > 0; r--) {
            for (int c = 0; c < N; c++) {
                for (int i = r-1; i >=0 ; i--) {
                    if (temp[i][c] != 0) {
                        if (temp[r][c] == temp[i][c]) {
                            temp[r][c] *= 2;
                            temp[i][c] = 0;
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        for (int c = 0; c < N; c++) {
            for (int r = N - 1; r > 0; r--) {
                if (temp[r][c] == 0) {
                    for (int i = r - 1; i >= 0; i--) {
                        if (temp[i][c] != 0) {
                            temp[r][c] = temp[i][c];
                            temp[i][c] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }


    private static void right() {
        for (int r = 0; r < N; r++) {
            for (int c = N - 1; c > 0; c--) {
                for (int i = c-1; i >=0 ; i--) {
                    if (temp[r][i] != 0) {
                        if (temp[r][c] == temp[r][i]) {
                            temp[r][c] *= 2;
                            temp[r][i] = 0;
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = N - 1; c > 0; c--) {
                if (temp[r][c] == 0) {
                    for (int i = c - 1; i >= 0; i--) {
                        if (temp[r][i] != 0) {
                            temp[r][c] = temp[r][i];
                            temp[r][i] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void left() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N - 1; c++) {
                for (int i = c+1; i < N; i++) {
                    if (temp[r][i] != 0) {
                        if (temp[r][c] == temp[r][i]) {
                            temp[r][c] *= 2;
                            temp[r][i] = 0;
                            break;
                        } else {
                            break;
                        }
                    }
                }

            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (temp[r][c] == 0) {
                    for (int i = c + 1; i < N; i++) {
                        if (temp[r][i] != 0) {
                            temp[r][c] = temp[r][i];
                            temp[r][i] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void deepCopy() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                temp[r][c] = map[r][c];
            }
        }
    }
}
