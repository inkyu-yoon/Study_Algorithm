package 기초코드_작성요령_2.카드역배치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 1 부터 20까지 숫자가 하나씩 쓰인 20장의 카드가 오름차순으로 놓여있다.
public class Main {
    static int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int time = 1; time <= 10; time++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.valueOf(input[0]);
            int b = Integer.valueOf(input[1]);
            shuffle(a, b);
        }
        for(int element : arr){
            System.out.print(element + " ");
        }
    }

    static void shuffle(int a, int b) {
        int[] newArr = arr.clone();
        for (int i = a - 1, j = b - 1; i <= b - 1; i++, j--) {
            arr[i] = newArr[j];
        }
    }
}
