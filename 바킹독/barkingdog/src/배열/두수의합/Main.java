package 배열.두수의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

// n개의 서로 다른 양의 정수 a1 a2 a3 a4 a5 ...an  1 이상 1000000(백만) 이하
// x가 주어졌을 때, ai + aj = x 를 만족하는 (i,j) 쌍의 수 [i<j]
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(string -> Integer.valueOf(string)).toArray();
        int x = Integer.valueOf(br.readLine());

        boolean[] check = new boolean[2000001];

        Arrays.stream(arr).forEach(integer -> check[integer] = true);

        int count = 0;

        for (int element : arr) {
            if (x - element > 0 && check[x - element]) {
                count++;
            }
        }
        System.out.println(count / 2);
    }
}
/*
9
5 12 7 10 9 1 2 3 11
13

3
 */