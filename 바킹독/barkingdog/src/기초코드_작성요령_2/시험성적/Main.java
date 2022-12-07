package 기초코드_작성요령_2.시험성적;

import java.io.*;
public class Main {
    /*
    90 A
    80 B
    70 C
    60 D
    F
     */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int score = Integer.valueOf(br.readLine());
        if(score>=90){
            System.out.print("A");
        }else if(score>=80){
            System.out.print("B");
        }else if(score>=70){
            System.out.print("C");
        }else if(score>=60){
            System.out.print("D");
        }else{
            System.out.print("F");
        }

    }
}
