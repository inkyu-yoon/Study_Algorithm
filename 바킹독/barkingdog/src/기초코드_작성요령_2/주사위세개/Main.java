package 기초코드_작성요령_2.주사위세개;

import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a = Integer.valueOf(input[0]);
        int b = Integer.valueOf(input[1]);
        int c = Integer.valueOf(input[2]);

        if(a==b && b==c){
            System.out.println(10000 + a * 1000);
        } else if ((a == b && b != c) || (a == c && b != c) ) {
            System.out.println(1000+a*100);
        } else if ((c == b && a != c)) {
            System.out.println(1000 + b * 100);
        } else {
            System.out.println(Math.max(Math.max(a, b), c) * 100);
        }
    }
}
