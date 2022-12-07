package 기초코드_작성요령_2.대표값2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int[] arr = new int[5];
        for (int i = 1; i <= 5; i++) {
            arr[i - 1] = Integer.valueOf(br.readLine());
            sum += arr[i - 1];
        }
        Arrays.sort(arr);
        System.out.println(sum / 5);
        System.out.println(arr[2]);
    }
}
