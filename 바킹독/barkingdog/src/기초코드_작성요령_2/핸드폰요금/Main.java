package 기초코드_작성요령_2.핸드폰요금;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//영식 요금제 30초마다 10원씩 (29초 이하 통화시 10원)
//민식 요금제 60초마다 15원씩
//두 요금이 같으면 영식을 먼저 쓰고 민식을 쓴다.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        String[] input = br.readLine().split(" ");

        int young = 0, min = 0;
        for (String miniute : input) {
            young += (Integer.valueOf(miniute) / 30 + 1) * 10;
            min += (Integer.valueOf(miniute) / 60 + 1) * 15;
        }

        if (young == min) {
            System.out.println("Y M " + young);
        } else if (young > min) {
            System.out.println("M " + min);
        } else {
            System.out.println("Y " + young);
        }
    }
}
