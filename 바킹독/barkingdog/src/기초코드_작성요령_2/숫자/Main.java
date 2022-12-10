package 기초코드_작성요령_2.숫자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//두 양의 정수가 주어졌을 때, 두 수 사이에 있는 정수를 모두 출력하라
// 첫째 줄에는 두수 사이에 있는 수의 개수
// 둘째 줄에는 두 수 사이에 있는 수를 오름차순으로
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] input = br.readLine().split(" ");
        long first = Long.valueOf(input[0])>=Long.valueOf(input[1])?Long.valueOf(input[1]):Long.valueOf(input[0]);
        long second = Long.valueOf(input[0])>=Long.valueOf(input[1])?Long.valueOf(input[0]):Long.valueOf(input[1]);

        if(first==second){
            System.out.println(0);
            return;
        }

        System.out.println(second - first - 1);
        for(long i=first+1;i<second;i++){
            sb.append(i + " ");
        }
        System.out.println(sb);
    }
}
