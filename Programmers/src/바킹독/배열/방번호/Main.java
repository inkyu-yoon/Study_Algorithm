package 바킹독.배열.방번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split("")).mapToInt(Integer::valueOf).toArray();
        double[] nums = new double[9];
        for (int i : input) {
            if (i == 6 || i == 9) {
                nums[6] += 0.5;
            } else {
                nums[i]++;
            }
        }
        System.out.println((int)(Math.ceil(Arrays.stream(nums).max().getAsDouble())));

    }
}
