package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class No_10808 {
    public static void main(String[] args) throws IOException {
        Map<Character, Integer> countMap = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        for (char c : alphabet) {
            countMap.put(c, 0);
        }
        for (int i = 0; i < input.length(); i++) {
            countMap.put(input.charAt(i), countMap.get(input.charAt(i)) + 1);
        }

        for (Character key : countMap.keySet()) {
            System.out.print(countMap.get(key)+" ");
        }
    }
}