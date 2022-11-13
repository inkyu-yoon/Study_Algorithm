package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//높이가 주어짐
//안전지역 갯수 구하기
//비의 양에 따라서 안전지역의 갯수가 달라짐
//높이는 1이상 100이하
public class No_2468 {
    static int N,count;
    static int[][] map;
    static boolean[][] marked;
    static int maxHeight;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        map = new int[N + 2][N + 2];
        maxHeight = 1;
        int max =1;
        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.valueOf(input[j - 1]);
                if (maxHeight < map[i][j]) {
                    maxHeight = map[i][j];
                }
            }
        }

        for (int rainHeight = 1; rainHeight <= maxHeight; rainHeight++) {
            count = 0;
            marked = new boolean[N + 2][N + 2];
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (marked[j][k] == false && map[j][k]>=rainHeight) {
                        dfs(j, k, rainHeight);
                        count++;
                    }
                }
            }
             max = Math.max(max,count);

        }
        System.out.println(max);
    }

    static void dfs(int x, int y, int rainHeight) {
        if (marked[x][y] == false && map[x][y] >= rainHeight) {
            marked[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                dfs(nx, ny, rainHeight);
            }
        }
    }
}
/* 예제 입력
5
6 8 2 6 2
3 2 3 4 6
6 7 3 3 2
7 2 5 3 6
8 9 5 2 7
 */
//5