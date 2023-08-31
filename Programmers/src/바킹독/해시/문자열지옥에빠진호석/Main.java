package 바킹독.해시.문자열지옥에빠진호석;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int K;
    static String[][] map;

    static int[] dr = {1, 1, 1, 0, 0, -1, -1, -1};
    static int[] dc = {1, 0, -1, 1, -1, -1, 0, 1};
    static HashMap<String, Integer> hashMap = new HashMap<>();
    static Stack<String> s = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        setUp(br);
        getCntOfCombination();
        getAnswer(br);


    }

    private static void setUp(BufferedReader br) throws IOException {
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        N = input[0];
        M = input[1];
        K = input[2];

        map = new String[N][M];

        for (int r = 0; r < N; r++) {
            String[] info = br.readLine().split("");
            for (int c = 0; c < M; c++) {
                map[r][c] = info[c];
            }
        }
    }

    private static void getCntOfCombination() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                for (int length = 1; length <= 5; length++) {
                    s.push(map[r][c]);
                    bt(r, c, length);
                    s.clear();
                }
            }
        }
    }

    private static void bt(int r, int c, int length) {
        if (s.size() == length) {
            String result = convertStackToString();
            hashMap.put(result, hashMap.getOrDefault(result, 0) + 1);
            return;
        }

        for (int i = 0; i < 8; i++) {
            int nr = (dr[i] + r + N) % N, nc = (dc[i] + c + M) % M;
            s.push(map[nr][nc]);
            bt(nr, nc, length);
            s.pop();
        }
    }

    private static String convertStackToString() {
        StringBuilder sb = new StringBuilder();
        for (String str : s) {
            sb.append(str);
        }
        return sb.toString();
    }

    private static void getAnswer(BufferedReader br) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            sb.append(hashMap.getOrDefault(br.readLine(), 0) + "\n");
        }
        System.out.println(sb);
    }


}
