package 배열.숫자의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//세 개의 자연수 A, B, C가 주어질 때 A × B × C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지를 구하는 프로그램을 작성하시오.
//
//예를 들어 A = 150, B = 266, C = 427 이라면 A × B × C = 150 × 266 × 427 = 17037300 이 되고, 계산한 결과 17037300 에는 0이 3번, 1이 1번, 3이 2번, 7이 2번 쓰였다.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.valueOf(br.readLine());
        int B = Integer.valueOf(br.readLine());
        int C = Integer.valueOf(br.readLine());

        int[] arr = new int[10];
        String [] calculated = (String.valueOf(A * B * C)).split("");
        for (String s : calculated) {
            arr[Integer.valueOf(s)]++;
        }
        for (int element : arr) {
            System.out.println(element);

        }
    }
}
/*
150
266
427

3
1
0
2
0
0
0
2
0
0
 */