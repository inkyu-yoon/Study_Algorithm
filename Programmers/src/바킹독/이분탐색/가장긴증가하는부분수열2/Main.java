package 바킹독.이분탐색.가장긴증가하는부분수열2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    int N;
    int[] arr;
    List<Integer> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
            if (ans.size() == 0) {
                ans.add(arr[i]);
            } else {
                if (ans.get(ans.size() - 1) < arr[i]) {
                    ans.add(arr[i]);
                } else {
                    int idx = bs(arr[i]);
                    ans.set(idx, arr[i]);

                }
            }
        }
        System.out.println(ans.size());
    }

    private int bs(int target) {
        int left = 0, right = ans.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target <= ans.get(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
