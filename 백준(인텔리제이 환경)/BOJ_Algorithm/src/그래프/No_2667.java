package 그래프;
/* 예제 입력
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000

 */
/* 예제 출력
3 : 총 단지 수
7 : 1단지
8 : 2단지
9 : 3단지
 */


import java.io.*;
import java.util.*;

public class No_2667 {
    static int[][] map ;
    static boolean[][] marked;
    static int count;
    static Map<Integer, Integer> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.valueOf(br.readLine());
        ArrayList<Integer> counts = new ArrayList<>();
        map = new int[N+2][N+2];
        marked = new boolean[N + 2][N + 2];
        result = new HashMap<>();
        int index = 0;
        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            for (int j = 1; j <= N; j++) {
                map[i][j] = input.charAt(j-1) - '0';
            }
        }
//        System.out.println(Arrays.deepToString(map));
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] != 0 && marked[i][j] == false) {
                    count = 0;
                    index++;
                    dfs(i, j);
                    counts.add(count);
                }
            }
        }
        Collections.sort(counts);
        System.out.println(index);
        for (Integer i : counts) {
            System.out.println(i);
        }
    }

    static void dfs(int i, int j) {
        //방문 안했고, 0이 아닌 경우
        if (marked[i][j] == false && map[i][j] != 0) {
            marked[i][j] = true;

            //오른쪽
            dfs(i + 1, j);
            //아래쪽
            dfs(i, j + 1);
            //왼쪽
            dfs(i - 1, j);
            //위쪽
            dfs(i, j - 1);
            count++;
        } else {
            return;
        }
    }
}
