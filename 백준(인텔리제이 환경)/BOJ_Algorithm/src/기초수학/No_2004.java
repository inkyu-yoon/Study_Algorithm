package 기초수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2004 {
    public static void main(String[] args) throws IOException {
        //N! 에서 뒤에서부터 처음 0이 아닌 숫자가 나올때까지 0의 갯수를 구하는 프로그램
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.valueOf(input[0]);
        int m = Integer.valueOf(input[1]);

        int two = getCount(n,2) - getCount(m,2) - getCount(n - m,2);
        int five = getCount(n,5) - getCount(m,5) - getCount(n - m,5);

        System.out.println(Math.min(two, five));
    }


    static int getCount(int n, int num) {

        int count = 0;

        while (n >= num) {
            count += n / num;
            n /= num;
        }

        return count;
    }


}
