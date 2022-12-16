package 연결리스트.에디터;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    // 영어 소문자 만을 기록할 수 있는 편집기, 최대 600000글자까지 입력할 수 있다.
    // L : 커서를 왼쪽으로 한칸 옮긴다. ( 커서가 문장의 맨 앞이면 무시된다.)
    // D : 커서를 오른쪽으로 한칸 옮긴다. ( 커서가 문장 맨 뒤면 무시된다.)
    // B : 커서 왼쪽에 있는 문자를 삭제한다.(문장 맨 앞이면 무시된다.
    // P : 문자를 커서 왼쪽에 추가
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sbFront = new StringBuilder();
        StringBuilder sbBack = new StringBuilder();
        String initial = br.readLine();
        int n = Integer.valueOf(br.readLine());
        Stack<String> front = new Stack<>();
        Stack<String> back = new Stack<>();

        Arrays.stream(initial.split("")).forEach(string->front.push(string));


        while (n-- > 0) {
            String [] command = br.readLine().split(" ");
            if(command[0].equals("P")){
                front.push(command[1]);
            } else if (command[0].equals("L")) {
                if(!front.isEmpty())
                back.push(front.pop());
            }else if (command[0].equals("D")) {
                if(!back.isEmpty())
                    front.push(back.pop());
            }else if (command[0].equals("B")) {
                if(!front.isEmpty())
                    front.pop();
            }
        }
            front.stream().forEach(string -> sbFront.append(string));
            back.stream().forEach(string -> sbBack.append(string));
            System.out.println(sbFront.toString()+sbBack.reverse());


    }
}
/*
abcd
3
P x
L
P y

abcdyx
 */