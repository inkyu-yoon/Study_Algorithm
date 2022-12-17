package 스택.스택;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    // 정수를 저장하는 스택 구현
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        Stack<Integer> stack = new Stack<>();
        while (N-- > 0) {
            String[] command = br.readLine().split(" ");
            if (command[0].equals("push")) {
                stack.push(Integer.valueOf(command[1]));
            } else if (command[0].equals("pop")) {
                System.out.println(stack.isEmpty()?-1:stack.pop());
            }else if (command[0].equals("size")) {
                System.out.println(stack.size());
            }else if (command[0].equals("empty")) {
                System.out.println(stack.isEmpty()?1:0);
            }else if (command[0].equals("top")) {
                System.out.println(stack.isEmpty()?-1:stack.peek());
            }
        }

    }
}
