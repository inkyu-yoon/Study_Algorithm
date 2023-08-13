package 바킹독.이분탐색.랜선자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main2 {
    int K;
    int N;
    List<Long> list = new ArrayList<>();
    long left = 0;
    long right;
    public static void main(String[] args) throws IOException {
        new Main2().sol();
    }

    private void sol() throws IOException {
        setUp();
        while (left < right) {
            long mid = (left + right) / 2;
            if (getNum(mid) < N) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left-1);
    }

    private int getNum(long mid) {
        int cnt = 0;
        for (Long len : list) {
            cnt += len / mid;
        }
        return cnt;
    }

    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        K = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        for (int i = 0; i < K; i++) {
            long l = Long.parseLong(br.readLine());
            list.add(l);
            right = Math.max(right, l);
        }

        right++;
    }
}
