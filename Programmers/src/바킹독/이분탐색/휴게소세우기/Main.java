package 바킹독.이분탐색.휴게소세우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    int N;
    int M;
    int L;
    int[] arr;

    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        setUp();

        int left = 1, right = L + 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int num = getNum(mid);
            if (num <= M) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }

    private int getNum(int gap) {
        int cnt = 0;
        for (int i = 0; i < arr.length-1; i++) {
            cnt+= (arr[i + 1] - arr[i] - 1) / gap;

        }
        return cnt;
    }

    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        L = Integer.parseInt(input[2]);

        input = br.readLine().split(" ");

        arr = new int[N + 2];
        arr[0] = 0;
        arr[N + 1] = L;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

    }
}
