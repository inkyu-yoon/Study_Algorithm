package BFS.적록색약;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    // 적록색약인 사람은 빨(R) 과 초(G)의 차이를 거의 느끼지 못한다.
    // 적록색약인 사람은 빨간색과 초록색이 붙어있으면 같은 구역으로 생각한다.
    // 일반인이 보는 구역의 수, 적록색약인 사람이 보는 구역의 수
    static String[][] map;
    static int[][] check;
    static int N;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());

        map = new String[N][N];
        check = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] info = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = info[j];
            }
        }
        boolean isNormal = true;
        System.out.print(run(isNormal)+" ");
        System.out.print(run(!isNormal));

    }

    static int run(boolean isNormal) {
        check = new int[N][N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (check[i][j] == 0) {
                    q.offer(new int[]{i, j});
                    check[i][j] = 1;
                    bfs(map[i][j],isNormal);
                    count++;
                }
            }
        }
        return count;
    }

    private static void bfs(String s, boolean isNormal) {
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int r = point[0];
            int c = point[1];
            for (int i = 0; i <= 3; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                //정상인의 경우 일반 bfs 진행
                if (isNormal) {
                    if ((0 <= nr && nr < N) && (0 <= nc && nc < N) && map[nr][nc].equals(s) && check[nr][nc] == 0) {
                        q.offer(new int[]{nr, nc});
                        check[nr][nc] = 1;
                    }
                    //적록색약인 경우, G, R 은 같은 블럭으로 취급해서 bfs 진행
                } else {
                    if ((0 <= nr && nr < N) && (0 <= nc && nc < N) && check[nr][nc] == 0) {
                        if (s.equals("G") || s.equals("R")) {
                            if (map[nr][nc].equals("G") || map[nr][nc].equals("R")) {
                                q.offer(new int[]{nr, nc});
                                check[nr][nc] = 1;
                            }
                        } else if(map[nr][nc].equals(s)){
                            q.offer(new int[]{nr, nc});
                            check[nr][nc] = 1;
                        }

                    }
                }

            }
        }
    }
}
/*
5
RRRBB
GGBBB
BBBRR
BBRRR
RRRRR

4 3
 */