package 기초코드_작성요령_2.윤년;

import java.io.*;

public class Main {
    //윤년이면 1
    // 윤년은 연도가 4의 배수이면서 100의 배수가 아니거나  400의 배수일 때
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int year = Integer.valueOf(br.readLine());
        if ((year % 400 == 0) || (year % 100 != 0 && year % 4 == 0)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }


}
