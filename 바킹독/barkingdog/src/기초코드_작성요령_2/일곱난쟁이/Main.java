package 기초코드_작성요령_2.일곱난쟁이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    //일곱 난쟁이들의 키 합은 100
    // 아홉 난쟁이들의 키가 주어짐
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] heights = new int[9];

        int sum = 0;
        for (int i = 1; i <= 9; i++) {
            int input = Integer.valueOf(br.readLine());
            sum += input;
            heights[i - 1] = input;
        }
        Arrays.sort(heights);

        for (int i = 0; i <= 7; i++) {
            for (int j = i + 1; j <= 8; j++) {
                if (sum - (heights[i] + heights[j]) == 100) {
                    for (int height : heights) {
                        if (height == heights[i] || height == heights[j]) {
                            continue;
                        }
                        System.out.println(height);
                    }
                        return;
                }
            }
        }
    }
}
