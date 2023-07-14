package 바킹독.연결리스트.키로거;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder ans = new StringBuilder();
        Stack<String> L = new Stack<>();
        Stack<String> R = new Stack<>();

        while (T-- > 0) {
            StringBuilder sbL = new StringBuilder();
            StringBuilder sbR = new StringBuilder();
            String[] input = br.readLine().split("");
            for (String cmd : input) {
                switch (cmd) {
                    case "<":
                        if (!L.isEmpty()) {
                            R.push(L.pop());
                        }
                        break;
                    case ">":
                        if (!R.isEmpty()) {
                            L.push(R.pop());
                        }
                        break;
                    case "-":
                        if (!L.isEmpty()) {
                            L.pop();
                        }
                        break;
                    default:
                        L.push(cmd);
                }
            }

            L.stream().forEach(s -> sbL.append(s));
            R.stream().forEach(s -> sbR.append(s));
            ans.append(sbL).append(sbR.reverse() + "\n");
            L.clear();
            R.clear();
        }
        System.out.println(ans);

    }
}
