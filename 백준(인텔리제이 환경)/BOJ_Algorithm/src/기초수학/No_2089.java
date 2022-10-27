package 기초수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No_2089 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        double input = Double.valueOf(br.readLine());
        if (input == 0) {
            sb.append(0);
        } else {
            while (input != 0) {
                sb.append((int)Math.abs(input % -2));
                input = Math.ceil(input / -2);
            }
        }
        System.out.println(sb.reverse());

    }
}
