package 기초코드_작성요령_2.윷놀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //도 A (0 한개) 개 B (0 2개) 걸 C (0 3개) D (0 4개) E (1 4개)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int time = 1; time <= 3; time++) {

            String[] input = br.readLine().split(" ");
            int zero = 0;
            for (int i = 0; i <= 3; i++) {
                if (Integer.valueOf(input[i]) == 0) {
                    zero++;
                }
            }

            if (zero >= 4) {
                System.out.println("D");
            } else if (zero >= 3) {
                System.out.println("C");
            } else if (zero >= 2) {
                System.out.println("B");
            } else if (zero >= 1) {
                System.out.println("A");
            } else {
                System.out.println("E");
            }
        }

    }
}
