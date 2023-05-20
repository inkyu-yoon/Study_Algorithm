package 판교가는길.bfs.아기상어;
import java.io.*;
import java.util.*;


public class Main {
    int N;
    int[][] map;
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    int[] shark;
    int size = 2;
    int eat = 0;
    Queue<int[]> q;
    boolean checked[][];
    int ans = 0;
    PriorityQueue<int[]> fishes = new PriorityQueue<>((a, b) -> {
        int distance = a[2] - b[2];
        if (distance == 0) {
            int row = a[0] - b[0];
            if (row == 0) {
                return a[1] - b[1];
            } else {
                return row;
            }
        } else {
            return distance;
        }
    });

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        q = new LinkedList<>();
        for (int r = 0; r < N; r++) {
            String[] input = br.readLine().split(" ");
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(input[c]);
                if (map[r][c] == 9) {
                    shark = new int[]{r, c, 0};
                }
            }
        }
    }

    // 최초 상어의 크기는 2
    // 자신보다 작은 크기 물고기만 먹을 수 있고, 크기가 같은 물고기는 이동만 가능
    // 먹을 수 있는 물고기가 없으면 끝
    // 거리가 가장 가까운 물고기를 먹으러 가고, 거리가 같은 물고기가 여러마리면, 가장 위에 있는 물고기 -> 가장 왼쪽에 있는 물고기
    // 자신의 크기만큼 먹어야 크기가 1 증가함
    void solution() throws IOException {
        setUp();
        while (true) {
            fishes.clear();
            checked = new boolean[N][N];
            q.offer(shark);
            getFishes();
            if (fishes.isEmpty()) {
                break;
            } else {
                eatFish();
            }
        }

        System.out.println(ans);
    }

    void eatFish() {
        int[] fish = fishes.peek();
        ans += fish[2];
        map[shark[0]][shark[1]] = 0;
        map[fish[0]][fish[1]] = 9;
        eat++;
        if (size == eat && size <= 6) {
            size++;
            eat = 0;
        }
        shark = new int[]{fish[0], fish[1], 0};
    }

    void getFishes() {
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int r = p[0], c = p[1];
            int d = p[2];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (0 <= nr && nr < N && 0 <= nc && nc < N && !checked[nr][nc] && map[nr][nc] <= size) {
                    if (map[nr][nc] != 0 && map[nr][nc] < size) {
                        fishes.offer(new int[]{nr, nc, d + 1});
                    }
                    q.offer(new int[]{nr, nc, d + 1});
                    checked[nr][nc] = true;
                }
            }
        }
    }
}
