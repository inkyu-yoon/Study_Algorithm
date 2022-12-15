package 배열.Strfry;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    //2번째 문자열이 1번째 문자열로 변환할 수 있는가?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.valueOf(br.readLine());
        while (n-- > 0) {
            String[] input = br.readLine().split(" ");

            String first = String.join("", Arrays.stream(input[0].split("")).sorted().toArray(String[]::new));
            String second = String.join("", Arrays.stream(input[1].split("")).sorted().toArray(String[]::new));

            sb.append(first.equals(second) ? "Possible" : "Impossible").append("\n");
        }
        System.out.println(sb);
    }
}
