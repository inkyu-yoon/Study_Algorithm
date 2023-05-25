package 판교가는길.구간합.개똥벌레;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    // 석순으로 시작, 종유석 -> 석순 번갈아 나옴
    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int N = info[0], H = info[1];
        int[] top = new int[H];
        int[] bot = new int[H];
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                bot[height-1]++;
            } else {
                top[H-height]++;
            }
        }
        for (int i = H-1; i >0; i--) {
            bot[i-1]+=bot[i];
        }
        for (int i = 1; i <H; i++) {
            top[i]+=top[i-1];
        }

        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 0; i < H; i++) {
            int sum = bot[i] + top[i];
            if (sum < min) {
                min = sum;
                cnt = 1;
            } else if (sum == min) {
                cnt++;
            }
        }
        System.out.println(min+" "+cnt);

    }
}
