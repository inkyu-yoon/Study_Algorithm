package 바킹독.이분탐색.공유기설치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Main {
    int N;
    int C;
    List<Integer> houses = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    private void sol() throws IOException {
        setUp();
        int left = 0, right = houses.get(N - 1);
        while (left < right) {
            int mid = (left + right) / 2;
            int num = checkNum(mid);
            if (num < C) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);

    }

    private int checkNum(int gap) {
        int start = houses.get(0);
        int num = 1;
        for (int i = 1; i < N; i++) {
            int point = houses.get(i);
            if (point > start + gap) {
                start = point;
                num++;
            }
        }
        return num;
    }

    private void setUp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        N = input[0];
        C = input[1];

        for (int i = 0; i < N; i++) {
            houses.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(houses);


    }
}
