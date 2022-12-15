package 배열.방배정;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    // 1학년부터 6학년까지 있다.
    // 남학생은 남학생 끼리 여학생은 여학생끼리 반 배정을 해야한다.
    // 한 방에는 같은 학년의 학생들을 배정해야한다. (한명만 배정도 가능)
    // 한 방에 배정할 수 있는 최대 인원수 K가 주어진다. (남학생은 1)
    // 모든 학생들을 배정하기 위해 필요한 방의 최소 개수를 구하는 프로그램
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int total = Integer.valueOf(input[0]);
        int K = Integer.valueOf(input[1]);
        double[] info = new double[13];

        while (total-- > 0) {
            String[] student = br.readLine().split(" ");
            if (Integer.valueOf(student[0]) == 1) {
                info[Integer.valueOf(student[1])]++;
            } else {
                info[6 + Integer.valueOf(student[1])]++;
            }
        }

        double sum = Arrays.stream(info).map(num -> Math.ceil(num / K)).sum();
        System.out.println((int)sum);

    }
}
