package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_11651 {
    public static void main(String[] args) throws IOException {
        //2차원 평면 위의 점 N개가 주어지고 좌표를 y좌표가 증가하는 순으로, y좌표가 같다면 x좌표가 증가하는 순으로
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.valueOf(br.readLine());
        int[][] coordinate = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            coordinate[i][0] = Integer.valueOf(input[0]);
            coordinate[i][1] = Integer.valueOf(input[1]);
        }
  //      System.out.println(Arrays.deepToString(coordinate));
        Arrays.sort(coordinate, (coord1, coord2) -> {
            if (coord1[1] == coord2[1]) {
                return coord1[0] - coord2[0];
            } else {
                return coord1[1] - coord2[1];
            }
        });
  //      System.out.println(Arrays.deepToString(coordinate));

        for (int i = 0; i < N; i++) {
           sb.append(coordinate[i][0] + " " + coordinate[i][1] + "\n");
        }
        System.out.println(sb);


    }
}
