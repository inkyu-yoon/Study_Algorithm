package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char[] afterChange = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            afterChange[i] = changeROT(input.charAt(i));
        }
        System.out.println(String.valueOf(afterChange));
    }


    static char changeROT(char input) {
        char result=input;
        if (input >= 'a' && input <= 'z') {
            result = (char) (((input - 'a') + 13) % 26 +'a');
        } else if (input >= 'A' && input <= 'Z') {
            result = (char) (((input - 'A') + 13) % 26 +'A');
        }
        return result;
    }

}