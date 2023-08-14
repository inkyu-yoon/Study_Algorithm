package 바킹독.이분탐색.멀티버스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    int M;
    int N;
    int[][] spaces;
    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        setUp();

        // 각 우주를 좌표 압축을 한다.
        for (int[] space : spaces) {
            compress(space);
        }

        System.out.println(getCnt());

    }

    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        spaces = new int[M][N];
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                spaces[i][j] = Integer.parseInt(input[j]);
            }
        }
    }



    private void compress(int[] space) {
        int[] cloned = space.clone();
        // 이분 탐색을 위한 중복 제거와 정렬 작업
        int[] arr = Arrays.stream(cloned).sorted().distinct().toArray();

        for (int i = 0; i < N; i++) {
            // Java 에서 제공하는 이분탐색 메서드를 사용해도 된다.
//            space[i] = Arrays.binarySearch(arr, space[i]);
            space[i] = bs(arr, space[i]);
        }

    }

    private int bs(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target <= arr[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    private int getCnt() {
        int cnt = 0;
        for (int i = 0; i < M-1; i++) {
            for (int j = i+1; j < M; j++) {
                if (Arrays.equals(spaces[i], spaces[j])) {
                    cnt++;
                }
            }
        }
        return cnt;
    }


}
