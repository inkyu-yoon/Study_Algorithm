package 바킹독.배열.strfry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            String[] input = br.readLine().split(" ");

            String[] target = input[0].split("");
            String[] text = input[1].split("");

            Arrays.sort(target);
            Arrays.sort(text);
            boolean flag = true;
            for (int i = 0; i < target.length; i++) {
                if (!target[i].equals(text[i])) {
                    flag = false;
                    break;
                }
            }
            sb.append(flag ? "Possible\n" : "Impossible\n");
        }
        System.out.println(sb);
    }
}
