package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class No_11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int N = Integer.valueOf(input1[0]);
        int index = Integer.valueOf(input1[1]);

        int[] arr = new int[N];
        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < input2.length; i++) {
            arr[i] = Integer.valueOf(input2[i]);
        }
        Arrays.sort(arr);
        System.out.println(arr[index-1]);

    }
}
