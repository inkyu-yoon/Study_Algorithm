package 스택의활용.좋은단어;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    // 좋은 단어 찾기
    // A와 B를 아치형 곡선을 그어 쌍을 지을 때, 선끼리 교차하지 않으면서 짝을 지을 수 있다면 좋은 단어
    // ABA 이나 BAB  일때 성립하지 않음
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        int count = 0;
        while (N-- > 0) {
            String[] input = br.readLine().split("");
            Stack<String> stack = new Stack<>();

            for (int i = 0; i < input.length; i++) {
                if (input[i].equals("A")) {
                    if (stack.size() == 0) {
                        stack.push("A");
                    }else{
                        if (stack.peek().equals("A")) {
                            stack.pop();
                        } else {
                            stack.push("A");
                        }
                    }

                } else if(input[i].equals("B")){
                    if (stack.size() == 0) {
                        stack.push("B");
                    }else{
                        if (stack.peek().equals("B")) {
                            stack.pop();
                        } else {
                            stack.push("B");
                        }
                    }
                }
            }
            if (stack.size() == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}