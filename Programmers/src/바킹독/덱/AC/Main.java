package 바킹독.덱.AC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] cmds = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> dq = new LinkedList<>();
            boolean isError = false;

            Pattern p = Pattern.compile("\\d+");
            String arr = br.readLine();
            Matcher m = p.matcher(arr);
            while (m.find()) {
                int num = Integer.parseInt(m.group());
                dq.offer(num);
            }

            int dir = 1;

            for (String cmd : cmds) {
                switch (cmd) {
                    case "R":
                        dir *= -1;
                        break;
                    case "D":
                        if (dq.isEmpty()) {
                            isError = true;
                        } else {
                            if (dir == 1) {
                                dq.poll();
                            } else {
                                dq.pollLast();
                            }
                        }
                        break;
                }

                if (isError) {
                    break;
                }
            }

            if (isError) {
                System.out.println("error");
            } else {
                System.out.println(convertToString(dq, dir));
            }
        }
    }

    private static String convertToString(Deque<Integer> dq, int dir) {
        StringBuilder sb = new StringBuilder();
        if (dir == 1) {
            for (int i : dq) {
                sb.append(i + ",");
            }
        } else {
            while (!dq.isEmpty()) {
                sb.append(dq.pollLast() + ",");
            }
        }
        if (sb.length() != 0) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return String.format("[%s]", sb);
    }

}
