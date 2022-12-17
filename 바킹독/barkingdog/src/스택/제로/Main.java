package 스택.제로;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    // 재현이는 돈을 실수로 잘못 부루고, 잘못된 수를 부를 때마다 0을 외쳐서 가장 최근에 재민이가 쓴 수를 지우게 시킨다.
    // 이렇게 모든 수를 받아 적은 후 그 수의 합을 구한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.valueOf(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        while(K-- >0){
            int num = Integer.valueOf(br.readLine());
            if (num == 0) {
                count-=stack.pop();
                continue;
            }
            stack.push(num);
            count+=num;
        }
        System.out.println(count);
    }
}
