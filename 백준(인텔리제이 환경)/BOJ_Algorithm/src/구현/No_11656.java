package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] array = new String[input.length()];
        for (int i = 0; i < input.length(); i++) {
            array[i] = input.substring(i, array.length);
        }

        Arrays.sort(array);
        for (String s : array) {
            System.out.println(s);
        }


    }
}
