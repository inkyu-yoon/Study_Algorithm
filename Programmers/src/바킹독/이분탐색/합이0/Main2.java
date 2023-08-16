package 바킹독.이분탐색.합이0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main2 {
    int N;
    int [] arr;
    public static void main(String[] args) throws IOException {
        new Main2().sol();
    }

    private void sol() throws IOException {
        setUp();
        Arrays.sort(arr);
        long cnt = 0;

        for (int i = 0; i < N; i++) {
            int fixed = arr[i];
            int left = i+1;
            int right = N - 1;

            while (left < right) {
                int sum = fixed + arr[left] + arr[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    if (arr[left] == arr[right]) {
                        cnt += getCntOfComb(right - left + 1);
                        break;
                    } else {
                        int cntOfL = 1;
                        int cntOfR = 1;

                        while (arr[left] == arr[left + 1]) {
                            left++;
                            cntOfL++;
                        }

                        while (arr[right] == arr[right - 1]) {
                            right--;
                            cntOfR++;
                        }

                        cnt += cntOfL * cntOfR;
                        left++;
                        right--;
                    }
                }
            }
        }
            System.out.println(cnt);
    }

    private int getCntOfComb(int i) {
        return i*(i-1)/2;
    }

    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

    }
}
