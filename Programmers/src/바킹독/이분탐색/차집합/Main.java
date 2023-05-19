package 바킹독.이분탐색.차집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int numA = info[0];
        int numB = info[1];

        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        Arrays.sort(A);
        Arrays.sort(B);
        int count = 0;
        StringBuilder sb = new StringBuilder();
        //A에는 속하면서 B에는 속하지 않는 원소의 개수와 원소를 오름차순으로 출력
        for (int n : A) {
            if (!bs(B, n)) {
                count++;
                sb.append(n + " ");
            }
        }
        System.out.println(count);
        if (sb.length() != 0) {
            System.out.println(sb);
        }
    }

    boolean bs(int[] arr, int n) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (n < arr[mid]) {
                right = mid - 1;
            } else if (n > arr[mid]) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
