package 자료구조.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 스택 2개로 큐 구현하기
public class Main {
    static Stack<Integer> sIn = new Stack<>();
    static Stack<Integer> sOut = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("데이터 입력 1 데이터 제거 2");

            int power = Integer.parseInt(br.readLine());

            switch (power) {
                case 1:
                    System.out.println("입력을 원하는 수를 입력하세요.");
                    int input = Integer.parseInt(br.readLine());
                    offer(input);
                    break;
                case 2:
                    System.out.println(pop());
                    break;
            }
        }
    }

    private static int pop() {
        if (sOut.isEmpty()) {
            while (!sIn.isEmpty()) {
                sOut.push(sIn.pop());
            }
        }

        if (sOut.isEmpty()) {
            return -1;
        }

        return sOut.pop();
    }

    private static void offer(int input) {
        sIn.push(input);
    }

}
