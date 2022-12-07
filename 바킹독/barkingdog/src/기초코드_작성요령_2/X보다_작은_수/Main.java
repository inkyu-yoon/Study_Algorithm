package 기초코드_작성요령_2.X보다_작은_수;

import java.io.*;
public class Main {
    //정수 N개로 이루어진 수열 A와 정수 X가 주어진다. A에서 X보다 작은 수를 모두 출력하라
/* 예제
10 5
1 10 4 9 2 3 8 5 7 6
 */

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        int N = Integer.valueOf(input[0]);
        int X = Integer.valueOf(input[1]);

        StringBuilder sb = new StringBuilder();

        String [] input2 = br.readLine().split(" ");

        for(int i=0;i<N;i++){
            if(Integer.valueOf(input2[i])<X){
                sb.append(input2[i]+" ");
            }
        }

        System.out.print(sb);


    }
}
