package 바킹독.이분탐색.좌표압축;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main2 {
    int N;
    int[] arr;
    int[] filtered;
    public static void main(String[] args) throws IOException {
        new Main2().sol();
    }

    private void sol() throws IOException {
        setUp();

        StringBuilder sb = new StringBuilder();

        for (int target : arr) {
            sb.append(bs(target)+" ");
        }

        System.out.println(sb);
    }

    private int bs(int num) {
        int left = 0;
        int right = filtered.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (num <= filtered[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];


        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        filtered = Arrays.stream(arr).sorted().distinct().toArray();

    }
}
