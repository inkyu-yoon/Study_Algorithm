package 기초수학;

import java.io.*;

public class No_1373 {
    public static void main(String[] args) throws IOException {
        //2진수가 주어졌을 때, 8진수로 변환하는 프로그램을 작성하시오.
        //11001100 -> 314
        //2진수에서 3개씩 끊어서 해석하면 됨
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String N = br.readLine();


        if(N.length() % 3 == 1)
            sb.append(N.charAt(0));

        if(N.length() % 3 == 2)
            sb.append((N.charAt(0) - '0') * 2 + (N.charAt(1) - '0'));


        for(int i = N.length() % 3; i < N.length(); i+=3) {
            sb.append((N.charAt(i) - '0') * 4 + (N.charAt(i+1) - '0') * 2 + (N.charAt(i+2) - '0'));
        }

        System.out.println(sb);


    }
}
