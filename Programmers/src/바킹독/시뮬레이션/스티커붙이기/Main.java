package 바킹독.시뮬레이션.스티커붙이기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int R;
    static int C;
    static int K;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);
        map = new int[R][C];
        while (K-- > 0) {
            input = br.readLine().split(" ");
            int row = Integer.parseInt(input[0]), col = Integer.parseInt(input[1]);
            int[][] sticker = new int[row][col];

            for (int r = 0; r < row; r++) {
                input = br.readLine().split(" ");
                for (int c = 0; c < col; c++) {
                    sticker[r][c] = Integer.parseInt(input[c]);
                }
            }


            for (int i = 0; i < 4; i++) {
                if (!check(sticker)) {
                    sticker = turn(sticker);
                } else {
                    break;
                }
            }

        }

        System.out.println(getArea());

    }

    private static int getArea() {
        int result = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == 1) {
                    result++;
                }
            }
        }
        return result;
    }

    private static int[][] turn(int[][] sticker) {
        int row = sticker.length;
        int col = sticker[0].length;
        int[][] result = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[j][row-1-i] = sticker[i][j];
            }
        }


        return result;
    }

    private static boolean check(int[][] sticker) {
        int row = sticker.length;
        int col = sticker[0].length;
        for (int r = 0; r <= R-row; r++) {
            for (int c = 0; c <= C - col; c++) {
                if (isPossible(sticker, r, c)) {
                    attachSticker(sticker,r, c);
                    return true;
                }
            }
        }
        return false;
    }

    private static void attachSticker(int[][] sticker, int r, int c) {
        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[0].length; j++) {
                if (sticker[i][j] == 1) {
                    map[i + r][j + c] = 1;
                }
            }
        }
    }

    private static boolean isPossible(int[][] sticker, int r, int c) {
        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[0].length; j++) {
                if (sticker[i][j] == 1 && map[r + i][c + j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

}
