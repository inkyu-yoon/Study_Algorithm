package 바킹독.dp.돌게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 1개 또는 3개 가져갈 수 있다.
// SK -> CY
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N % 2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }

    }

}
