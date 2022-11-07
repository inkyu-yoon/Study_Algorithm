package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

public class No_2331 {
    /* 예제 입력
57 2

4
     */

    //D[1] = A
    //D[n] = D[n-1]의 각 자리의 숫자를 P번 곱한 수들의 합
    static ArrayList<Integer> list = new ArrayList<>();
    static int P;
    static int breakPoint;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int A = Integer.valueOf(input[0]);
        P = Integer.valueOf(input[1]);
        dfs(A);
//        for (Integer integer : list) {
//            System.out.println(integer+" ");
//        }
//        System.out.println(breakPoint);
        System.out.println(list.indexOf(breakPoint));

    }

    static void dfs(int start) {
        if (!list.contains(start)) {
            list.add(start);
            dfs(getValue(start,P));
        } else {
            breakPoint = start;
            return ;
        }


    }

    static int getValue(int num,int P) {
        int result = 0;
        while (num > 0) {
            result += Math.pow(num % 10, P);
            num /= 10;
        }
        return result;
    }
}
