package 배열.개수세기;

import java.io.*;
import java.util.*;
import java.util.stream.*;

//총 N개의 정수가 주어졌을 떄, 정수 v가 몇개인지 구하는 프로그램
// 1<=N<=100
// 정수 주어짐
// 찾으려는 정수 주어짐, 그리고 갯수 세기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String [] input = br.readLine().split(" ");
        String v = br.readLine();

        long count = Arrays.stream(input).filter(string -> string.equals(v)).count();
        System.out.println(count);



    }
}
