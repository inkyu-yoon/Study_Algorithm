package 바킹독.해시.수강신청;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int K = Integer.parseInt(input[0]), L = Integer.parseInt(input[1]);
        LinkedHashSet<String> set = new LinkedHashSet<>();

        for (int i = 0; i < L; i++) {
            String id = br.readLine();
            if (set.contains(id)) {
                set.remove(id);
                set.add(id);
            } else {
                set.add(id);
            }

        }


        StringBuilder sb = new StringBuilder();
        for (String id : set) {
            sb.append(id + "\n");
            if (--K == 0) {
                break;
            }
        }
        System.out.println(sb);
    }

}
