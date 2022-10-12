package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_14659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        int[] array = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.valueOf(input[i]);
        }
        int[] kill = new int[N];
        for (int i = 0; i < array.length; i++) {
            int count = 0;
            for (int j = i+1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    count++;
                } else {
                    break;
                }
            }
            kill[i]=count;
        }
//        System.out.println(Arrays.toString(kill));

        Arrays.sort(kill);
        System.out.println(kill[N - 1]);
    }
}
