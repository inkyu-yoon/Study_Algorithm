package 자료구조;

import java.io.*;
import java.util.Stack;

public class No_1406 {
    public static void main(String[] args) throws IOException {
        //L 커서를 왼쪽으로 한 칸 옮김, 커서가 문장의 맨 앞이면 무시
        //D 커서를 오른쪽으로 한 칸 옮김, 커서가 문장의 맨 뒤이면 무시
        //B 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
        //삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
        //P $ $ 문자를 커서 왼쪽에 추가

        Stack<Character> lstack = new Stack<>();
        Stack<Character> rstack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String initialInput = br.readLine();
        for (int i = 0; i < initialInput.length(); i++) {
            lstack.push(initialInput.charAt(i));
        }
        int N = Integer.valueOf(br.readLine());
        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("L")) {
                if (!lstack.isEmpty())
                    rstack.push(lstack.pop());
            } else if (input[0].equals("D")) {
                if (!rstack.isEmpty()) {
                    lstack.push(rstack.pop());
                }
            } else if (input[0].equals("B")) {
                if (!lstack.isEmpty()) {
                    lstack.pop();
                }
            } else if (input[0].equals("P")) {
                lstack.push(input[1].charAt(0));
            }
        }

        while (!lstack.isEmpty()) {
            rstack.push(lstack.pop());
        }
        while (!rstack.isEmpty()) {
            bw.write(rstack.pop());
        }
        bw.flush();
        bw.close();
    }
}
