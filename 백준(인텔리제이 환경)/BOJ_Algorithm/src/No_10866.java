import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_10866 {
    static int first = 10000;
    static int last = 10000;
    static int[] array = new int[20002];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("push_back")) {
                push_back(Integer.valueOf(input[1]));
            } else if (input[0].equals("push_front")) {
                push_front(Integer.valueOf(input[1]));
            } else if (input[0].equals("pop_back")) {
                pop_back();
            } else if (input[0].equals("pop_front")) {
                pop_front();
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

    static void push_front(int X) {//push_front X: 정수 X를 덱의 앞에 넣는다.
        array[--first] = X;
    }

    static void push_back(int X) {//push_back X: 정수 X를 덱의 뒤에 넣는다.
        array[last++] = X;
    }

    static void pop_front() {//pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        if (last - first == 0) {
            System.out.println(-1);
        } else {
            System.out.println(array[first++]);
        }
    }

    static void pop_back() {//pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        if (last - first == 0) {
            System.out.println(-1);
        } else {
            System.out.println(array[--last]);
        }
    }

    static void size() {//size: 덱에 들어있는 정수의 개수를 출력한다.
        System.out.println(last - first);
    }

    static void empty() {//empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
        if (last - first == 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static void front() {//front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        if (last - first == 0) {
            System.out.println(-1);
        } else {
            System.out.println(array[first]);
        }
    }

    static void back() { //back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        if (last - first == 0) {
            System.out.println(-1);
        } else {
            System.out.println(array[last - 1]);
        }
    }
}







