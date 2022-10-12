package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class No_11651_2 {
    public static void main(String[] args) throws IOException {
        //2차원 평면 위의 점 N개가 주어지고 좌표를 y좌표가 증가하는 순으로, y좌표가 같다면 x좌표가 증가하는 순으로
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.valueOf(br.readLine());
        Integer[][] coordinate = new Integer[N][2];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            coordinate[i][0] = Integer.valueOf(input[0]);
            coordinate[i][1] = Integer.valueOf(input[1]);
        }
        //      System.out.println(Arrays.deepToString(coordinate));
        Arrays.sort(coordinate,new CustomComparator());
        //      System.out.println(Arrays.deepToString(coordinate));

        for (int i = 0; i < N; i++) {
            sb.append(coordinate[i][0] + " " + coordinate[i][1] + "\n");
        }
        System.out.println(sb);


    }

    static class CustomComparator implements Comparator<Integer[]> {
        @Override
        public int compare(Integer[] a1, Integer[] a2) {
            if (a1[1].equals(a2[1])) {
                return a1[0] - a2[0];
            } else {
                return a1[1] - a2[1];
            }
        }
    }

}
