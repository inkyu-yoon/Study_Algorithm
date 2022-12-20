package 스택의활용.균형잡힌세상;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    // 어떤 문자열이 주어졌을 떄, 괄호가 짝을 이루는지 확인
    // () 또는 []
    // ( [ ) ] 이런 경우는 균형 잡혀있다고 성립하지 않음
    // ( ( [ [ ) ]
    //입력의 종료 조건으로는 맨 마지막에 . 만 입력되고, 각 줄은 마침표(.)로 끝남
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            //종료 조건
            if (input.equals(".")) {
                break;
            }
            Stack<Character> stack = new Stack<>();
            boolean isBalance = true;
            for (int i = 0; i < input.length()-1; i++) {
                if (input.charAt(i) == '(' || input.charAt(i) == '[') {
                    stack.push(input.charAt(i));
                } else if (input.charAt(i) == ')'){

                    if (stack.size() == 0) {
                        isBalance = false;
                        break;
                    }
                    if (stack.peek() == '[') {
                        isBalance = false;
                        break;
                    }
                    stack.pop();

                }else if (input.charAt(i) == ']'){

                    if (stack.size() == 0) {
                        isBalance = false;
                        break;
                    }
                    if (stack.peek() == '(') {
                        isBalance = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (!isBalance) {
                sb.append("no\n");
            } else {
                if (stack.size() != 0) {
                    sb.append("no\n");
                } else {
                    sb.append("yes\n");
                }
            }
        }
            System.out.println(sb);

    }
}
