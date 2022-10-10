import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_10828 {
    static int index = -1;
    static int[] arr = new int[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("push")) {
                push(Integer.valueOf(input[1]));
            } else if (input[0].equals("top")) {
                top();
            } else if (input[0].equals("size")) {
                size();
            } else if (input[0].equals("empty")) {
                empty();
            } else if (input[0].equals("pop")) {
                pop();
            }
        }

    }

    //push 1 정수 x를 스택에 넣는 연산

    static void push(int input) {
        arr[++index] = input;
    }

    static void pop() {
        if (index == -1) {
            System.out.println(-1);
        } else {
            System.out.println(arr[index--]);
        }
    }

    static void size() {
        System.out.println(index + 1);
    }

    static void empty() {
        if (index == -1) {
            System.out.println(1);
        } else {
            System.out.println(0);

        }
    }

    static void top() {
        if (index == -1) {
            System.out.println(-1);
        } else {
            System.out.println(arr[index]);

        }
    }

}
