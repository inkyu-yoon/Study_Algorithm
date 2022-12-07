package 기초코드_작성요령_2.세수정렬;

import java.io.*;
import java.util.*;
public class Main {
    //숫자 3개가 주어지면 정렬하기ㅏ
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");

        int [] arr = new int [3];
        for(int i=0;i<=2;i++){
            arr[i] = Integer.valueOf(input[i]);
        }
        Arrays.sort(arr);
        for(int i=0;i<=2;i++){
            System.out.print(arr[i]+" ");
        }


    }
}
