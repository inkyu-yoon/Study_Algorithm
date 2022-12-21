package 스택의활용.쇠막대기;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    // () 가 형성되면 레이저가 발생 ()를 제외한 괄호는 쇠막대기를 의미한다.
    // 분리되는 쇠막대기의 갯수 세기
    // ()(((()())(())()))(())
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");
        Stack<String> s = new Stack<>();

        //() 가 형성되어 레이저가 발사되는 순간 "(" 가 쌓여있는 만큼 조각이 추가된다.
        //쇠막대기가 끝나면, 조각 1개 추가
        int count = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("(")) {
                s.push(input[i]);
            } else {
                if (input[i - 1].equals(")")) {
                    s.pop();
                    count++;

                    //레이저 발사
                } else {
                    s.pop();
                    count += s.size();
                }
            }
        }
        System.out.println(count);
    }
    /*
    ()(((()())(())()))(())

    17

    (((()(()()))(())()))(()())

    24
     */
}
