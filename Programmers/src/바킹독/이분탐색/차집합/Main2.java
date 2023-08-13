package 바킹독.이분탐색.차집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main2 {
    int nA;
    int nB;
    int[] arrA;
    int[] arrB;

    public static void main(String[] args) throws IOException {
        new Main2().sol();
    }

    private void sol() throws IOException {
        setUp();
        Arrays.sort(arrA);
        Arrays.sort(arrB);

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i : arrA) {
            if (!bs(i)) {
                cnt++;
                sb.append(i + " ");
            }
        }

        System.out.println(cnt);
        System.out.println(sb);
    }

    private boolean bs(int i) {
        int left = 0, right = arrB.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (i <= arrB[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (0 <= left && left < arrB.length) {
            if (i == arrB[left]) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        nA = Integer.parseInt(input[0]);
        nB = Integer.parseInt(input[1]);

        arrA = getArr(br);
        arrB = getArr(br);
    }

    private int[] getArr(BufferedReader br) throws IOException {
        String[] input = br.readLine().split(" ");
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = Integer.parseInt(input[i]);
        }
        return result;
    }
}
