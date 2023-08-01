package 라이브코테;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static String input = "20-2*5*5";

    public static void main(String[] args) {
        int sol = new Main().sol(input);
        System.out.println(sol);
    }

    public int sol(String input) {

        Stack<String> s = new Stack<>();
        List<String> list = new ArrayList<>();
        Pattern p = Pattern.compile("\\d+|\\D");
        Matcher m = p.matcher(input);

        while (m.find()) {
            String split = m.group();
            list.add(split);
        }

        for (int i = 0; i < list.size(); i++) {
            if (!s.isEmpty() && s.peek().equals("*")) {
                // * 연산자 제거
                s.pop();

                // 계산할 수 가져오기
                String pop = s.pop();

                // 곱셈 계산 후 다시 스택에 입력
                s.push(String.valueOf(Integer.parseInt(pop) * Integer.parseInt(list.get(i))));
            } else {
                s.push(list.get(i));
            }
        }

        int result = Integer.parseInt(s.get(0));

        for (int i = 1; i < s.size(); i += 2) {
            String op = s.get(i);
            switch (op) {
                case "+":
                    result += Integer.parseInt(s.get(i + 1));
                    break;
                case "-":
                    result -= Integer.parseInt(s.get(i + 1));
            }
        }

        return result;
    }
}
