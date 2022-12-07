package 기초코드_작성요령_2.A더하기B;

import java.io.*;
public class Main {
    // A 와 B를 입력받은 다음 A+B를 출력하는 프로그램
    /*
    1 2

    3
     */
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");

        System.out.print(Integer.valueOf(input[0])+Integer.valueOf(input[1]));


    }
}
