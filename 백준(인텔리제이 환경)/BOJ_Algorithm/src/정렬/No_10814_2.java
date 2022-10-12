package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_10814_2{
    public static void main (String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); //마지막출력용 StringBuilder

        StringBuilder[] stringBuilderArray = new StringBuilder[201];
        for (int i = 0; i < 201; i++){
            stringBuilderArray[i] = new StringBuilder();
            // StringBuilder 배열에 하나씩 StringBuilder 객체를 넣어주지 않으면 마지막에 한번에 출력할때, null 값이 나온다.
            // 하지만, 위와 같이 객체를 하나씩 채워넣어주면, 아무 데이터가 채워지지 않았을 때에도 null 값이 출력 안된다.
        }

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            int age = Integer.valueOf(input[0]);
            String name = input[1];
            stringBuilderArray[age].append(age+" "+name).append("\n");
        }

        for (StringBuilder k : stringBuilderArray){
            sb.append(k);
        } //입력된 데이터들을 쌓음, 나이가 인덱스로서 순서대로 입력되어있으므로, for-each문을 사용하면, 나이순으로 나오고
        // 나이가 같다면 등록 순으로 나올 것

        System.out.println(sb);

    }

}