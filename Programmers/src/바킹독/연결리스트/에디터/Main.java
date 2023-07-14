package 바킹독.연결리스트.에디터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> L = new Stack<>();
        Stack<String> R = new Stack<>();

        Arrays.stream(br.readLine().split("")).forEach(s -> L.push(s));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            String cmd = input[0];
            switch (cmd) {
                case "L":
                    if (!L.isEmpty()) {
                        R.push(L.pop());
                    }
                    break;
                case "D":
                    if (!R.isEmpty()) {
                        L.push(R.pop());
                    }
                    break;
                case "B":
                    if (!L.isEmpty()) {
                        L.pop();
                    }
                    break;
                case "P":
                    L.push(input[1]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : L) {
            sb.append(s);
        }
        while (!R.isEmpty()) {
            sb.append(R.pop());
        }

        System.out.println(sb);
    }
}

