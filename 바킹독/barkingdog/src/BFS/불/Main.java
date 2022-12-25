package BFS.불;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    // 불은 매 분마다 사바으로 이동
    static int row;
    static int column;
    static char[][] map;
    static int[][] time;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static boolean isEscape;
    static int ans;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        row = Integer.valueOf(input[0]);
        column = Integer.valueOf(input[1]);
        map = new char[row][column];
        time = new int[row][column];
        isEscape = false;

        for (int i = 0; i < row; i++) {
            String info = br.readLine();
            for (int j = 0; j < column; j++) {
                map[i][j] = info.charAt(j);
                if (map[i][j] == 'J') {
                    time[i][j] = 1;
                    if (i == 0 || i == row - 1 || j == 0 || j == column - 1) {
                        isEscape = true;
                    }
                    if (!q.isEmpty()) {
                        q.offer(new int[]{i, j});
                        q.offer(q.poll());
                    } else {
                        q.offer(new int[]{i, j});
                    }
                }

                if (map[i][j] == 'F') {
                    q.offer(new int[]{i, j});
                }
            }
        }
        if (isEscape) {
            System.out.println(1);
            return;
        }
        bfs();

        if (!isEscape) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(ans);
        }

//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < column; j++) {
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < column; j++) {
//                System.out.print(time[i][j]+" ");
//            }
//            System.out.println();
//        }
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int r = point[0];
            int c = point[1];

            for (int i = 0; i <= 3; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if ((0 <= nr && nr < row) && (0 <= nc && nc < column)) {
                    if (map[r][c] == 'J' && map[nr][nc] == '.') {
                        time[nr][nc] = time[r][c] + 1;
                        map[nr][nc] = 'J';
                        q.offer(new int[]{nr, nc});
                        if ((nr == 0 || nr == row - 1 || nc == 0 || nc == column - 1)) {
                            ans = time[nr][nc];

                            // 경계선에 도달했을 때 인접한 곳에 불이 있는지 확인
                            for (int j = 0; j <= 3; j++) {
                                int checkR = nr + dr[j];
                                int checkC = nc + dc[j];
                                if ((0 <= checkR && checkR < row) && (0 <= checkC && checkC < column)) {
                                    if (map[checkR][checkC] == 'F') {
                                        return;
                                    }
                                }
                            }
                            isEscape = true;
                            return;
                        }

                    } else if (map[r][c] == 'F' && (map[nr][nc] == '.' || map[nr][nc] == 'J')) {
                        map[nr][nc] = 'F';
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }
    }
}
/*
4 4
####
#JF#
#..#
#..#

3


3 3
###
#J.
#.F


4 4
###.
##J.
##F#
####
 */
