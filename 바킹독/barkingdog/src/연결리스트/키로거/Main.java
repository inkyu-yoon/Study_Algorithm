package 연결리스트.키로거;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    // 사용자가 키보드를 누른 명령을 모두 기록한다.
    // 강산이는 알파벳 대문자, 소문자, 숫자, 백스페이스, 화살표를 기록한다.
    // 백스페이스 입력 시, - 커서 앞에 글자가 존재할 시 지운다.
    // 화살표 입력은 < 혹은 > , 움직일 수 있는 경우 움직임

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        while (N-- > 0) {
        StringBuilder sbFront = new StringBuilder();
        StringBuilder sbBack = new StringBuilder();
            Stack<String> front = new Stack<>();
            Stack<String> back = new Stack<>();
            String[] input = br.readLine().split("");
            for (String key : input) {
                if (key.equals("<")) {
                    if (!front.isEmpty()) {
                        back.push(front.pop());
                    }
                } else if (key.equals(">")) {
                    if (!back.isEmpty()) {
                        front.push(back.pop());
                    }
                } else if (key.equals("-")) {
                    if (!front.isEmpty()) {
                        front.pop();
                    }
                } else {
                    front.push(key);
                }
            }

            front.stream().forEach(string -> sbFront.append(string));
            back.stream().forEach(string -> sbBack.append(string));
            System.out.println(sbFront.toString() + sbBack.reverse());

        }

    }
}
