package 바킹독.이분탐색.합이0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    int N;
    int[] arr;

    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        setUp();
        Arrays.sort(arr);
        long cnt = 0;
        for (int i = 0; i < N; i++) {
            int fixed = arr[i];

            int left = i + 1, right = N - 1;
            while (left < right) {
                int sum = fixed + arr[left] + arr[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    if (arr[left] == arr[right]) {
                        cnt += getNumOfComb(right - left + 1);
                        break;
                    } else {
                        int tmpOfLeft = left;
                        int tmpOfRight = right;

                        while (arr[left] == arr[left + 1]) {
                            left++;
                        }

                        while (arr[right] == arr[right - 1]) {
                            right--;
                        }

                        cnt += (left - tmpOfLeft + 1) * (tmpOfRight - right + 1);
                        left++;
                        right--;
                    }
                }
            }
        }
        System.out.println(cnt);
    }


    private int getNumOfComb(Integer cnt) {
        return cnt * (cnt - 1) / 2;
    }


    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
    }
}
