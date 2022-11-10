package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No_7576 {
    //1은 익은 토마토
    //0은 익지 않은 토마토
    //-1 토마토가 들어있지 않음
    // 익지 않은 토마토는 익은 토마토와 인접할 경우 1일 뒤 익는다.
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int row, column;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        column = Integer.valueOf(input[0]);
        row = Integer.valueOf(input[1]);

        map = new int[row + 2][column + 2];
        for (int i = 0; i < row + 2; i++) {
            for (int j = 0; j < column + 2; j++) {
                map[i][j] = -1;
            }
        }
        for (int i = 1; i <= row; i++) {
            String[] mapInput = br.readLine().split(" ");
            for (int j = 1; j <= column; j++) {
                map[i][j] = Integer.valueOf(mapInput[j - 1]);
                if (map[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
            }
        }
        System.out.println(bfs());

    }

    static int bfs() {
        //bfs 실행 ( 너비 탐색 )
        while (!q.isEmpty()) {
            int[] tomato = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tomato[0] + dx[i];
                int ny = tomato[1] + dy[i];
                if (map[nx][ny] == 0) {
                    map[nx][ny] = map[tomato[0]][tomato[1]] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        //bfs가 끝나고, 0이 남아 있는 경우 -1 리턴
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (map[i][j] == 0) {
                    return -1;
                }
            }
        }

        // 다 익었다면, 최고값을 찾음, 최고값 -1 이 경과한 날 수 일 것
        int max = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (max < map[i][j]) {
                    max = map[i][j];
                }
            }
        }

        //max 값이 1이라면, 처음부터 다 익어있던 상태
        if (max == 1) {
            return 0;
        } else {
            return max-1;
        }
    }
}
/* 예제 입력
6 4
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 1
 */

/*
8
 */