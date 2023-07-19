package 바킹독.시뮬레이션.주사위굴리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 지도의 오른쪽은 동쪽 위쪽은 북쪽
// 주사위 놓여져 있는 좌표는 x,y
// 이동한 칸에 쓰여져 있는 수가 0 이면, 주사위 바닥면에 쓰여 있는 수가 칸에 복사
// 0 이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면에 복사되고 칸에 쓰여 있는 수는 0 이됨
// 윗면에 쓰여있는 수를 출력
public class Main {
    int R; int C; int x; int y; int K;
    int[][] board;
    int[][] dice = new int[4][3];

    int[] dr = {0, 0, -1, 1};
    int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        new Main().sol();

    }

    private void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        R = input[0]; C = input[1]; x = input[2]; y = input[3]; K = input[4];
        board = new int[R][C];
        Dice dice = new Dice();

        for (int r = 0; r < R; r++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            for (int c = 0; c < C; c++) {
                board[r][c] = input[c];
            }
        }

        StringBuilder sb = new StringBuilder();

        input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        for (int cmd : input) {
            int nr = x + dr[cmd-1];
            int nc = y + dc[cmd-1];
            if (0 <= nr && nr < R && 0 <= nc && nc < C) {

                switch(cmd){
                    case 1:
                        dice.move1();
                        break;
                    case 2:
                        dice.move2();
                        break;
                    case 3:
                        dice.move3();
                        break;
                    case 4:
                        dice.move4();
                        break;
                }
                if (board[nr][nc] == 0) {
                    board[nr][nc] = dice.down;
                } else {
                    dice.down = board[nr][nc];
                    board[nr][nc] = 0;
                }
                sb.append(dice.up+"\n");
                x = nr;
                y = nc;
            }
        }

        System.out.println(sb);

    }

    static class Dice{
        int up = 0; int down = 0; int left = 0; int right = 0; int front = 0; int back = 0;
        void move1(){
            int tmp = down;
            down = right;
            right = up;
            up = left;
            left = tmp;
        }
        void move2(){
            int tmp = down;
            down = left;
            left = up;
            up = right;
            right = tmp;
        }
        void move3(){
            int tmp = front;
            front = up;
            up = back;
            back = down;
            down = tmp;
        }
        void move4(){
            int tmp = down;
            down = back;
            back = up;
            up = front;
            front = tmp;
        }
    }
}
