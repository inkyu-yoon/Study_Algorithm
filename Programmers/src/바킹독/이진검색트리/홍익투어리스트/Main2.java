package 바킹독.이진검색트리.홍익투어리스트;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]), Q = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");

        // 명소 등록
        TreeSet<Integer> places = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            if (input[i].equals("1")) {
                places.add(i + 1);
            }
        }

        int doHyun = 1;
        StringBuilder ans = new StringBuilder();

        // 쿼리 수행
        while (Q-- > 0) {
            input = br.readLine().split(" ");
            if (input[0].equals("3")) {
                Integer ceiling = places.ceiling(doHyun);

                int distance = 0;

                // 도현이 위치 뒤에 명소가 없는 경우 (rotate 필요)
                if (ceiling == null) {

                    // 명소가 있는 경우
                    if (!places.isEmpty()) {
                        ceiling = places.first();
                        distance = N - doHyun + ceiling;
                    // 명소가 아예 없는 경우
                    } else {
                        distance = -1;
                    }
                } else {
                    // 도현이 뒤에 명소가 존재하는 경우
                    distance = ceiling - doHyun;
                }

                ans.append(distance + "\n");


            } else {
                int num = Integer.parseInt(input[1]);

                // 명소 추가 혹은 변경
                if (input[0].equals("1")) {
                    if (places.contains(num)) {
                        places.remove(num);
                    } else {
                        places.add(num);
                    }
                // 도현이 이동
                } else {
                    doHyun = (doHyun + num) % N;
                    if (doHyun == 0) {
                        doHyun = N;
                    }
                }
            }
        }

        System.out.println(ans);

    }
}
