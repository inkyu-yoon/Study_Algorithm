package BFS.불2;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    // 벽을 통과할 수 없다.
    // 불이 옮겨진 칸 또는 불이 붙으려는 칸으로 이동할 수 없다.
    // 상근이가 있는 칸은 불이 옮겨옴과 동시에 이동할 수 있다.
    // 얼마나 빨리 탈출할 수 있는지 구하시오
    static int row;
    static int column;
    static String[][] map;
    static Queue<int[]> person;
    static Queue<int[]> q;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int[][] time;
    static boolean isEscape;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.valueOf(br.readLine());
        while (T-- > 0) {
            int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.valueOf(s)).toArray();

            isEscape = false;
            row = info[1];
            column = info[0];
            map = new String[row][column];
            time = new int[row][column];
            person = new LinkedList<>();
            q = new LinkedList<>();

            /*
            맵 생성
             */

            for (int i = 0; i < row; i++) {

                String[] input = br.readLine().split("");

                for (int j = 0; j < column; j++) {

                    map[i][j] = input[j];

                    if (input[j].equals("*")) {

                        q.offer(new int[]{i, j, 1});

                    } else if (input[j].equals("@")) {
                        if(i == 0 || i == row - 1 || j == 0 || j == column - 1){
                            sb.append("1\n");
                            isEscape = true;
                            break;
                        }
                        person.offer(new int[]{i, j, 0});
                        time[i][j] = 1;

                    }
                }
            }
            if (isEscape) {
                continue;
            }
            q.offer(person.poll());
            sb.append(bfs());

        }
        System.out.println(sb);

    }

    private static String bfs() {
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int r = point[0];
            int c = point[1];
            // 불이면 1, 사람이면 0
            int isFire = point[2];
            for (int i = 0; i <= 3; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if ((0 <= nr && nr < row) && (0 <= nc && nc < column)) {

                    if (isFire == 1) {
                        if (map[nr][nc].equals(".") || map[nr][nc].equals("@")) {
                            map[nr][nc] = "*";
                            q.offer(new int[]{nr, nc, 1});
                        }
                    } else if (isFire == 0) {
                        if (map[nr][nc].equals(".")) {
                            map[nr][nc] = "@";
                            q.offer(new int[]{nr, nc, 0});
                            time[nr][nc] = time[r][c] + 1;
                            if (nr == 0 || nr == row - 1 || nc == 0 || nc == column - 1) {
                                isEscape = true;
                                return time[nr][nc] + "\n";
                            }
                        }
                    }
                }
            }
        }
        return "IMPOSSIBLE\n";
    }


    static void printMap(Object[][] arr) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
/*
5
4 3
###*
#*@.
####
7 6
###.###
#*#.#*#
#.....#
#.....#
#..@..#
#######
7 4
###.###
#....*#
#@....#
.######
5 5
.....
.***.
.*@*.
.***.
.....
3 3
###
#@#
###

2
5
IMPOSSIBLE
IMPOSSIBLE
IMPOSSIBLE
 */
