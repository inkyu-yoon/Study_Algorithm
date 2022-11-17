package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No_2146 {
    static int N, min = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int land = 1;
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0)
                    continue;
                if (visited[i][j])
                    continue;

                dfs(i, j, land);
                land++;
            }
        }
        //visited 초기화
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0)
                    continue;
                if (visited[i][j])
                    continue;

                bfs(i, j, map[i][j]);
            }
        }

        System.out.println(min);
    }


    static void dfs(int x, int y, int land) {
        if (visited[x][y] == false && map[x][y] == 1) {
            visited[x][y] = true;
            map[x][y] = land;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (((0 <= nx && nx < N) && (0 <= ny && ny < N)) && visited[nx][ny] == false && map[nx][ny] == 1) {
                    dfs(nx, ny, land);
                }
            }
        }
    }

    static void bfs(int x, int y, int land) {
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{x, y, 0});
        boolean[][] ocean = new boolean[N][N];
        ocean[x][y] = true;

        while (!q.isEmpty()) {
            int[] point = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = point[0] + dx[k];
                int ny = point[1] + dy[k];

                //맵 범위를 벗어나는 경우,
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }
                //같은 섬일 경우, 방문 표시만 하고 넘어간다.
                if (map[nx][ny] == land) {
                    visited[nx][ny] = true;
                    continue;
                }
                //방문했던 바다인 경우 넘어간다.
                if (ocean[nx][ny] == true) {
                    continue;
                }

                // 포인트가 0이고, 방문하지 않은 바다라면?
                if (map[nx][ny] == 0) {
                    //큐에 추가해준 뒤, 다리 길이를 1칸 늘린다.
                    // 바다 방문 표시를 남긴다.
                    q.offer(new int[]{nx, ny, point[2] + 1});
                    ocean[nx][ny] = true;

                    //다른 섬에 도착했을 때
                } else if (map[nx][ny] != land) {
                    //다리 길이를 늘리지 않고, 최솟값을 확인한다.
                    min = Math.min(min, point[2]);
                    return;
                }
            }
        }

    }
}


/*
10
1 1 1 0 0 0 0 1 1 1
1 1 1 1 0 0 0 0 1 1
1 0 1 1 0 0 0 0 1 1
0 0 1 1 1 0 0 0 0 1
0 0 0 1 0 0 0 0 0 1
0 0 0 0 0 0 0 0 0 1
0 0 0 0 0 0 0 0 0 0
0 0 0 0 1 1 0 0 0 0
0 0 0 0 1 1 1 0 0 0
0 0 0 0 0 0 0 0 0 0
 */