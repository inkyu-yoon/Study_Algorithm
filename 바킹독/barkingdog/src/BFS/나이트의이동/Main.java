package BFS.나이트의이동;
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    // 나이트가 해당 칸에 이동할 수 있는 최소 이동 수
    static int[][] map;
    static int[][] num;
    static int size;
    static int[] dr = {1,1,2,2,-1,-1,-2,-2};
    static int[] dc = {2,-2,1,-1,-2,2,1,-1};
    static Queue<int[]> q = new LinkedList<>();
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int T = Integer.valueOf(br.readLine());

        while (T-- > 0) {
            size = Integer.valueOf(br.readLine());
            map = new int[size][size];
            num = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    num[i][j]=Integer.MAX_VALUE;
                }
            }
            int [] now = Arrays.stream(br.readLine().split(" ")).mapToInt(s->Integer.valueOf(s)).toArray();
            int [] goal = Arrays.stream(br.readLine().split(" ")).mapToInt(s->Integer.valueOf(s)).toArray();

            if (now[0] == goal[0] && now[1] == goal[1]) {
                sb.append("0\n");
                continue;
            }

            num[now[0]][now[1]] = 0;
            map[now[0]][now[1]] = 1;
            map[goal[0]][goal[1]] = 2;

            q.offer(new int[]{now[0], now[1]});
            bfs();

        }
        System.out.println(sb);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int [] point = q.poll();
            int r = point[0];
            int c = point[1];

            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if((0<=nr&&nr<size)&&(0<=nc&&nc<size)){
                    if (num[nr][nc] > num[r][c] + 1) {
                        num[nr][nc] = num[r][c]+1;
                        q.offer(new int[]{nr, nc});
                        if (map[nr][nc] == 2) {
//                            System.out.printf("nr : %d nc : %d ", nr, nc);
//                            System.out.println();
                            sb.append(num[nr][nc]+"\n");

                            break;
                        }
                    }
                }
            }
        }
    }
}
/*
3
8
0 0
7 0
100
0 0
30 50
10
1 1
1 1

5
28
0
 */