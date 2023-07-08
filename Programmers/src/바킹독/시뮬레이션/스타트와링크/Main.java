package 바킹독.시뮬레이션.스타트와링크;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    int N;
    int[][] map;
    int ans = Integer.MAX_VALUE;
    Stack<Integer> s;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int r = 0; r < N; r++) {
            String[] info = br.readLine().split(" ");
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(info[c]);
            }
        }
        s = new Stack<>();
        bt();
        System.out.println(ans);
    }

    void bt() {
        if (s.size() == N / 2) {
            ans = Math.min(ans, getDiff());
            return;
        }
        for (int i = 0; i < N; i++) {
            if (s.contains(i) || (!s.isEmpty() && s.peek() > i)) {
                continue;
            }
            s.push(i);
            bt();
            s.pop();
        }
    }

    int getDiff() {
        int[] teamA = s.stream().mapToInt(Integer::valueOf).toArray();
        int[] teamB = new int[N / 2];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (!s.contains(i)) {
                teamB[idx++] = i;
            }
        }
        return Math.abs(getPoint(teamA) - getPoint(teamB));
    }

    int getPoint(int[] team) {
        int result = 0;
        for (int i = 0; i < team.length - 1; i++) {
            for (int j = i + 1; j < team.length; j++) {
                result += map[team[i]][team[j]] + map[team[j]][team[i]];
            }
        }
        return result;
    }
}
