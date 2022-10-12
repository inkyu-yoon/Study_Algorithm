package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_10845 {
    static int first = 0;
    static int last = 0;
    static int[] array = new int[10001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("push")) {
                push(Integer.valueOf(input[1]));
            } else if (input[0].equals("pop")) {
                pop();
            } else if (input[0].equals("size")) {
                size();
            } else if (input[0].equals("empty")) {
                empty();
            } else if (input[0].equals("front")) {
                front();
            } else if (input[0].equals("back")) {
                back();
            }

        }
    }

    static void push(int X) {//push X: 정수 X를 큐에 넣는 연산이다.
        array[last++] = X;
    }

    static void pop() {//pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        if (last - first == 0) {
            System.out.println(-1);
        } else {
            System.out.println(array[first++]);
        }
    }

    static void size() {//size: 큐에 들어있는 정수의 개수를 출력한다.
        System.out.println(last - first);
    }

    static void empty() {//empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
        if (last - first == 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static void front() {//front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        if (last - first == 0) {
            System.out.println(-1);
        } else {
            System.out.println(array[first]);
        }
    }

    static void back() { //back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        if (last - first == 0) {
            System.out.println(-1);
        } else {
            System.out.println(array[last - 1]);
        }
    }
}
