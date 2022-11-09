package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*예제 입력
1 1
0
2 2
0 1
1 0
3 2
1 1 1
1 1 1
5 4
1 0 1 0 0
1 0 0 0 0
1 0 1 0 1
1 0 0 1 0
5 4
1 1 1 0 1
1 0 1 0 1
1 0 1 0 1
1 0 1 1 1
5 5
1 0 1 0 1
0 0 0 0 0
1 0 1 0 1
0 0 0 0 0
1 0 1 0 1
0 0
 */
/* 예제 출력
0
1
1
3
1
9
 */
public class No_4963 {
    //섬의 갯수를 세기
    //대각선도 연결되어있는 것으로 간주
    //1은 땅, 0은 바다
    //입력 마지막 줄에는 00 들어옴
    static boolean[][] marked;
    static int[][] map;
    static int[] dx = {-1,-1,-1,1,1,1,0,0};
    static int[] dy = {-1,0,1,1,0,-1,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] input = br.readLine().split(" ");
            //종료
            if (input[0].equals("0")) {
                break;
            }
            int count = 0;
            int w = Integer.valueOf(input[0]);
            int h = Integer.valueOf(input[1]);

            map = new int[h + 2][w + 2];
            marked = new boolean[h + 2][w + 2];

            //map 생성
            for (int i = 1; i <= h; i++) {
                String[] input2 = br.readLine().split(" ");
                for (int j = 1; j <= w; j++) {
                    map[i][j] = Integer.valueOf(input2[j - 1]);
                }
            }

            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= w; j++) {
                    if (marked[i][j] == false && map[i][j] == 1) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void dfs(int i, int j) {
        if (marked[i][j] == false && map[i][j] == 1) {
            marked[i][j] = true;

            for (int k = 0; k < dx.length; k++) {
                dfs(i + dx[k], j + dy[k]);
            }
        } else {
            return;
        }
    }
}
