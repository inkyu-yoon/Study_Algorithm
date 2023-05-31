package 판교가는길.dp.가장긴증가하는부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        List<Integer> list = new LinkedList<>();
        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > list.get(list.size() - 1)) {
                list.add(arr[i]);
            } else {
                int idx = bs(list, arr[i]);
                list.set(idx, arr[i]);
            }
        }
        System.out.println(list.size());

    }

    int bs(List<Integer> list, int num) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (num <= list.get(mid)) {
                right = mid ;
            } else {
                left = mid +1;
            }
        }
        return left;
    }
}
