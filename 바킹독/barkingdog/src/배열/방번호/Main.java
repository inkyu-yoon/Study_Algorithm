package 배열.방번호;

import java.io.*;
import java.util.*;

//다솜이의 옆집에서는 플라스틱 숫자를 한 세트로 판다. 한 세트에는 0번부터 9번까지 숫자가 하나씩 들어있다.
//다솜이의 방 번호가 주어졌을 때, 필요한 세트의 개수의 최솟값을 출력하시오. (6은 9를 뒤집어서 이용할 수 있고, 9는 6을 뒤집어서 이용할 수 있다.)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split("");
        int[] arr = new int[10];
        int sixAndNine = 0;
        for(String s : input){
            int num = Integer.valueOf(s);
            if (num == 6 || num == 9) {
                sixAndNine++;
            } else {
            arr[num]++;
            }
        }
        int max = Arrays.stream(arr).max().getAsInt();
        int set = (int)Math.max(Math.ceil(sixAndNine / 2.0), max);
        System.out.println(set);
    }
}
/*
9999

2
 */