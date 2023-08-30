package 바킹독.해시.서로다른부문문자열의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] split = s.split("");

        Set<String> set = new HashSet<>();

        for (int i = 0; i < split.length; i++) {
            String str = split[i];
            set.add(str);
            for (int j = i+1; j < split.length; j++) {
                str += split[j];
                set.add(str);
            }
        }

        System.out.println(set.size());

    }

}
