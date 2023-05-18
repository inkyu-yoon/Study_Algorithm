package 바킹독.이분탐색.수찾기;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int M = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(int num : nums){
            if(Arrays.binarySearch(arr,num)<0){
                sb.append("0\n");
            }else{
                sb.append("1\n");
            }
        }
        System.out.println(sb);

    }
}
